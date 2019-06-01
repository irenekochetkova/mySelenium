@usps_obj @regression
Feature: USPS Scenarios in page object

  @usps_obj1
  Scenario: Stamps
    Given I open "usps" page
    When I go to "stamps"
    Then I verify "$0 to $5" section exists
    When I sort by "Price (Low-High)"
    Then I verify that "Silver Coffeepot" is cheapest

  @usps_obj2
  Scenario: Boxes
    Given I open "usps" page
    When I go to "boxes"
    Then I verify "$0 to $5" section exists
    When I sort by "Price (Low-High)"
    Then I verify that "Priority Mail Shoe Box" is cheapest

  @usps_obj3
  Scenario: Validate ZIP code page object
    Given I open "usps" page
    When I go to "Lookup ZIP"
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state page object
    Then I validate "94022" zip code exists in the result page object

  @usps_obj4
  Scenario: Calculate price logic page object
    Given I open "usps" page
    When I go to "Calculate Price"
    And I select "United Kingdom" with "Postcard" shape page object
    And I define "2" quantity page object
    Then I calculate the price and validate cost is "$2.30" page object

  @usps_obj5
  Scenario: Wrong store id does not match page object
    Given I open "usps" page
    When I go to "Postal Store"
    And I enter "12345" into store search page object
    Then I search and validate no products found page object