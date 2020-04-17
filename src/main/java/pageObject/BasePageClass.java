package pageObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public abstract class BasePageClass {
	
	public WebDriver browser;
	public Properties props;
	WebDriverWait wait;
	Actions actions;
		
	public BasePageClass(WebDriver browser) {
		this.browser = browser;
		this.wait = new WebDriverWait(browser, 10);
	}
	
	public boolean compareImages(String page) throws IOException {
		return Shutterbug.shootPage(browser, ScrollStrategy.WHOLE_PAGE, 500, true).withName("Actual").equals(getBufferedImage(page));
	} 
	
	public BufferedImage getBufferedImage(String page) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		File image = new File("/Users/Juan/SeleniumProject/WebAutomation/UIimages/"+page+".png");
		return ImageIO.read(image);
	}

}
