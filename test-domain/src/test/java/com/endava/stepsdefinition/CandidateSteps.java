package com.endava.stepsdefinition;

import com.endava.context.DataKeys;
import com.endava.context.ScenarioContext;
import com.endava.exceptions.NotInitializedWebDriverException;
import com.endava.pageobject.*;
import com.endava.utils.Driver;
import com.endava.utils.ReflectionsUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import static com.endava.assertions.CustomAssertion.assertThat;
import static org.hamcrest.core.Is.is;

public class CandidateSteps {

    ReflectionsUtils reflection = new ReflectionsUtils();

    @When("^admin fills mandatory fields$")
    public void fillMandatoryFieldsOfCandidate(DataTable table) throws IllegalAccessException, NotInitializedWebDriverException {
        String firstName = table.cell(1, 0);
        String lastName = table.cell(1, 1);
        String email = table.cell(1, 2);

        AddCandidatePage addCandidatePage = new AddCandidatePage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, addCandidatePage);

        reflection.getWebElementByClass("firstNameFieldAddCandidatePage").sendKeys(firstName);
        reflection.getWebElementByClass("lastNameFieldAddCandidatePage").sendKeys(lastName);
        reflection.getWebElementByClass("emailFieldAddCandidatePage").sendKeys(email);

        assertThat("Admin is on Add Candidate Page", reflection.getWebElementByClass("addCandidateHeading")
                .getText(), is("Add Candidate"));
    }

    @Then("^candidate is successfully saved.$")
    public void checkSavedCanditate() throws IllegalAccessException {
        assertThat("Admin is on Candidate Page", reflection.getWebElementByClass("addCandidateHeading")
                .getText(), is("Candidate"));
        assertThat("Candidate is successfully saved", reflection.getWebElementByClass("successMessage")
                .getText(), is("Successfully Saved\nClose"));
    }

    @When("^admin fills the Candidate Name field with: (.*)$")
    public void fillCandidateNameField(String name) throws IllegalAccessException {

        reflection.getWebElementByClass("canditateNameFieldCanditatesPage").sendKeys(name);

        assertThat("Candidate name field is filled with", reflection
                .getWebElementByClass("canditateNameFieldCanditatesPage")
                .getAttribute("value"), is("Johny Lahanta"));
    }

    @When("^admin selects the Candidate$")
    public void selectCandidate() throws IllegalAccessException, NotInitializedWebDriverException {
        reflection.getWebElementByClass("candidate").click();
        EditCandidatePage editCandidatePage = new EditCandidatePage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, editCandidatePage);

        assertThat("Admin is on Candidate Page", reflection.getWebElementByClass("candidateHeader")
                .getText(), is("Candidate"));
    }

    @When("^admin fills next fields$")
    public void fillTheFields(DataTable table) throws IllegalAccessException {
        String contactNo = table.cell(1, 0);
        String comment = table.cell(1, 1);

        reflection.getWebElementByClass("contactNoFieldAddCandidatePage").sendKeys(contactNo);
        reflection.getWebElementByClass("commentFieldAddCandidatePage").sendKeys(comment);
        assertThat("Admin is on Edit Candidate Page", reflection.getWebElementByClass("candidateHeader")
                .getText(), is("Edit Candidate"));
    }

    @Then("^admin receives that  candidate is successfully saved.$")
    public void candidateIsSaved() throws IllegalAccessException {
        assertThat("Candidate is successfully saved", reflection.getWebElementByClass("successMessage")
                .getText(), is("Successfully Saved\nClose"));
    }

    @Then("^candidate is successfully deleted.$")
    public void candidateIsDeleted() throws IllegalAccessException, NotInitializedWebDriverException {
        RecruitmentPage recruitmentPage = new RecruitmentPage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, recruitmentPage);
        assertThat("Candidate is successfully deleted ", reflection.getWebElementByClass("successMessage")
                .getText(), is("Successfully Deleted\nClose"));
    }
}
