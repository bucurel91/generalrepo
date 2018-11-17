package com.endava.stepsdefinition;

import com.endava.context.DataKeys;
import com.endava.context.ScenarioContext;
import com.endava.exceptions.NotInitializedWebDriverException;
import com.endava.pageobject.AddUserPage;
import com.endava.pageobject.AdminPage;
import com.endava.pageobject.EditUserPage;
import com.endava.utils.Driver;
import com.endava.utils.ReflectionsUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.endava.assertions.CustomAssertion.assertThat;
import static org.hamcrest.core.Is.is;

public class SystemUserSteps {

    ReflectionsUtils reflection = new ReflectionsUtils();

    @When("^admin fills mandatory fields with valid data$")
    public void fillMandatoryFieldsOfCandidate(DataTable table) throws IllegalAccessException, NotInitializedWebDriverException {

        String employeeName = table.cell(1, 0);
        String userName = table.cell(1, 1);
        String password = table.cell(1, 2);
        String confirmPassword = table.cell(1, 3);

        AddUserPage addEmployee = new AddUserPage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, addEmployee);

        reflection.getWebElementByClass("userNameFieldAddUserPage").clear();

        reflection.getWebElementByClass("employeeNameFieldAddUserPage").sendKeys(employeeName);
        reflection.getWebElementByClass("userNameFieldAddUserPage").sendKeys(userName);
        reflection.getWebElementByClass("passwordFieldAddUserPage").sendKeys(password);
        reflection.getWebElementByClass("confirmPasswordFieldAddUserPage").sendKeys(confirmPassword);

        assertThat("Employee Name was added", reflection.getWebElementByClass
                ("employeeNameFieldAddUserPage").getAttribute("value"), is(employeeName));
        assertThat("Username was added", reflection.getWebElementByClass
                ("userNameFieldAddUserPage").getAttribute("value"), is(userName));
        assertThat("Password was added", reflection.getWebElementByClass
                ("passwordFieldAddUserPage").getAttribute("value"), is(password));
    }

    @Then("^admin successfully saved System User$")
    public void adminSuccessfullySavedSystemUser() throws IllegalAccessException, NotInitializedWebDriverException {
        AddUserPage addUser = new AddUserPage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, addUser);
        assertThat("Admin see message - Successfully Saved",
                reflection.getWebElementByClass("addedSuccessfulMessage").
                        getText(), is("Successfully Saved\nClose"));
    }

    @When("^admin fills in username field: (.*)$")
    public void adminUserFillDataInUsernameField(String username) throws IllegalAccessException {
        reflection.getWebElementByClass("userNameFieldAdminPage").sendKeys(username);
        assertThat("Admin enter username for search", reflection.getWebElementByClass
                ("userNameFieldAdminPage").isDisplayed(), is(true));
    }

    @When("^admin changes to (.*) username$")
    public void adminChangeUsernameField(String username) throws IllegalAccessException, NotInitializedWebDriverException {
        EditUserPage editUserPage = new EditUserPage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, editUserPage);
        reflection.getWebElementByClass("userNameFieldEditUserPage").clear();
        reflection.getWebElementByClass("userNameFieldEditUserPage").sendKeys(username);
    }

    @When("^admin select systemUser: (.*)$")
    public void selectEmployee(String userName) throws NotInitializedWebDriverException {
        WebElement searchedUsername = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'" + userName + "')]"));
        searchedUsername.click();

        AdminPage adminPage = new AdminPage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, adminPage);
    }


    @Then("^admin receives message - Successfully updated$")
    public void updateSystemUser() throws IllegalAccessException {
        assertThat("Admin see message - Successfully Updated", reflection.getWebElementByClass
                ("updateSuccessfulMessage").getText(), is("Successfully Updated\nClose"));
    }

    @Then("^admin receives message - Successfully deleted$")
    public void deleteSystemUser() throws IllegalAccessException {
        assertThat("Admin see message - Successfully Deleted", reflection.getWebElementByClass
                ("deleteSuccessfulMessage").getText(), is("Successfully Deleted\nClose"));
    }
}
