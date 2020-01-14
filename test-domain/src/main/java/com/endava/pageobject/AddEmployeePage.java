package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends PageObject {

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameFieldAddEmployee;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameFieldAddEmployee;

    @FindBy(xpath = "//input[@id='employeeId']")
    private WebElement employeeIdFieldAddEmployee;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
    private WebElement employeeListSubTab;

    @FindBy(xpath = "//div[contains(@class, 'message success fadable')]")
    private WebElement successMessage;
}
