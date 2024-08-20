package app.getir.step_definitions;

import app.getir.pages.BasketPage;
import app.getir.pages.FitFromPage;
import app.getir.pages.LoginPage;
import app.getir.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetirE2E_StepDefs {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    BasketPage basketPage = new BasketPage();
    FitFromPage fitFromPage = new FitFromPage();

    @Given("user opens getir and enters username {string} and password {string}")
    public void user_opens_getir_and_enters_username_and_password(String username, String password) {
        loginPage.login(username,password);

    }
    @Then("verify that user logins successfully")
    public void verify_that_user_logins_successfully() {
        assertTrue(mainPage.foods.isDisplayed());
    }

    @When("user clicks on the basket button")
    public void user_clicks_on_the_basket_button() {
        mainPage.basketBtn.click();

    }
    @Then("verify that basket is empty and text is {string}")
    public void verify_that_basket_is_empty_and_text_is(String expectedResultTxt) {
        assertEquals(expectedResultTxt, basketPage.noResult.getText());

    }
    @When("user navigates back main page")
    public void user_navigates_back_main_page() {
        basketPage.backBtn.click();
    }
    @Then("verify that menu list size is {int}")
    public void verify_that_menu_list_size_is(int expectedListSize) {
        assertEquals(expectedListSize, mainPage.menuList.size());

    }
    @When("user clicks on the menu {string}")
    public void user_clicks_on_the_menu(String menuName) {
        mainPage.menu(menuName).click();

    }
    @When("user makes scroll and adds two item")
    public void user_makes_scroll_and_adds_two_item(List<String> dataTable) {
        fitFromPage.addItem(dataTable.get(0));
        fitFromPage.addItem(dataTable.get(1));

    }
    @Then("verify that amount text is {string}")
    public void verify_that_amount_text_is(String expectedPriceTxt) {
        assertEquals(expectedPriceTxt, basketPage.totalPrice.getText());
    }
}
