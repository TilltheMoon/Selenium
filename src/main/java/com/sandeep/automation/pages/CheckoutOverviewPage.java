package com.sandeep.automation.pages;

import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage {

    private By finishBtn = By.id("finish");

    public void clickFinish() {
        click(finishBtn);
    }
}