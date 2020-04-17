package stepDefinitions;
import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import resources.Browser;
import resources.SharedProps;

public class Hooks extends SharedProps{
	
	private SharedProps sharedProp;
	private Browser browser = new Browser();
	
	public Hooks(SharedProps sharedProps) {
		this.sharedProp = sharedProps;
	}

	// Runs before every test, starts the browser in the base URL and the property file
	@Before
	public void startDriver(Scenario scenario) throws IOException {
		sharedProp.driver = browser.startDriver();
		sharedProp.prop = browser.initializeProps();
		sharedProp.driver.get(sharedProp.prop.getProperty("baseUrl"));
	}
	
	// Runs after every test, close the browser and in case of failure takes a screenshot
	@After
	public void tearDown(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			browser.takeScreenshot(scenario);
		}
		sharedProp.resetAux();
		browser.browser.quit();
	}
	
}
