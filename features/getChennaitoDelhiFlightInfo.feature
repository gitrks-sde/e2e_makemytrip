@tag
Feature: Ticket Details

  Background: 
    When user selects "Chennai" as From location

  @regression
  Scenario: get chennai to delhi ticket info
    When user selects "Delhi" as To location
    When user clicks on "search" button
    Then verify the available tickets
    And close the browser
    
	@test1
  Scenario: get chennai to singapore ticket info
    When user selects "Singapore" as To location
    When user clicks on "search" button
    Then verify the available tickets
    And close the browser
    

