@tag
Feature: Sanity test 

  @regression
  Scenario: Verify search is working
    Then user clicks on "closePopup" button
    And user clicks on "closeAd" button
    When user clicks on "search" button
    And close the browser
    
  @sunday  
  Scenario: Verify search is working
  When user enter "chennai" as from location
  And close the browser
  
  @smoke @regression
  Scenario: Verify search is working two
  And close the browser
  
  @sanity
  Scenario: Verify search is working three
  And close the browser
    

