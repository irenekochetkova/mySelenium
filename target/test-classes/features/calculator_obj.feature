@calculator_obj
Feature: Calculator Feature

  @calculator1
  Scenario: Verify calculator result
    Given I open "calculator" page
    When I go to "Auto Loan Calculator" calculator page
    And I clear all calculator fields on the page
    And I click calculate
    Then I verify "Please provide a positive auto price." calculator error on the page
    Then I verify "Please provide a positive interest value." calculator error on the page
    And I enter "25000" price, "60" months, "4.5" interest, "5000"  downpayment, "0" trade-in, "California" state, "7" percent tax, "300" fees on the calculate page
    And I click calculate
    Then I verify monthly pay is "$372.86" on the page