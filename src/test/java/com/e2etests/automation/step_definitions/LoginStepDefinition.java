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

    @When("User enters username as {string}")
    public void userEntersUsernameAs(String username) {
        loginpage.fillUserName(username);
    }

    @When("User enters password as {string}")
    public void userEntersPasswordAs(String password) {
        loginpage.fillPassword(password);
    }

    @When("User clicks on Login button")
    public void userClicksOnLoginButton() {
        loginpage.clickOnBtnLogin();
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
