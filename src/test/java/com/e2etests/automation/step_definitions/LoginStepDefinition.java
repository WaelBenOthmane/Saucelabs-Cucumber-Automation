package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

    private LoginPage loginpage;

    public LoginStepDefinition() {

        this.loginpage = new LoginPage();
    }


    @Given("User connect on saucedemo site")
    public void userConnectOnSaucedemoSite() {
        loginpage.goToUrl();
    }

    @When("User enters valid username and password and clicks on Login button")
    public void userEntersValidUsernameAndPasswordAndClicksOnLoginButton() {
        loginpage.positiveLogin();
    }

    @When("User enters Invalid username and password and clicks on Login button")
    public void userEntersInvalidUsernameAndPasswordAndClicksOnLoginButton() {
        loginpage.negativeLogin();
    }

    @Then("User should be redirected to the Products page {string}")
    public void userShouldBeRedirectedToTheProductsPage(String loginMsg) {
        String msgSuccessLogin = loginpage.getMsgLogin();
        Assert.assertEquals(loginMsg, msgSuccessLogin);
    }

    @Then("An error message should be displayed {string}")
    public void anErrorMessageShouldBeDisplayed(String errorMsg) {
        String errorMsgLogin = loginpage.getErrorMsg();
        System.out.println(errorMsgLogin);
        Assert.assertEquals(errorMsg, errorMsgLogin);
    }
}
