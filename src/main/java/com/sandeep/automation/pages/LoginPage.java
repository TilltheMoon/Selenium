package com.sandeep.automation.pages;

import org.openqa.selenium.By;

/**
 * LoginPage class represents the login page of SauceDemo application.
 * Provides methods to interact with login form elements including username,
 * password fields, login button, and error message display.
 *
 * @author Sandeep Yadav
 * @version 1.0
 */
public class LoginPage extends BasePage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("[data-test='error']");

    /**
     * Enters the username in the username field.
     *
     * @param user The username to enter
     */
    public void enterUsername(String user) {
        type(username, user);
    }

    /**
     * Enters the password in the password field.
     *
     * @param pass The password to enter
     */
    public void enterPassword(String pass) {
        type(password, pass);
    }

    /**
     * Clicks the login button to submit the login form.
     */
    public void clickLogin() {
        click(loginBtn);
    }

    /**
     * Performs complete login operation by entering credentials and clicking login.
     *
     * @param user The username for login
     * @param pass The password for login
     */
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    /**
     * Gets the error message displayed on failed login attempts.
     *
     * @return The error message text
     */
    public String getErrorMessage() {
        return getText(errorMsg);
    }
}