package com.sandeep.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sandeep.automation.base.BaseTest;
import com.sandeep.automation.pages.CartPage;
import com.sandeep.automation.pages.InventoryPage;
import com.sandeep.automation.pages.LoginPage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;

import org.testng.annotations.Listeners;

@Epic("Cart Functionality")
@Feature("Shopping Cart Management")
@Listeners({AllureTestNg.class})
public class CartTests extends BaseTest {

    @Test
    @Story("Add Product to Cart")
    @Description("Add a product to cart and verify cart badge")
    public void addProductToCartTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Add backpack to cart");
        inventoryPage.addBackpackToCart();

        Allure.step("Verify cart count is 1");
        String count = inventoryPage.getCartCount();
        Assert.assertEquals(count, "1");
    }

    @Test
    @Story("Open Cart")
    @Description("Open cart and verify cart page")
    public void openCartTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Add product to cart");
        inventoryPage.addBackpackToCart();

        Allure.step("Open cart");
        inventoryPage.openCart();

        Allure.step("Verify cart page is displayed");
        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @Test
    @Story("Remove Product from Cart")
    @Description("Remove product from cart and verify")
    public void removeProductFromCartTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Add product to cart");
        inventoryPage.addBackpackToCart();

        Allure.step("Open cart");
        inventoryPage.openCart();

        Allure.step("Remove product from cart");
        CartPage cartPage = new CartPage();
        cartPage.removeBackpackFromCart();

        Allure.step("Verify cart is empty");
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @Test
    @Story("Continue Shopping")
    @Description("Continue shopping from cart")
    public void continueShoppingTest() {

        Allure.step("Login with valid credentials");
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Add product to cart");
        inventoryPage.addBackpackToCart();

        Allure.step("Open cart");
        inventoryPage.openCart();

        Allure.step("Click continue shopping");
        CartPage cartPage = new CartPage();
        cartPage.clickContinueShopping();

        Allure.step("Verify back to inventory page");
        Assert.assertTrue(inventoryPage.isProductListDisplayed());
    }
}