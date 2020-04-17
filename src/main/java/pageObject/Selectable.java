package pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selectable extends BasePageClass{

	public Selectable(WebDriver browser) {
		super(browser);
		actions = new Actions(browser);
		PageFactory.initElements(browser, this);
	}
	
	@FindAll({@FindBy(css="#selectable li")})
	List<WebElement> selectableItems;
	
	
	public void selectItems(int amount) {
		actions.keyDown(Keys.COMMAND);
		for (int i = 0; i < amount; i++) {
			actions.click(selectableItems.get(i));
		}
		actions.perform();
	}
	
	public int totalSelectedItems() {
		int total = 0;
		for(WebElement item: selectableItems) {
			if(item.getAttribute("outerHTML").contains("ui-selected")) {total ++;}
		}
		return total;
	}

}
