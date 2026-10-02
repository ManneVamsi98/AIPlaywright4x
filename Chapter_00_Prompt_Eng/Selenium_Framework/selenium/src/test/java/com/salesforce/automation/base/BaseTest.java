package com.salesforce.automation.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    private static final String DEFAULT_BASE_URL = "https://login.salesforce.com/?locale=in";

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    @BeforeTest(alwaysRun = true)
    protected void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        DRIVER.set(webDriver);
    }

    @BeforeMethod(alwaysRun = true)
    protected void openApplication() {
        driver().get(resolveBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    protected void resetBrowserSession() {
        WebDriver currentDriver = DRIVER.get();
        if (currentDriver != null) {
            currentDriver.manage().deleteAllCookies();
        }
    }

    @AfterTest(alwaysRun = true)
    protected void quitDriver() {
        WebDriver currentDriver = DRIVER.get();
        if (currentDriver != null) {
            currentDriver.quit();
            DRIVER.remove();
        }
    }

    protected WebDriver driver() {
        WebDriver currentDriver = DRIVER.get();
        if (currentDriver == null) {
            throw new IllegalStateException("WebDriver has not been initialized for the current thread.");
        }
        return currentDriver;
    }

    protected String requiredCredential(String key) {
        String value = System.getenv(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Required environment variable is not set: " + key);
        }
        return value;
    }

    private String resolveBaseUrl() {
        String configuredUrl = System.getenv("SALESFORCE_URL");
        if (configuredUrl == null || configuredUrl.isBlank()) {
            return DEFAULT_BASE_URL;
        }
        return configuredUrl;
    }
}
