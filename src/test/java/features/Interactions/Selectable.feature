@Interactions
Feature: Selectable functionality

	Scenario: Check one item selection
	    Given User click in "Selectable" item
	    When User can "select 1" item
	    Then Items are selected
	@sanity
	Scenario: Check two items selection
	    Given User click in "Selectable" item
	    When User can "select 3" item
	    Then Items are selected