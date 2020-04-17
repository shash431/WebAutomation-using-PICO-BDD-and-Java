package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resizable extends BasePageClass{

	public Resizable(WebDriver browser) {
		super(browser);
		actions = new Actions(browser);
		PageFactory.initElements(browser, this);
	}
	
	@FindBy(css="#resizable .ui-icon-gripsmall-diagonal-se")
	WebElement resizableDiagonalIcon;
	
	@FindBy(css="#resizable")
	WebElement resizablePlaceholder;
	
	public void resizePlaceholder() {
		actions.dragAndDrop(resizableDiagonalIcon, resizablePlaceholder).perform();
	}

	public boolean vefrifyresize() {
		String styleAttr = resizablePlaceholder.getAttribute("style");
		return !styleAttr.isEmpty();
	}
	
}
