package com.salesforce.automation.tests;

import com.salesforce.automation.base.BaseTest;
import com.salesforce.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {

    @Test(description = "Verify that an active Salesforce account is authenticated with valid credentials")
    public void validCredentialsAuthenticateUser() {
        LoginPage loginPage = new LoginPage(driver());
        loginPage.login(
                requiredCredential("SALESFORCE_USERNAME"),
                requiredCredential("SALESFORCE_PASSWORD"));
        Assert.assertTrue(loginPage.isAuthenticated(),
                "Valid credentials did not reach an authenticated state.");
    }
}
