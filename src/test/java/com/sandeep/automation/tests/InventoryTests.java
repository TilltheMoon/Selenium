package com.sandeep.automation.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sandeep.automation.base.BaseTest;
import com.sandeep.automation.pages.InventoryPage;
import com.sandeep.automation.pages.LoginPage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;

import org.testng.annotations.Listeners;

@Epic("Inventory Functionality")
@Feature("Product Management")
@Listeners({AllureTestNg.class})
public class InventoryTests extends BaseTest {

    @Test
    @Story("Verify Product List")
    @Description("Verify that products are displayed on inventory page")
    public void verifyProductListTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Initialize InventoryPage");
        InventoryPage inventoryPage = new InventoryPage();

        Allure.step("Verify product list is displayed");
        Assert.assertTrue(inventoryPage.isProductListDisplayed());
    }

    @Test
    @Story("Add Product to Cart")
    @Description("Add a product to cart and verify cart badge")
    public void addProductToCartTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Initialize InventoryPage");
        InventoryPage inventoryPage = new InventoryPage();

        Allure.step("Add backpack to cart");
        inventoryPage.addBackpackToCart();

        Allure.step("Verify cart count is 1");
        String count = inventoryPage.getCartCount();
        Assert.assertEquals(count, "1");
    }

    @Test
    @Story("Verify Cart Badge")
    @Description("Verify cart badge updates correctly")
    public void verifyCartBadgeTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Initialize InventoryPage");
        InventoryPage inventoryPage = new InventoryPage();

        Allure.step("Add multiple products to cart");
        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();

        Allure.step("Verify cart count is 2");
        String count = inventoryPage.getCartCount();
        Assert.assertEquals(count, "2");
    }

    @Test
    @Story("Sort Products by Name A-Z")
    @Description("Verify products can be sorted alphabetically A-Z")
    public void sortProductsByNameAscTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Sort products by name A-Z");
        inventoryPage.sortByNameAsc();

        Allure.step("Verify product list is still displayed");
        Assert.assertTrue(inventoryPage.isProductListDisplayed());
    }

    @Test
    @Story("Sort Products by Name Z-A")
    @Description("Verify products can be sorted alphabetically Z-A")
    public void sortProductsByNameDescTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Sort products by name Z-A");
        inventoryPage.sortByNameDesc();

        Allure.step("Verify product list is still displayed");
        Assert.assertTrue(inventoryPage.isProductListDisplayed());
    }

    @Test
    @Story("Sort Products by Price Low to High")
    @Description("Verify products can be sorted by price low to high")
    public void sortProductsByPriceLowToHighTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Sort products by price low to high");
        inventoryPage.sortByPriceLowToHigh();

        Allure.step("Verify product list is still displayed");
        Assert.assertTrue(inventoryPage.isProductListDisplayed());
    }

    @Test
    @Story("Sort Products by Price High to Low")
    @Description("Verify products can be sorted by price high to low")
    public void sortProductsByPriceHighToLowTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Sort products by price high to low");
        inventoryPage.sortByPriceHighToLow();

        Allure.step("Verify product list is still displayed");
        Assert.assertTrue(inventoryPage.isProductListDisplayed());
    }

    @Test
    @Story("Add All Products to Cart")
    @Description("Add all available products to cart")
    public void addAllProductsToCartTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Add all products to cart");
        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();
        inventoryPage.addBoltTShirtToCart();
        inventoryPage.addFleeceJacketToCart();
        inventoryPage.addOnesieToCart();
        inventoryPage.addRedTShirtToCart();

        Allure.step("Verify cart count is 6");
        String count = inventoryPage.getCartCount();
        Assert.assertEquals(count, "6");
    }

    @Test
    @Story("Logout Functionality")
    @Description("Verify user can logout successfully")
    public void logoutTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Logout from application");
        inventoryPage.logout();

        Allure.step("Verify back to login page");
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    }

    @Test
    @Story("Reset App State")
    @Description("Verify app state can be reset")
    public void resetAppStateTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Add product to cart");
        inventoryPage.addBackpackToCart();

        Allure.step("Reset app state");
        inventoryPage.resetAppState();

        Allure.step("Verify cart is empty");
        Assert.assertFalse(inventoryPage.isCartBadgeDisplayed());
    }
}