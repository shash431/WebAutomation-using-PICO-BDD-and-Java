package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Table;
import pageObject.Windows;
import resources.SharedProps;

public class WidgetStepDefinitions extends SharedProps{
	
	Windows windows;
	Table table;

	public WidgetStepDefinitions(SharedProps sharedProps) {
		windows = new Windows(sharedProps.driver);
		table = new Table(sharedProps.driver);
	}
	
	@When("User click on {string} button")
	public void user_click_on_button(String button) {
	   windows.clickOn(button);
	}

	@Then("A new window is open")
	public void a_new_window_is_open() {
		assertTrue(windows.amountOfWindows() > 1, "No new window was opened");
	}
	
	@Then("User get redirected to {string}")
	public void user_get_redirected_to(String string) {
		assertEquals(windows.getNewTabTitle(), "Free QA Automation Tools Tutorial for Beginners with Examples");
	}
	
	@Then("User checks the text and close the alert popup")
	public void user_checks_the_text_and_close_the_alert_popup() {
		String actual = windows.getAlertText();
		String expected = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
		assertEquals(actual, expected, "The text in the alert is not the expected one");
	}
	
    @Then("^structure (.+) located in (.+) in city (.+) with a height of (.+) built in (.+)$")
    public void structure_located_in_in_city_with_a_height_of_built_in(String structure, String country, String city, String height, String built) {
    	List<String> info = new ArrayList<String>(); 
    	info.add(structure); info.add(country); info.add(city); info.add(height); info.add(built);
        assertTrue(table.checkRows(info), "Some of the following data ==> "+info+" is missing in the table");
    }
}
