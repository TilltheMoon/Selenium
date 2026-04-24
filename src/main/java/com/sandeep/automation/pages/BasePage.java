package com.sandeep.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sandeep.automation.drivers.DriverFactory;
import com.sandeep.automation.utils.WaitUtils;

/**
 * BasePage class provides common functionality for all page objects in the framework.
 * It includes WebDriver initialization, logging, and reusable methods for element interactions.
 * All page classes should extend this class to inherit common behavior.
 *
 * @author Sandeep Yadav
 * @version 1.0
 */
public class BasePage {

    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WaitUtils waitUtils;

    /**
     * Constructor initializes WebDriver and utility classes.
     * Sets up logging and wait utilities for element interactions.
     */
    public BasePage() {
        driver = DriverFactory.getDriver();
        waitUtils = new WaitUtils();
        logger.debug("BasePage initialized");
    }

    /**
     * Clicks on the specified element after waiting for it to be clickable.
     *
     * @param locator The By locator of the element to click
     */
    protected void click(By locator) {
        logger.debug("Clicking on element: " + locator);
        WebElement element = waitUtils.waitForElementToBeClickable(locator);
        element.click();
        logger.debug("Clicked on element: " + locator);
    }

    /**
     * Types the specified text into the element after clearing it and waiting for visibility.
     *
     * @param locator The By locator of the input element
     * @param text The text to type into the element
     */
    protected void type(By locator, String text) {
        logger.debug("Typing text into element: " + locator);
        WebElement element = waitUtils.waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
        logger.debug("Typed text into element: " + locator);
    }

    /**
     * Gets the text content of the specified element after waiting for visibility.
     *
     * @param locator The By locator of the element
     * @return The text content of the element
     */
    protected String getText(By locator) {
        logger.debug("Getting text from element: " + locator);
        WebElement element = waitUtils.waitForElementToBeVisible(locator);
        String text = element.getText();
        logger.debug("Got text: " + text + " from element: " + locator);
        return text;
    }

    /**
     * Checks if the specified element is displayed on the page.
     *
     * @param locator The By locator of the element
     * @return true if element is displayed, false otherwise
     */
    protected boolean isElementDisplayed(By locator) {
        logger.debug("Checking if element is displayed: " + locator);
        try {
            boolean displayed = waitUtils.waitForElementToBeVisible(locator, 5).isDisplayed();
            logger.debug("Element displayed: " + displayed + " for locator: " + locator);
            return displayed;
        } catch (Exception e) {
            logger.debug("Element not displayed: " + locator);
            return false;
        }
    }
}