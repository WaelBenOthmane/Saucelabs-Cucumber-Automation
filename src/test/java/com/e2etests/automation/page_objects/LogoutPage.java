package com.e2etests.automation.page_objects;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    private ConfigFileReader configfilereader;
    private WebDriverWait wait;

    /**
     * @FindBy
     **/
    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    public static WebElement burgerMenu;

    @FindBy(how = How.ID, using = "logout_sidebar_link")
    public static WebElement logoutLink;

    @FindBy(how = How.XPATH, using = "//div[@class='login_logo']")
    public static WebElement loginText;

    @FindBy(how = How.ID, using = "about_sidebar_link")
    public static WebElement aboutLink;

    public LogoutPage() {
        PageFactory.initElements(Setup.getDriver(), this);
        this.configfilereader = new ConfigFileReader();
        wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(10));
    }

    /**
     * Create methods
     **/

    public void clickOnMenu() {
        burgerMenu.click();
    }

    public void clickOnLogoutLink() {
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();
    }

    public String getTextLogin() {
        return loginText.getText();
    }

    public void clickOnAboutLink() {
        wait.until(ExpectedConditions.visibilityOf(aboutLink));
        aboutLink.click();
    }

    public String getAboutUrl() {
        return Setup.getDriver().getCurrentUrl();
    }
}
