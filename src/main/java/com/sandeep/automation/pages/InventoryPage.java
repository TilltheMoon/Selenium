package com.sandeep.automation.pages;

import org.openqa.selenium.By;

/**
 * InventoryPage class represents the product inventory page of SauceDemo.
 * Provides methods to interact with product list, cart operations,
 * and navigation elements.
 *
 * @author Sandeep Yadav
 * @version 1.0
 */
public class InventoryPage extends BasePage {

    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By addBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By addFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By addOnesie = By.id("add-to-cart-sauce-labs-onesie");
    private By addRedTShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");
    private By productList = By.className("inventory_list");
    private By sortDropdown = By.className("product_sort_container");
    private By hamburgerMenu = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    private By resetAppState = By.id("reset_sidebar_link");

    /**
     * Adds Sauce Labs Backpack to cart.
     */
    public void addBackpackToCart() {
        click(addBackpack);
    }

    /**
     * Adds Sauce Labs Bike Light to cart.
     */
    public void addBikeLightToCart() {
        click(addBikeLight);
    }

    /**
     * Adds Sauce Labs Bolt T-Shirt to cart.
     */
    public void addBoltTShirtToCart() {
        click(addBoltTShirt);
    }

    /**
     * Adds Sauce Labs Fleece Jacket to cart.
     */
    public void addFleeceJacketToCart() {
        click(addFleeceJacket);
    }

    /**
     * Adds Sauce Labs Onesie to cart.
     */
    public void addOnesieToCart() {
        click(addOnesie);
    }

    /**
     * Adds Test.allTheThings() T-Shirt (Red) to cart.
     */
    public void addRedTShirtToCart() {
        click(addRedTShirt);
    }

    /**
     * Opens the shopping cart.
     */
    public void openCart() {
        click(cartIcon);
    }

    /**
     * Gets the cart badge count.
     *
     * @return The number of items in cart as string
     */
    public String getCartCount() {
        return getText(cartBadge);
    }

    /**
     * Checks if the cart badge is visible.
     *
     * @return true if the cart badge is displayed
     */
    public boolean isCartBadgeDisplayed() {
        return isElementDisplayed(cartBadge);
    }

    /**
     * Checks if product list is displayed.
     *
     * @return true if product list is visible
     */
    public boolean isProductListDisplayed() {
        return isElementDisplayed(productList);
    }

    /**
     * Sorts products by name in ascending order (A-Z).
     */
    public void sortByNameAsc() {
        click(sortDropdown);
        waitUtils.waitForPageLoad();
        click(By.cssSelector("[value='az']"));
    }

    /**
     * Sorts products by name in descending order (Z-A).
     */
    public void sortByNameDesc() {
        click(sortDropdown);
        waitUtils.waitForPageLoad();
        click(By.cssSelector("[value='za']"));
    }

    /**
     * Sorts products by price from low to high.
     */
    public void sortByPriceLowToHigh() {
        click(sortDropdown);
        waitUtils.waitForPageLoad();
        click(By.cssSelector("[value='lohi']"));
    }

    /**
     * Sorts products by price from high to low.
     */
    public void sortByPriceHighToLow() {
        click(sortDropdown);
        waitUtils.waitForPageLoad();
        click(By.cssSelector("[value='hilo']"));
    }

    /**
     * Opens the hamburger menu.
     */
    public void openHamburgerMenu() {
        click(hamburgerMenu);
    }

    /**
     * Logs out the current user.
     */
    public void logout() {
        openHamburgerMenu();
        click(logoutLink);
    }

    /**
     * Resets the application state.
     */
    public void resetAppState() {
        openHamburgerMenu();
        click(resetAppState);
    }

    /**
     * Clicks on a product name to navigate to product details page.
     *
     * @param productName The name of the product to click
     */
    public void clickProductName(String productName) {
        click(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
    }
}