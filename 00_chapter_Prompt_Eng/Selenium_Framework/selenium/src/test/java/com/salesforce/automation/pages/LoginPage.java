package com.salesforce.automation.pages;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(20);

    private static final String LOGIN_HOST = "login.salesforce.com";

    private final WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUsername(String username) {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameField)).clear();
            usernameField.sendKeys(username);
        } catch (TimeoutException | NoSuchElementException exception) {
            throw new IllegalStateException("Username field was not available on the Salesforce login page.", exception);
        }
        return this;
    }

    public LoginPage enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
            passwordField.sendKeys(password);
        } catch (TimeoutException | NoSuchElementException exception) {
            throw new IllegalStateException("Password field was not available on the Salesforce login page.", exception);
        }
        return this;
    }

    public LoginPage submit() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (TimeoutException | NoSuchElementException exception) {
            throw new IllegalStateException("Login button was not clickable on the Salesforce login page.", exception);
        }
        return this;
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        submit();
    }

    public boolean isLoginPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public boolean isOnLoginUrl() {
        return driver.getCurrentUrl().contains(LOGIN_HOST);
    }

    public boolean isAuthenticated() {
        try {
            return wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(LOGIN_HOST)));
        } catch (TimeoutException exception) {
            return false;
        }
    }
}
