package com.sandeep.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.sandeep.automation.config.ConfigReader;
import com.sandeep.automation.drivers.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {

        // Initialize driver from DriverFactory
        DriverFactory.initializeDriver(browser);

        driver = DriverFactory.getDriver();

        driver.manage().window().maximize();

        // Load base URL from config
        String baseUrl = ConfigReader.getInstance().getProperty("baseUrl");

        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}