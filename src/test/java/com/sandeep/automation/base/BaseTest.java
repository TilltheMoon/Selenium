package com.sandeep.automation.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.sandeep.automation.config.ConfigReader;
import com.sandeep.automation.drivers.DriverFactory;
import com.sandeep.automation.utils.ScreenshotUtils;

import io.qameta.allure.Attachment;

public class BaseTest {

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected ScreenshotUtils screenshotUtils;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Setting up test with browser: " + browser);

        // Initialize driver from DriverFactory
        DriverFactory.initializeDriver(browser);

        driver = DriverFactory.getDriver();
        screenshotUtils = new ScreenshotUtils();

        driver.manage().window().maximize();

        // Load base URL from config
        String baseUrl = ConfigReader.getInstance().getProperty("baseUrl");
        logger.info("Navigating to base URL: " + baseUrl);

        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        logger.info("Tearing down test: " + result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test failed: " + result.getName());
            takeScreenshotOnFailure(result.getName());
        }

        DriverFactory.quitDriver();
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] takeScreenshotOnFailure(String testName) {
        logger.info("Taking screenshot for failed test: " + testName);
        // For Allure attachment, return byte array
        return ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
    }
}