@Regression
Feature: Regression test cases

  @TC=C00001
  Scenario: C00001-Verify the link present on homePage
    When User launched URL
    And get the all link
    And Verify the link is broken or not  
   
   @TC=C00002
   Scenario: C00002-Navigate to first and second link and verify the functionality
    When User launched URL
    And get the all link
    And Navigate to first link
    And Verify the element present on link
   
   @TC=C00003
   Scenario: C00003-Navigate to basic auth link
    When User launched URL
    And get the all link
    And Navigate to basic auth link 
    And Verify the element on auth link