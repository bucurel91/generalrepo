package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserPage extends PageObject {

    public EditUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='systemUser_userName']")
    private WebElement userNameFieldEditUserPage;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'message success fadable')]")
    private WebElement updateSuccessfulMessage;
}
