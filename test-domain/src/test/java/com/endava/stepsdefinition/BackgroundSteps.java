package com.endava.stepsdefinition;

import com.endava.context.DataKeys;
import com.endava.context.ScenarioContext;
import com.endava.exceptions.NotInitializedWebDriverException;
import com.endava.pageobject.DashboardPage;
import com.endava.pageobject.LoginPage;
import com.endava.utils.Driver;
import com.endava.utils.PropertyManager;
import com.endava.utils.ReflectionsUtils;
import cucumber.api.java.en.Given;

import static com.endava.assertions.CustomAssertion.assertThat;
import static org.hamcrest.core.Is.is;

public class BackgroundSteps {

    private ReflectionsUtils reflection = new ReflectionsUtils();

    @Given("^user is logged as admin$")
    public void login() throws NotInitializedWebDriverException, IllegalAccessException {
        LoginPage loginPage = new LoginPage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, loginPage);
        Driver.getDriver().get(PropertyManager.getInstance().getUrl());

        assertThat("Admin is on login page", reflection.getWebElementByClass("textHeaderLoginPage")
                .getText(), is("LOGIN Panel"));

        reflection.getWebElementByClass("usernameFieldLoginPage").sendKeys(PropertyManager.getInstance()
                .getAdminUserName());
        reflection.getWebElementByClass("passwordFieldLoginPage").sendKeys(PropertyManager.getInstance()
                .getAdminPassword());
        reflection.getWebElementByClass("submitButtonLoginPage").click();

        DashboardPage dashboardPage = new DashboardPage(Driver.getDriver());
        ScenarioContext.saveData(DataKeys.CURRENT_PAGE, dashboardPage);
        assertThat("Admin is logged in", reflection.getWebElementByClass("adminMessageDashboard")
                .getText(), is("Welcome Admin"));
    }
}
