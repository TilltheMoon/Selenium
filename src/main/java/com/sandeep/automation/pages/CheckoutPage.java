package com.sandeep.automation.pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");

    public void enterFirstName(String fname) {
        type(firstName, fname);
    }

    public void enterLastName(String lname) {
        type(lastName, lname);
    }

    public void enterPostalCode(String zip) {
        type(postalCode, zip);
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public void fillCheckoutInfo(String fname, String lname, String zip) {
        enterFirstName(fname);
        enterLastName(lname);
        enterPostalCode(zip);
        clickContinue();
    }
}