package com.sandeep.automation.pages;

import org.openqa.selenium.By;

/**
 * FooterPage class represents the footer section of SauceDemo.
 * Provides methods to interact with footer elements like social media links
 * and copyright information.
 *
 * @author Sandeep Yadav
 * @version 1.0
 */
public class FooterPage extends BasePage {

    private By twitterLink = By.cssSelector("a[href*='twitter']");
    private By facebookLink = By.cssSelector("a[href*='facebook']");
    private By linkedinLink = By.cssSelector("a[href*='linkedin']");
    private By copyrightText = By.className("footer_copy");

    /**
     * Clicks on the Twitter social media link.
     */
    public void clickTwitterLink() {
        click(twitterLink);
    }

    /**
     * Clicks on the Facebook social media link.
     */
    public void clickFacebookLink() {
        click(facebookLink);
    }

    /**
     * Clicks on the LinkedIn social media link.
     */
    public void clickLinkedInLink() {
        click(linkedinLink);
    }

    /**
     * Gets the copyright text from the footer.
     *
     * @return The copyright text
     */
    public String getCopyrightText() {
        return getText(copyrightText);
    }

    /**
     * Checks if the Twitter link is displayed.
     *
     * @return true if Twitter link is visible
     */
    public boolean isTwitterLinkDisplayed() {
        return isElementDisplayed(twitterLink);
    }

    /**
     * Checks if the Facebook link is displayed.
     *
     * @return true if Facebook link is visible
     */
    public boolean isFacebookLinkDisplayed() {
        return isElementDisplayed(facebookLink);
    }

    /**
     * Checks if the LinkedIn link is displayed.
     *
     * @return true if LinkedIn link is visible
     */
    public boolean isLinkedInLinkDisplayed() {
        return isElementDisplayed(linkedinLink);
    }
}