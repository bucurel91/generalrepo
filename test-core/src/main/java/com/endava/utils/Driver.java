package com.endava.utils;

import com.endava.exceptions.NotInitializedWebDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() throws NotInitializedWebDriverException {
        String driverType = PropertyManager.getInstance().getBrowser();

        if(driver == null) {
            try {
                switch (driverType.toLowerCase()) {
                    case ("firefox"):
                        driver = new FirefoxDriver();
                        break;
                    default:
                        driver = new ChromeDriver();
                }
            } catch (Exception err) {
                throw new NotInitializedWebDriverException("Driver can not be initialized", err);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
