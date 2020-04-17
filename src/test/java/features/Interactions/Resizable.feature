@Interactions
Feature: Resizable functionality

	Scenario: Check resize placeholder
	    Given User click in "Resizable" item
	    When User can resize placeholder
	    Then Placeholder is resized