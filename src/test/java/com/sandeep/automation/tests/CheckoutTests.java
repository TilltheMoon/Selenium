package com.sandeep.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sandeep.automation.base.BaseTest;
import com.sandeep.automation.pages.*;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;

import org.testng.annotations.Listeners;

@Epic("Checkout Functionality")
@Feature("Order Processing")
@Listeners({AllureTestNg.class})
public class CheckoutTests extends BaseTest {

    @Test(retryAnalyzer = com.sandeep.automation.base.RetryAnalyzer.class)
    @Story("Complete Checkout")
    @Description("Complete full checkout process")
    public void completeCheckoutTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();
        CheckoutCompletePage completePage = new CheckoutCompletePage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Add product to cart");
        inventoryPage.addBackpackToCart();

        Allure.step("Open cart");
        inventoryPage.openCart();

        Allure.step("Click checkout");
        cartPage.clickCheckout();

        Allure.step("Fill checkout information");
        checkoutPage.fillCheckoutInfo("Sandeep", "Yadav", "201001");

        Allure.step("Click finish");
        overviewPage.clickFinish();

        Allure.step("Verify order confirmation");
        Assert.assertTrue(completePage.getConfirmationMessage().contains("Thank you"));
    }
}