package testRunner;
//This is my test runner class

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features=".\\Features\\Login1.feature",
		//features=".\\Features\\Customers1.feature",
		features=".\\Features\\Customers2.feature",
		glue="stepDefinitions",
		monochrome=true,
		//tags= {"@sanity"},
		tags= {"@regression"},
		plugin= {"pretty","html:test-output"}
		)
public class TestRunner {

}
