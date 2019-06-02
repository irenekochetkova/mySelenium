@converter_obj
  Feature: Converter functions

    Background:
      Given I open "converter" page

    @converter1
    Scenario: Validate Fahrenheit to Celsius
      When I click on "Temperature" tab
      And I set from "Fahrenheit"  to "Celsius"
      Then I enter into From field "54" and verify "12.2" result of conversion

    @converter2
    Scenario: Validate Pound to Kilogram
      When I click on "Weight" tab
      And I set from "Pound"  to "Kilogram"
      Then I enter into From field "170" and verify "77" result of conversion

    @converter3
    Scenario Outline: Validate various
      When I click on "<tab>" tab
      And I set from "<from>"  to "<to>"
      Then I enter into From field "<tab_content_from>" and verify "<tab_content_to>" result of conversion
      Examples:
        | tab         | from        |  to       | tab_content_from | tab_content_to |
        | Temperature | Fahrenheit  | Celsius   | 54               | 12.2           |
        | Weigh       | Pound       | Kilogram  | 170              | 77             |
        | Length      | Mile        | Kilometer | 50               | 80.4           |