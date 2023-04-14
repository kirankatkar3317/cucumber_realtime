package myHooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import webDriverFactory.DriverFactory;

public class Hooks {
	public WebDriver driver;
	@Before
	public void setUp() throws IOException {
		Properties prop  = new ConfigReader().initializeProp();;
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown(Scenario scenario)  {
		
		String scenarioName = scenario.getName().replace(" ", "_");
		
		if(scenario.isFailed()) {
			
		byte[] screenshot =	((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenarioName);
		
		}
		
		driver.quit();
	}


}
