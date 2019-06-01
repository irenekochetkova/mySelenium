@webdriver @smoke
Feature: WebDriver feature

  @webdriver1
  Scenario: Printing details
    Given I go to "sample" page
    And I print page details


  @webdriver2
  Scenario: Navigation
    Given I go to "sample" page
    When I go to "google" page
    And I go back and forward, then refresh the page


  @webdriver3
  Scenario: Logs
    Given I go to "yahoo" page
    And I print logs to the console

  @webdriver4
  Scenario: Fill out required fields
    Given I go to "sample" page
    And I fill out required fields
    And I fill out other fields
    When I verify email field behavior
    And I submit the page
    Then I verify required fields

  

