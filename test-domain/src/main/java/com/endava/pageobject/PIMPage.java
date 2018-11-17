package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPage extends PageObject {

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='empsearch_employee_name_empName']")
    private WebElement employeeNameFieldPimPage;

    @FindBy(xpath = "//input[@id='searchBtn']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    private WebElement checkboxAll;

    @FindBy(xpath = "//input[@id='btnDelete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@id='empsearch_id']")
    private WebElement fieldIDPimPage;

    @FindBy(xpath = "//select[@id='empsearch_employee_status']")
    private WebElement dropDownEmployeeStatus;

    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    private WebElement dialogDeleteButton;
}