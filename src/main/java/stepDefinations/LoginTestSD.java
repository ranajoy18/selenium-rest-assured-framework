package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSD {

    @Given("the user is on the login page {string}")
    public void the_user_is_on_the_login_page(String string) {
        System.out.println("Inside step1");
    }

    @When("the user enters username {string}")
    public void the_user_enters_username(String string) {
        System.out.println("Inside step2");
    }

    @When("the user enters password {string}")
    public void the_user_enters_password(String string) {
        System.out.println("Inside step3");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        System.out.println("Inside step4");
    }

    @Then("the user should be {string}")
    public void the_user_should_be(String string) {
        System.out.println("Inside step5");
    }
}
