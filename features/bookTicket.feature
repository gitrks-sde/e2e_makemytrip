@tag
Feature: Ticket Booking
		
		Scenario: Book ticket from chennail to singapore
    Given user landed on homepage
    When user selects "Chennai" as From location
		When user selects "Singapore" as To location
		When user clicks on search button
		Then verify the available tickets
		When user clicks on "viewFare" button
		Then user clicks on "Flexi Plus" Book now
		And close the browser