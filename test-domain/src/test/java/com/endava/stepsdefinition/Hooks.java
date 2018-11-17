package com.endava.stepsdefinition;

import com.endava.utils.Driver;
import com.endava.utils.TakeScreenshot;
import com.endava.utils.TestLogHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void logger(Scenario scenario){
        TestLogHelper.startTestLogging(scenario.getName().toLowerCase().replaceAll("\\s+", "_"));
    }

    @AfterStep
    public void takeScreen(Scenario scenario) throws Exception {
        TakeScreenshot screenshot = new TakeScreenshot();
        screenshot.takeScreenShoots(scenario);
        Thread.sleep(1000);
    }

    @After
    public void closeDrivers() {
        TestLogHelper.stopTestLogging();
        Driver.quitDriver();
    }
}
