package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import pages.User.Login;
import utilities.TestBase;

public class NormalOrder2 extends TestBase {
    Login loginPage;

    @Given("^user is on Login screen$")
    public void user_is_on_Login_screen() {
        loginPage = new Login((AndroidDriver) appiumDriver);
    }

    @When("^Click skip button$")
    public void click_skip_button() {
        loginPage.skipButton();

    }

    @When("^Change country and choose egypt$")
    public void change_country_and_choose_egypt() {
         loginPage.chooseCountry();
    }

    @When("^insert \"([^\"]*)\"  click continue and insert \"([^\"]*)\" and click sign in$")
    public void insert_click_continue_and_insert_and_click_sign_in(String phone, String Password) {
        loginPage.UserLogin(phone, Password);

    }

    @Then("^you can view  Home$")
    public void you_can_view_Home() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}
