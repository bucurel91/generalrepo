package com.endava.stepsdefinition;

import com.endava.context.DataKeys;
import com.endava.context.ScenarioContext;
import com.endava.exceptions.NotInitializedWebDriverException;
import com.endava.pageobject.AddEmployeePage;
import com.endava.pageobject.EditEmployeePage;
import com.endava.utils.Driver;
import com.endava.utils.ReflectionsUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.endava.assertions.CustomAssertion.assertThat;
import static org.hamcrest.core.Is.is;

public class EmployeeSteps {

    private ReflectionsUtils reflection = new ReflectionsUtils();

    @Then("^admin fills mandatory fields on add Employee page$")
    public void fillMandatoryFieldsOfEmployee(DataTable table) throws IllegalAccessException, NotInitializedWebDriverException {
        String firstName = table.cell(1, 0);
        String lastName = table.cell(1, 1);
        AddEmployeePage addEmployeePage = new AddEmployeePage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, addEmployeePage);

        reflection.getWebElementByClass("firstNameFieldAddEmployee").sendKeys(firstName);
        assertThat("Admin input first name", reflection.getWebElementByClass("firstNameFieldAddEmployee")
                .getAttribute("value"), is(firstName));

        reflection.getWebElementByClass("lastNameFieldAddEmployee").sendKeys(lastName);
        assertThat("Admin input last name", reflection.getWebElementByClass("lastNameFieldAddEmployee")
                .getAttribute("value"), is(lastName));
    }

    @Then("^admin is on Personal Details page of Employee$")
    public void employeeSuccessSaved() throws IllegalAccessException, NotInitializedWebDriverException {
        EditEmployeePage editEmployeePage = new EditEmployeePage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, editEmployeePage);
        assertThat("The employee was successfully saved", reflection.getWebElementByClass("fotoSpace")
                .isDisplayed(), is(true));
    }

    @When("^admin fills in Employee Name field: (.*)$")
    public void changeEmployeeName(String firstName) throws IllegalAccessException {
        reflection.getWebElementByClass("employeeNameFieldPimPage").sendKeys(firstName);

        assertThat("Admin enter Employee Name to search", reflection
                .getWebElementByClass("employeeNameFieldPimPage").getAttribute("value"), is(firstName));
    }

    @When("^admin click Employee last name: (.*)$")
    public void selectEmployee(String lastName) throws IllegalAccessException, NotInitializedWebDriverException {
        WebElement employeeFromList = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'" + lastName + "')]"));
        employeeFromList.click();
        EditEmployeePage editEmployeePage = new EditEmployeePage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, editEmployeePage);

        assertThat("Admin open edit employee page", reflection.getWebElementByClass("editEmployeeHeader")
                .getText(), is("Personal Details"));
    }

    @Then("^admin adds next Driver's License Number number: (.*)$")
    public void modifyFirstName(String driverLicenseNumber) throws IllegalAccessException {
        reflection.getWebElementByClass("driverLicenceFieldEditEmployeePage").sendKeys(driverLicenseNumber);

        assertThat("Driver license number was added", reflection
                .getWebElementByClass("driverLicenceFieldEditEmployeePage")
                .getAttribute("value"), is(driverLicenseNumber));
    }

    @Then("^admin receives message: Successfully deleted$")
    public void deleteEmployee() throws IllegalAccessException, NotInitializedWebDriverException {
        AddEmployeePage addEmployeePage = new AddEmployeePage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, addEmployeePage);

        assertThat("Admin see message: Successfully Deleted", reflection
                .getWebElementByClass("successMessage").getText(), is("Successfully Deleted\nClose"));
    }

    @Then("^admin receives message: Successfully saved$")
    public void driverLicenseNumberSaved() throws IllegalAccessException, NotInitializedWebDriverException {
        AddEmployeePage addEmployeePage = new AddEmployeePage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, addEmployeePage);

        assertThat("Admin see message: Successfully Saved", reflection
                .getWebElementByClass("successMessage").getText(), is("Successfully Saved\nClose"));
    }
}
