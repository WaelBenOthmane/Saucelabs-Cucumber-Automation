package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.LoginPage;
import com.e2etests.automation.page_objects.LogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefinition {
    private LogoutPage logoutpage;
    private LoginPage loginpage;

    public LogoutStepDefinition() {

        this.logoutpage = new LogoutPage();
        loginpage = new LoginPage();
    }

    @Given("User enters username and password and clicks on Login button")
    public void user_enters_username_and_password_and_clicks_on_login_button() {
        loginpage.loginToSite();
    }

    @When("User clicks on menu button")
    public void user_clicks_on_menu_button() {
        logoutpage.clickOnMenu();
    }

    @When("User clicks on the Logout link")
    public void user_clicks_on_the_logout_link() {
        logoutpage.clickOnLogoutLink();
    }

    @Then("User should be redirected to the Login Page {string}")
    public void user_should_be_redirected_to_the_login_page(String logintext) {
        Assert.assertEquals(logintext, logoutpage.getTextLogin());
    }

    @When("User clicks on the About link")
    public void user_clicks_on_the_about_link() {
        logoutpage.clickOnAboutLink();
    }

    @Then("User should be redirected to the About page {string}")
    public void user_should_be_redirected_to_the_about_page(String abouturl) {
        Assert.assertTrue(logoutpage.getAboutUrl().contains(abouturl));
    }




}
