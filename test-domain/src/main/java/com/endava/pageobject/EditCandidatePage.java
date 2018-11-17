package com.endava.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCandidatePage extends PageObject {

    public EditCandidatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@id='addCandidate_comment']")
    private WebElement commentFieldAddCandidatePage;

    @FindBy(xpath = "//input[@id='addCandidate_contactNo']")
    private WebElement contactNoFieldAddCandidatePage;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement editButton;

    @FindBy(xpath = "//h1[@id='addCandidateHeading']")
    private WebElement candidateHeader;

    @FindBy(xpath = "//div[contains(@class, 'message success fadable')]")
    private WebElement successMessage;

    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    private  WebElement dialogDeleteButton;
}
