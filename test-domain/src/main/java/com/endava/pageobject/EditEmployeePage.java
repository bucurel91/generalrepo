package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditEmployeePage extends PageObject {

    public EditEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement editButton;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@id='personal_txtLicenNo']")
    private WebElement driverLicenceFieldEditEmployeePage;

    @FindBy(xpath = "//input[@id='personal_txtLicExpDate']")
    private WebElement licenceExDateFieldEditEmployeePage;

    @FindBy(xpath = "//img[@id='empPic']")
    private WebElement fotoSpace;

    @FindBy(xpath = "//div[@id='pdMainContainer']/div[contains(@class, 'head')]/h1")
    private WebElement editEmployeeHeader;

    @FindBy(xpath = "//div[contains(@class, 'message success fadable')]")
    private WebElement successMessage;
}
