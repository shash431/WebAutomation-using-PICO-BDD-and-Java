package cucumberOptions;

import java.io.File;

import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", 
glue ="stepDefinitions", 
plugin={"json:target/jsonReports/cucumber-report.json"},
tags={"@Widgets","@Interactions", "not @ignore"})
public class TestRunnerSerial extends AbstractTestNGCucumberTests{
	
@BeforeSuite
public void deleteScreenShots() {
	System.out.println("Deleting screenshot files");
	File screenshotDir = new File(System.getProperty("user.dir")+"/screenshots/");
	File[] screenshots = screenshotDir.listFiles();
	for (File screenshot : screenshots){
		screenshot.delete();
	}
}
	
}
