package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.hu.De;
import org.junit.Assert;
import pages.DefaultPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Login_Step_Defs {
    LoginPage loginPage= new LoginPage();
    DefaultPage defaultPage=new DefaultPage();
    @Given("user is on the application_login page")
    public void user_is_on_the_application_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("application_login_url"));
    }
    @Given("user enters manager_id {string}")
    public void user_enters_manager_id(String string) {
        loginPage.userName.sendKeys(string);
    }
    @Given("user enters manager_password {string}")
    public void user_enters_manager_password(String string) {
        loginPage.password.sendKeys(string);
    }
    @Given("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.logInButton.click();
    }
    @Given("verify login {string} is displayed")
    public void verify_login_is_displayed(String string) {
        Assert.assertEquals(defaultPage.userID.getText(),string);
    }
}

