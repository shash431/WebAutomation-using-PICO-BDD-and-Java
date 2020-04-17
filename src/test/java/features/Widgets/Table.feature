@Widgets
Feature: table functionality

	Scenario Outline: Check that elements are displayd in tha table
		Given User click in "Automation practice table" item
		Then structure <Structure> located in <Country> in city <City> with a height of <Height> built in <Built>
			
			Examples:
			|Structure   |Country |City  |Height |Built |
			|Burj Khalifa|UAE     |Dubai |829m   |2010  |
			|Taipei 101  |Taiwan  |Taipei|509m   |2004  |
	    
	   