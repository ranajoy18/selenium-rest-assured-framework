package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.BaseTest;
import common.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginTestSD {

    private WebDriver driver;
    private LoginPage loginPage;
    private String urlBeforeLogin;
    
    @Given("the user is on the login page {string}")
    public void the_user_is_on_the_login_page(String string) {
        BaseTest.setUp();
        driver=DriverManager.getWebDriver();
        driver.get(string);
        urlBeforeLogin=driver.getCurrentUrl();
        loginPage=new LoginPage(driver);
    }

    @When("the user enters username {string}")
    public void the_user_enters_username(String string) {
       loginPage.enterUserName(string);
    }

    @When("the user enters password {string}")
    public void the_user_enters_password(String string) {
        loginPage.enterPassword(string);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickSubmit();
    }

    @Then("the user should be {string}")
    public void the_user_should_be(String string) {
       if(string.equalsIgnoreCase("success")){
        String urlAfterLogin=driver.getCurrentUrl();
        Assert.assertNotEquals(urlAfterLogin, urlBeforeLogin);
       }
    }
}
