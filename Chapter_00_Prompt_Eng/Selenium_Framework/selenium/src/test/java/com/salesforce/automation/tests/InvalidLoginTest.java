package com.salesforce.automation.tests;

import com.salesforce.automation.base.BaseTest;
import com.salesforce.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test(description = "Verify that an incorrect password does not authenticate the user")
    public void invalidPasswordDoesNotAuthenticateUser() {
        LoginPage loginPage = new LoginPage(driver());
        String invalidPassword = requiredCredential("SALESFORCE_PASSWORD") + "-invalid-credential";
        loginPage.login(
                requiredCredential("SALESFORCE_USERNAME"),
                invalidPassword);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "The login form was not displayed after a failed login attempt.");
        Assert.assertTrue(loginPage.isOnLoginUrl(),
                "The user was redirected away from the login page after an invalid login.");
    }
}
