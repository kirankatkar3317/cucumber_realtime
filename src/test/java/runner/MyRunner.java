package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features\\Login.feature", glue = { "stepDefinition",
		"myHooks" }, monochrome = true, publish = true,plugin = { "pretty", "html:target/CucumberReports/CucumberReports.html"})
public class MyRunner {

}
