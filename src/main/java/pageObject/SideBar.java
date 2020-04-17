package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBar extends BasePageClass{

	public SideBar(WebDriver browser) {
		super(browser);
	}
	
	@FindBy(css="h1.entry-title")
	WebElement title;
	
	public void clickSideBarItem(String item) {
		browser.findElement(By.xpath("//a[(text()='"+item+"')]")).click();
	}
	
}
