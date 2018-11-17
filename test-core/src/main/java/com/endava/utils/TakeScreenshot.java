package com.endava.utils;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot {

    private static final String SCREENSHOT_TARGET_PATH = "target\\screenshoots\\";

    public void takeScreenShoots(Scenario scenario) throws Exception {
        File scr = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        new File (SCREENSHOT_TARGET_PATH).mkdir();
        File directory = new File(SCREENSHOT_TARGET_PATH + scenario.getName());
        directory.mkdir();
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh-mm-ss.SS");
        File destination =new File(formatter.format(time) + ".png");
        FileUtils.copyFile(scr, destination);
        FileUtils.moveFileToDirectory(destination,directory,true);
    }
}
