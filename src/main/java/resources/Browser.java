package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Browser {
	
	public WebDriver browser;
	public Properties props = new Properties();
	public FirefoxOptions firefoxOptions = new FirefoxOptions();
	public ChromeOptions chromeOptions = new ChromeOptions();
	
	// Set browser depending on system properties, by default runs Chrome
	public WebDriver startDriver() {
		String browserName = System.getProperty("browser");
		String headless = System.getProperty("headless");
		
		// check for headless running
		if(headless!=null && headless.equalsIgnoreCase("true")) {
			setupHeadlessRun(browserName);
		}
		
		// select browser
		if(browserName==null || browserName.equalsIgnoreCase("chrome")) {
			setDriverPath("chrome");
			browser = new ChromeDriver(chromeOptions);
		}else if(browserName.equalsIgnoreCase("firefox")){
			setDriverPath("firefox");
			browser = new FirefoxDriver(firefoxOptions);
		}
		
		// implicit timeout 
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		return browser;
	}
	
	// Initialization of the properties file 
	public Properties initializeProps() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		props.load(file);
		return props;
	}
	
	// Method to point to the Web drivers executables files
	protected static void setDriverPath(String browser) {
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/webdrivers/chromedriver");
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/webdrivers/geckodriver");
		}
	}
	
	// Generates an image file and store it in screenshots folder. Also add the image in the test case cucumber report.
	public void takeScreenshot(Scenario scenario) throws IOException {	
		TakesScreenshot ts = (TakesScreenshot) browser;
		// File to save after the run
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		// image to add to the report
		byte[] screenshotForReport = ts.getScreenshotAs(OutputType.BYTES);
		
		LocalDateTime now = LocalDateTime.now(); 
		String fileName = System.getProperty("user.dir")+"/screenshots/"+scenario.getName()+"_"+now+".png";
		// save file
		FileUtils.copyFile(screenshot, new File(fileName));
		// Add image to report
        scenario.embed(screenshotForReport, "image/png", "failScreenshot");
	}
	
	// Set browser options for headless running
	private void setupHeadlessRun(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			chromeOptions.setHeadless(true);
		}else if(browser.equalsIgnoreCase("firefox")) {
			firefoxOptions.setHeadless(true);
			}	
	}

}
