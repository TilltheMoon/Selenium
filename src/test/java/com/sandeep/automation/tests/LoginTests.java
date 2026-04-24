package com.sandeep.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sandeep.automation.base.BaseTest;
import com.sandeep.automation.pages.LoginPage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;

import org.testng.annotations.Listeners;

@Epic("Login Functionality")
@Feature("User Authentication")
@Listeners({AllureTestNg.class})
public class LoginTests extends BaseTest {

    @Test
    @Story("Valid Login")
    @Description("Test valid login with correct credentials")
    public void validLoginTest() {

        Allure.step("Initialize LoginPage");
        LoginPage loginPage = new LoginPage();

        Allure.step("Perform login with valid credentials");
        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Verify navigation to inventory page");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    @Story("Locked User Login")
    @Description("Test login with locked out user")
    public void lockedUserLoginTest() {

        Allure.step("Initialize LoginPage");
        LoginPage loginPage = new LoginPage();

        Allure.step("Attempt login with locked user credentials");
        loginPage.login("locked_out_user", "secret_sauce");

        Allure.step("Verify locked user error message");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Sorry, this user has been locked out"));
    }
}