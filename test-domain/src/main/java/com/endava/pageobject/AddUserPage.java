package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends PageObject{

    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    private WebElement employeeNameFieldAddUserPage;

    @FindBy(xpath = "//input[@id='systemUser_userName']")
    private WebElement userNameFieldAddUserPage;

    @FindBy(xpath = "//input[@id='systemUser_password']")
    private WebElement passwordFieldAddUserPage;

    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    private WebElement confirmPasswordFieldAddUserPage;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'message success fadable')]")
    private WebElement addedSuccessfulMessage;
}
