Automation task documentation.

This project is based on a Maven template, The goal is to automate some functionality
The project is written in Java using Selenium, Cucumber, and TestNG as a runner. 

The project uses a page object pattern architecture combined with a BDD approach (cucumber). BDD approach allows every member of the organization 
to be able to read and understand the tests, and also provide a good test case documentation source. 
Page object pattern is used to have a cleaner and more reusable code, since every page or module of the website has a correspondent class 
having all the web elements and functionality.

File structure

PageObject: We have all the different web elements of a particular page and all the functionality associated with them in one Java class, 
so each page has its own Java class. To grab the elements we use page factory, which makes the code cleaner.

Resources: Here we have the browser functionality file and the sharedProps file. 
The sharedProps file allows parallel test running using cucumber-pico-container. Browser functionality file is in charge of the browser configuration.

CucumberOptions: Here we have the runners, both use testNG to run the tests, 
the difference between them is that one allows running serial and the other parallel. 

Features: Here we have all feature files with the test cases, using Gherkin language.

StepDefinitions: Each one of the steps defined in the feature files has a step definition associated. 
The step definition file interacts with the page files in order to perform actions, also is in charge of running the assertions. 

Screenshot folder: In the case of test failure the framework will take a screenshot and save it in this folder.

Target folder: Here you can find the cucumber reports. This is an HTML report generated once the run is finished.


Parallel running

Parallel running was implemented using picoContainer, this library uses dependency injection to share some information (web driver instance) 
between the different steps of the test cases. 

Browser support

This project supports Chrome and Firefox browsers. By default runs Chrome.

Reports

For the report generation this project uses cucumber-reports, this plugin generates interactive HTML files where all the test results can be checked.

Screenshots

In the case of failure, a screenshot is generated and stored it in the screenshot folder, also the image is added to the cucumber report.

Headless run

It also possible to run the test headless, which means that the browser is not visible.







Run the project

The following command is used to run the project.

 mvn test -Dbrowser=chrome -Dheadless=false -DtestNGfile=testngParallel.xml -Dcucumber.options="--tags @Widgets" verify

Arguments:

browser: is possible to run with Firefox and Chrome, by default uses Chrome
headless: when the argument is true, run headless, which means that the browser is not visible. 
TestNGfile: here you can provide which testng file do you want to run the test with. 
cucumber.options: you can provide tags if you want to run some particular tests.
