package com.automation.step_definitions;

import com.automation.pages.LoginPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.MobileUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
    LoginPage loginPage= new LoginPage();

    @Given("use clicks on etsy get started")
    public void use_clicks_on_etsy_get_started() {
        loginPage.clickOnGetStarted();
    }

    @When("user logs in with etsy credentials")
    public void user_logs_in_with_etsy_credentials() {
       loginPage.login();
        MobileUtilities.wait(10);
    }

    @Then("user verifies that etsy logo is displayed")
    public void user_verifies_that_etsy_logo_is_displayed() {

    }


}
