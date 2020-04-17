package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDrop extends BasePageClass{

	public DragAndDrop(WebDriver browser) {
		super(browser);
		actions = new Actions(browser);
		PageFactory.initElements(browser, this);
	}

	@FindBy(css="#draggable")
	WebElement draggableItem;
	
	@FindBy(css="#droppable")
	WebElement droppableItem;
	
	public void dragAndDrop() {
		actions.dragAndDrop(draggableItem, droppableItem).perform();
	}
	
	public String getDroppableText() {
		return droppableItem.getText();
	}
	
}
