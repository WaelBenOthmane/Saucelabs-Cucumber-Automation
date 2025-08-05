package com.e2etests.automation.page_objects;

import com.e2etests.automation.step_definitions.LoginStepDefinition;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private ConfigFileReader configfilereader;

    /**
     * @FindBy
     **/
    @FindBy(how = How.ID, using = "user-name")
    public static WebElement userName;

    @FindBy(how = How.ID, using = "password")
    public static WebElement password;

    @FindBy(how = How.ID, using = "login-button")
    public static WebElement btnSubmit;

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    public static WebElement welcomeMsg;

    @FindBy(how = How.CSS, using = "h3")
    public static WebElement errorMsg;

    public LoginPage() {
        PageFactory.initElements(Setup.getDriver(), this);
        this.configfilereader = new ConfigFileReader();
    }

    /**
     * Create methods
     **/
    public void goToUrl() {

        Setup.getDriver().get(configfilereader.getProperties("home.url"));
    }

    public void fillUserName(String name) {
        userName.sendKeys(name);

    }

    public void fillPassword(String pwd) {
        password.sendKeys(pwd);

    }

    public void clickOnBtnLogin() {
        btnSubmit.click();

    }

    public String getMsgLogin() {
        return welcomeMsg.getText();
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }


}
