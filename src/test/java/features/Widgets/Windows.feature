@Widgets
Feature: Windows functionality

	Scenario: Check new windows browser
	    Given User click in "Automation Practice Switch Windows" item
	    When User click on "New Browser Window" button
	    Then A new window is open
	    
	Scenario: Check new tab
	    Given User click in "Automation Practice Switch Windows" item
	    When User click on "New Browser Tab" button
	    Then User get redirected to "https://www.toolsqa.com/"
	    
    @ignore
	Scenario: Check alert
	    Given User click in "Automation Practice Switch Windows" item
	    When User click on "Alert Box" button
	    Then User checks the text and close the alert popup
	   