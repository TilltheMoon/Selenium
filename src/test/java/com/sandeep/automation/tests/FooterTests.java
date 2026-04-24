package com.sandeep.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sandeep.automation.base.BaseTest;
import com.sandeep.automation.pages.FooterPage;
import com.sandeep.automation.pages.LoginPage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

/**
 * FooterTests class contains tests for footer functionality on SauceDemo.
 * Tests social media links, copyright information, and footer visibility.
 *
 * @author Sandeep Yadav
 * @version 1.0
 */
@Epic("Footer Functionality")
@Feature("Social Media and Copyright")
public class FooterTests extends BaseTest {

    @Test
    @Story("Social Media Links Display")
    @Description("Verify all social media links are displayed in the footer")
    public void socialMediaLinksDisplayedTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        FooterPage footerPage = new FooterPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Verify Twitter link is displayed");
        Assert.assertTrue(footerPage.isTwitterLinkDisplayed());

        Allure.step("Verify Facebook link is displayed");
        Assert.assertTrue(footerPage.isFacebookLinkDisplayed());

        Allure.step("Verify LinkedIn link is displayed");
        Assert.assertTrue(footerPage.isLinkedInLinkDisplayed());
    }

    @Test
    @Story("Copyright Information")
    @Description("Verify copyright text is displayed correctly")
    public void copyrightTextTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        FooterPage footerPage = new FooterPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Get copyright text");
        String copyright = footerPage.getCopyrightText();

        Allure.step("Verify copyright contains expected text");
        Assert.assertTrue(copyright.contains("2026 Sauce Labs"));
    }

    @Test
    @Story("Social Media Link Navigation")
    @Description("Verify social media links are clickable and navigate to correct domains")
    public void socialMediaLinkNavigationTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        FooterPage footerPage = new FooterPage();

        loginPage.login("standard_user", "secret_sauce");

        String originalWindow = driver.getWindowHandle();

        Allure.step("Click Twitter link and verify navigation");
        footerPage.clickTwitterLink();
        // Switch to new tab/window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("twitter.com") || currentUrl.contains("x.com"));
        driver.close();
        driver.switchTo().window(originalWindow);

        Allure.step("Click Facebook link and verify navigation");
        footerPage.clickFacebookLink();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("facebook.com"));
        driver.close();
        driver.switchTo().window(originalWindow);

        Allure.step("Click LinkedIn link and verify navigation");
        footerPage.clickLinkedInLink();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("linkedin.com"));
        driver.close();
        driver.switchTo().window(originalWindow);
    }
}