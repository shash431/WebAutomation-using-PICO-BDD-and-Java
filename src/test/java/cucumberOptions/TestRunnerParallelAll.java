package cucumberOptions;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/features", 
			     glue ="stepDefinitions", 
			     plugin={"json:target/jsonReports/cucumber-report.json"})
public class TestRunnerParallelAll extends AbstractTestNGCucumberTests{
	
	// Run parallel using cucumber testNG
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}
