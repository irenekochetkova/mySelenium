@converter
Feature: Converter functions

  Background:
    Given I go to "converter" page

  @converter1
  Scenario: Validate Fahrenheit to Celsius
    When I click on "Temperature"
    And I set "Fahrenheit" to "Celsius"
    Then I enter into From field "54" and verify "12.2" result

  @converter2
  Scenario: Validate Pound to kilogram
    When I click on "Weight"
    And I set "Pound" to "Kilogram"
    Then I enter into From field "170" and verify "77" result

  @converter3
  Scenario: Validate Mile to Kilometer
    When I click on "Length"
    And I set "Mile" to "Kilometer"
    Then I enter into From field "50" and verify "80.4" result

  @converter4
  Scenario Outline: Validate various
    When I click on "<tab>"
    And I set "<from>" to "<to>"
    Then I enter into From field "<tab_content_from>" and verify "<tab_content_to>" result
    Examples:
      | tab         | from        |  to       | tab_content_from | tab_content_to |
      | Temperature | Fahrenheit  | Celsius   | 54               | 12.2           |
      | Weigh       | Pound       | Kilogram  | 170              | 77             |
      | Length      | Mile        | Kilometer | 50               | 80.4           |