package com.sandeep.automation.pages;

import org.openqa.selenium.By;

/**
 * ProductDetailsPage class represents the product details page of SauceDemo.
 * Provides methods to interact with individual product details, images,
 * descriptions, and navigation back to products.
 *
 * @author Sandeep Yadav
 * @version 1.0
 */
public class ProductDetailsPage extends BasePage {

    private By productName = By.className("inventory_details_name");
    private By productDescription = By.className("inventory_details_desc");
    private By productPrice = By.className("inventory_details_price");
    private By productImage = By.className("inventory_details_img");
    private By backToProductsButton = By.id("back-to-products");
    private By addToCartButton = By.cssSelector("button[data-test*='add-to-cart']");

    /**
     * Gets the product name from the details page.
     *
     * @return The product name text
     */
    public String getProductName() {
        return getText(productName);
    }

    /**
     * Gets the product description from the details page.
     *
     * @return The product description text
     */
    public String getProductDescription() {
        return getText(productDescription);
    }

    /**
     * Gets the product price from the details page.
     *
     * @return The product price text
     */
    public String getProductPrice() {
        return getText(productPrice);
    }

    /**
     * Checks if the product image is displayed.
     *
     * @return true if product image is visible
     */
    public boolean isProductImageDisplayed() {
        return isElementDisplayed(productImage);
    }

    /**
     * Checks if the back to products button is displayed.
     *
     * @return true if back button is visible
     */
    public boolean isBackToProductsButtonDisplayed() {
        return isElementDisplayed(backToProductsButton);
    }

    /**
     * Clicks the back to products button to return to inventory page.
     */
    public void clickBackToProducts() {
        click(backToProductsButton);
    }

    /**
     * Adds the product to cart from the details page.
     */
    public void addToCart() {
        click(addToCartButton);
    }

    /**
     * Checks if all product details are displayed.
     *
     * @return true if name, description, price, and image are all visible
     */
    public boolean areProductDetailsDisplayed() {
        return isElementDisplayed(productName) &&
               isElementDisplayed(productDescription) &&
               isElementDisplayed(productPrice) &&
               isElementDisplayed(productImage);
    }
}