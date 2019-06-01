@wd
Feature: WD

  @wd1
  Scenario: WD scenario
    Given I open workday careers
    When I select any position
    And I go to apply with LinkedIn
    Then I verify Oauth page opens