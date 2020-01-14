package com.endava.stepsdefinition;

import com.endava.context.ButtonKeys;
import com.endava.context.DataKeys;
import com.endava.context.ScenarioContext;
import com.endava.exceptions.IncorrectTabName;
import com.endava.exceptions.NotInitializedWebDriverException;
import com.endava.pageobject.AdminPage;
import com.endava.pageobject.PIMPage;
import com.endava.pageobject.RecruitmentPage;
import com.endava.utils.Driver;
import com.endava.utils.ReflectionsUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static com.endava.assertions.CustomAssertion.assertThat;
import static org.hamcrest.core.Is.is;

public class GenericSteps {

    private ReflectionsUtils reflection = new ReflectionsUtils();

    @Given("^admin selects the following tab: (.*)$")
    public void adminSelectTab(String tab) throws NotInitializedWebDriverException, IllegalAccessException, IncorrectTabName, InterruptedException {
        switch (tab) {
            case ("Admin"):
                reflection.getWebElementByClass("adminButtonDashboardPage").click();
                AdminPage adminPage = new AdminPage(Driver.getDriver());
                ScenarioContext.saveData(DataKeys.CURRENT_PAGE, adminPage);

                assertThat("Admin is on System User page", reflection
                        .getWebElementByClass("systemUserHeaderAdminPage").getText(), is("Admin"));
                break;

            case ("PIM"):
                reflection.getWebElementByClass("pimButtonDashboardPage").click();
                PIMPage pimPage = new PIMPage(Driver.getDriver());
                ScenarioContext.saveData(DataKeys.CURRENT_PAGE, pimPage);

                assertThat("Admin is on Add employee page", reflection
                        .getWebElementByClass("dropDownEmployeeStatus").isDisplayed(), is(true));
                break;
            case ("RecruitmentPage"):
                reflection.getWebElementByClass("recruitmentButtonDashboardPage").click();
                RecruitmentPage recruitmentPagee = new RecruitmentPage(Driver.getDriver());
                ScenarioContext.saveData(DataKeys.CURRENT_PAGE, recruitmentPagee);

                assertThat("Admin is on RecruitmentPage page", reflection
                        .getWebElementByClass("recruitmentButtonDashboardPage")
                        .getText(), is("Recruitment"));
                break;
            default:
                throw new IncorrectTabName("There is no such Tab");
        }
    }

    @When("^admin clicks on (.*)$")
    public void clickOnSpecificButton(ButtonKeys buttonType) throws IllegalAccessException {
        reflection.getWebElementByClass(buttonType.getValue()).click();
    }
}
