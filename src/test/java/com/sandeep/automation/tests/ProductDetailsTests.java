package com.sandeep.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sandeep.automation.base.BaseTest;
import com.sandeep.automation.pages.InventoryPage;
import com.sandeep.automation.pages.LoginPage;
import com.sandeep.automation.pages.ProductDetailsPage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

/**
 * ProductDetailsTests class contains tests for product details page functionality.
 * Tests navigation to product details, content verification, and navigation back.
 *
 * @author Sandeep Yadav
 * @version 1.0
 */
@Epic("Product Details Functionality")
@Feature("Product Information Display")
public class ProductDetailsTests extends BaseTest {

    @Test
    @Story("Navigate to Product Details")
    @Description("Verify clicking on product name navigates to product details page")
    public void navigateToProductDetailsTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Click on a product name to navigate to details");
        inventoryPage.clickProductName("Sauce Labs Backpack");

        Allure.step("Verify product details page is loaded");
        Assert.assertTrue(productDetailsPage.areProductDetailsDisplayed());

        Allure.step("Verify product name matches");
        String productName = productDetailsPage.getProductName();
        Assert.assertEquals(productName, "Sauce Labs Backpack");
    }

    @Test
    @Story("Product Details Content")
    @Description("Verify all product information is displayed correctly on details page")
    public void productDetailsContentTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Click on a product name to navigate to details");
        inventoryPage.clickProductName("Sauce Labs Bike Light");

        Allure.step("Verify product name is displayed");
        Assert.assertFalse(productDetailsPage.getProductName().isEmpty());

        Allure.step("Verify product description is displayed");
        Assert.assertFalse(productDetailsPage.getProductDescription().isEmpty());

        Allure.step("Verify product price is displayed");
        String price = productDetailsPage.getProductPrice();
        Assert.assertTrue(price.startsWith("$"));
        Assert.assertFalse(price.isEmpty());

        Allure.step("Verify product image is displayed");
        Assert.assertTrue(productDetailsPage.isProductImageDisplayed());

        Allure.step("Verify back to products button is displayed");
        Assert.assertTrue(productDetailsPage.isBackToProductsButtonDisplayed());
    }

    @Test
    @Story("Back to Products Navigation")
    @Description("Verify back to products button returns to inventory page")
    public void backToProductsNavigationTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Click on a product name to navigate to details");
        inventoryPage.clickProductName("Sauce Labs Bolt T-Shirt");

        Allure.step("Click back to products button");
        productDetailsPage.clickBackToProducts();

        Allure.step("Verify back to inventory page");
        Assert.assertTrue(inventoryPage.isProductListDisplayed());
    }
}