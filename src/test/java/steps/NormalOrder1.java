package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.web.LoginPage;
import utilities.TestBase;
import utilities.TestBase2;

public class NormalOrder1 extends TestBase {

    LoginPage loginPage = new LoginPage(driver);

    @Given("user is on Login Page")
    public void user_is_on_Login_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://dashboard-dev.shgardi.app/auth/login");
    }
    @When("insert \"([^\"]*)\" and \"([^\"]*)\" and click sign in")
    public void insert_and_and_click_sign_in(String Email, String Password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.addCridintioal(Email,Password);
    }


    @When("click side menu and click order and then click order list")
    public void click_side_menu_and_click_order_and_then_click_order_list() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("click in advanced search and then insert order number and click search")
    public void click_in_advanced_search_and_then_insert_order_number_and_click_search() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("you can view you order")
    public void you_can_view_you_order() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
