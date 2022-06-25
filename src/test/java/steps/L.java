package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import utilities.TestBase;

public class L extends TestBase  {



    @Given("user is on Login Page")
    public void user_is_on_Login_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://dashboard-dev.shgardi.app/auth/login");
    }


}
