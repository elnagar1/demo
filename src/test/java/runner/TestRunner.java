package runner;

import cucumber.api.CucumberOptions;
import utilities.TestBase;


@CucumberOptions(
    features="src/test/java/features/us",
    glue= {"steps"},
    plugin= {"pretty","html:target/cucumber-html-report"}
        ,tags = {"@stop"}
)
public class TestRunner extends TestBase {
    TestRunner(){
        System.out.println("runner k k k k k k k ");
    }
}
