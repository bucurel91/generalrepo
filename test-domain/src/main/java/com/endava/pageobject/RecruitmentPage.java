package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage extends PageObject {

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@id='candidateSearch_jobTitle']")
    private WebElement jobTitleFieldCanditatesPages;

    @FindBy(xpath = "//input[@id='btnSrch']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@id='btnDelete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    private WebElement checkboxAll;

    @FindBy(xpath = "//input[@id='candidateSearch_candidateName']")
    private WebElement canditateNameFieldCanditatesPage;

    @FindBy(xpath = "//a[contains(text(),'Lahanta')]")
    private WebElement candidate;

    @FindBy(xpath = "//div[contains(@class, 'message success fadable')]")
    private WebElement successMessage;

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    private WebElement recruitmentButtonDashboardPage;

    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    private  WebElement dialogDeleteButton;
}
