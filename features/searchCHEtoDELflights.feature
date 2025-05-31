Feature: Search tickets

	Scenario: search flight tickets for Chennai to Delhi
	Given user landed on makemytrip
	When user selects From location
	When user selects To location
	Then user selects Todays date
	When user clicks on search button
	Then validate tickets are loaded