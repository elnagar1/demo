package runner;

import cucumber.api.CucumberOptions;
import utilities.TestBase;
import utilities.TestBase2;


@CucumberOptions(
    features="src/test/java/features/us",
    glue= {"steps"},
    plugin= {"pretty","html:target/cucumber-html-report"}
        ,tags = {"@stop"}
)
public class TestRunner extends TestBase {

}
