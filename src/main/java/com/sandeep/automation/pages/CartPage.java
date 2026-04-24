package com.sandeep.automation.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private By checkoutBtn = By.id("checkout");
    private By removeBackpackBtn = By.id("remove-sauce-labs-backpack");
    private By continueShoppingBtn = By.id("continue-shopping");
    private By cartList = By.className("cart_list");
    private By cartItem = By.className("cart_item");

    public void clickCheckout() {
        click(checkoutBtn);
    }

    public void removeBackpackFromCart() {
        click(removeBackpackBtn);
    }

    public void clickContinueShopping() {
        click(continueShoppingBtn);
    }

    public boolean isCartPageDisplayed() {
        return isElementDisplayed(cartList);
    }

    public boolean isCartEmpty() {
        return !isElementDisplayed(cartItem);
    }
}