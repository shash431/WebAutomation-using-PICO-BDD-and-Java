package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.DragAndDrop;
import pageObject.Resizable;
import pageObject.Selectable;
import pageObject.SideBar;
import resources.SharedProps;

public class InteractionsStepDefinitions extends SharedProps{
	
	SideBar sideBar;
	Selectable selectable;
	Resizable resizable;
	DragAndDrop dragAndDrop;
	
	public InteractionsStepDefinitions(SharedProps sharedProps) {
		sideBar = new SideBar(sharedProps.driver);
		selectable = new Selectable(sharedProps.driver);
		resizable = new Resizable(sharedProps.driver);
		dragAndDrop = new DragAndDrop(sharedProps.driver);
	}
	
	@Given("User click in {string} item")
	public void user_click_in_item(String item) {
	    sideBar.clickSideBarItem(item);
	}
	
	
	// Select items steps
	
	@Then("User can {string} item")
	public void user_can_use_functionality(String string) {
		// Extract number from string
		int amount = Integer.parseInt(string.replaceAll("\\D+",""));
		// set variable to share between steps 
		setAuxInt(amount);
		selectable.selectItems(amount);
	}
	
	@Then("Items are selected")
	public void items_are_selected() {
		int totalSelectedItems = selectable.totalSelectedItems();
		assertEquals(totalSelectedItems, getAuxInt(), "Expected selecteds items " + getAuxInt() + " actual selected items " + totalSelectedItems);
	}
	
	// Resize steps
	
	@When("User can resize placeholder")
	public void user_can_resize_placeholder() {
		resizable.resizePlaceholder();
	}

	@Then("Placeholder is resized")
	public void placeholder_is_resized() {
		assertTrue(resizable.vefrifyresize(), "placeholder was not resized");
	}
	
	// Drag and drop steps
	
	@When("User can drag drop the element")
	public void user_can_drag_drop_the_element() {
		assertEquals(dragAndDrop.getDroppableText(), "Drop here");
	    dragAndDrop.dragAndDrop();
	}

	@Then("Element is dropped")
	public void element_is_dropped() {
		assertEquals(dragAndDrop.getDroppableText(), "Dropped!");
	}
	
}
