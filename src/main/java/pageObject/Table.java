package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Table extends BasePageClass{

	public Table(WebDriver browser) {
		super(browser);
		PageFactory.initElements(browser, this);
	}

	@FindAll({@FindBy(css=".ColorSelector-container input")})
	List<WebElement> colors;
	
	@FindBy(css="table[summary='Sample Table'] tbody tr")
	List<WebElement> tableRows;
	
	public boolean checkRows(List<String> expectedList) {
		for(WebElement row: tableRows) {
			List<String> actualList = new ArrayList<String>();
			for(WebElement data: row.findElements(By.cssSelector("*"))) {
				actualList.add(data.getText());
			}
			if(actualList.containsAll(expectedList)) {
				return true;
			}
		}
		return false;
	}
	
}
