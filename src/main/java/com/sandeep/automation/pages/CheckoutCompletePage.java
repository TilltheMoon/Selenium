package com.sandeep.automation.pages;

import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {

    private By confirmationMsg = By.className("complete-header");

    public String getConfirmationMessage() {
        return getText(confirmationMsg);
    }
}