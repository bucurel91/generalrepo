package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCandidatePage extends PageObject {

    public AddCandidatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='addCandidate_firstName']")
    private WebElement firstNameFieldAddCandidatePage;

    @FindBy(xpath = "//input[@id='addCandidate_lastName']")
    private WebElement lastNameFieldAddCandidatePage;

    @FindBy(xpath = "//input[@id='addCandidate_email']")
    private WebElement emailFieldAddCandidatePage;

    @FindBy(xpath = "//input[@id='addCandidate_contactNo']")
    private WebElement contactNoFieldAddCandidatePage;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[contains(@class, 'toggle tiptip')]")
    private  WebElement candidatesHeaderAddCanditate;

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    private WebElement recruitmentButtonDashboardPage;

    @FindBy(xpath = "//h1[@id='addCandidateHeading']")
    private WebElement addCandidateHeading;

    @FindBy(xpath = "//h1[contains(text(),\"Candidate's History\")]")
    private WebElement candidateHystory;

    @FindBy(xpath = "//div[contains(@class, 'message success fadable')]")
    private WebElement successMessage;
}
