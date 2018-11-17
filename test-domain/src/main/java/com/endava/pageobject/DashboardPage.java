package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageObject {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='welcome']")
    private WebElement adminMessageDashboard;

    @FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
    private WebElement adminButtonDashboardPage;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    private WebElement pimButtonDashboardPage;

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    private WebElement recruitmentButtonDashboardPage;
}
