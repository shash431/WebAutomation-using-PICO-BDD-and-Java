package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Then;
import pageObject.SideBar;
import resources.SharedProps;

public class DemoQAStepDefinitions extends SharedProps{
	
	SideBar homePage;
	
	public DemoQAStepDefinitions(SharedProps sharedProps) {
		this.homePage = new SideBar(sharedProps.driver);
	}
	
	@Then("{string} UI is as expected")
	public void ui_is_as_expected(String page) throws IOException {
		assertTrue(homePage.compareImages(page), "There is a difference between the actual "+page+" image and the expected image");
	}
}
