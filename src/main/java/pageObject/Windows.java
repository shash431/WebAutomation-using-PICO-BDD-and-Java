package pageObject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Windows extends BasePageClass{

	public Windows(WebDriver browser) {
		super(browser);
	}
	
	public void clickOn(String button) {
		browser.findElement(By.xpath("//button[(text()='"+button+"')]")).click();
	}

	public int amountOfWindows() {
		return browser.getWindowHandles().size();
	}

	public String getNewTabTitle() {
		browser.close();
		Set<String> windows = browser.getWindowHandles();
		for(String window: windows) {
			browser.switchTo().window(window);
		}
		return browser.getTitle();
	}

	public String getAlertText() {
		String text = browser.switchTo().alert().getText();
		browser.switchTo().alert().accept();
		return text;
		}
	
}
