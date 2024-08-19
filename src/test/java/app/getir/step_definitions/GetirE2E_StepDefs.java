package app.getir.step_definitions;

import app.getir.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GetirE2E_StepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("user opens getir and enters username {string} and password {string}")
    public void user_opens_getir_and_enters_username_and_password(String username, String password) {
        loginPage.login(username,password);

    }
    @Then("verify that user logins successfully")
    public void verify_that_user_logins_successfully() {

    }
}
