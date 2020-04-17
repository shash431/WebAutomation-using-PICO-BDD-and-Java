@Interactions
Feature: Droppable functionality

	Scenario: Check drag and drop
	    Given User click in "Droppable" item
	    When User can drag drop the element
	    Then Element is dropped