package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends PageObject {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
    private WebElement userNameFieldAdminPage;

    @FindBy(xpath = "//input[@id='searchBtn']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    private WebElement checkboxAll;

    @FindBy(xpath = "//input[@id='btnDelete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    private WebElement dialogDeleteButton;

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    private WebElement systemUserHeaderAdminPage;

    @FindBy(xpath = "//div[contains(@class, 'message success fadable')]")
    private WebElement deleteSuccessfulMessage;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement editButton;
}
