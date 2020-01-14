package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "txtUsername")
    private WebElement usernameFieldLoginPage;

    @FindBy(name = "txtPassword")
    private WebElement passwordFieldLoginPage;

    @FindBy(xpath = "//input[@id='btnLogin']")
    private WebElement submitButtonLoginPage;

    @FindBy(id = "logInPanelHeading")
    private WebElement textHeaderLoginPage;
}
