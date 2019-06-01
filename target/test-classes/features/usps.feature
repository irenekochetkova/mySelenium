@usps
Feature: USPS

  Background:
    Given I go to "usps" page

  @usps1 @smoke
  Scenario: USPS Find ZIP for CA
#    Given I go to "usps" page
    When I go to Lookup ZIP by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result

  @usps2 @smoke
  Scenario: USPS Find ZIP for NY
#    Given I go to "usps" page
    When I go to Lookup ZIP by address
    And I fill out "870 7TH AVE" street, "NEW YORK" city, "NY" state
    Then I validate "10019" zip code exists in the result

  @usps3 @smoke
  Scenario Outline: USPS Find ZIP for multiple states
#    Given I go to "usps" page
    When I go to Lookup ZIP by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<zip>" zip code exists in the result
    Examples:
      | street               | city      | state | zip   |
      | 4970 El Camino Real  | Los Altos | CA    | 94022 |
      | 870 7th ave          | New York  | NY    | 10019 |

  @usps4 @regression
  Scenario: USPS Calculator
#    Given I go to "usps" page
    When I go to Calculate Price page
    And I select "United Kingdom" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.30"




  @usps5 @smoke @Task3
    Scenario: USPS Search the Postal Store
#    Given I go to "usps" page
    When I click Postal Store tab
    Then I enter "12345" into search the Postal Store
    And verify search "did not match any product"

  @usps6 @smoke @Task4
  Scenario: USPS Stamps and Supplies
#    Given I go to "usps" page
    When I go to "Stamps and Supplies" tab
    Then go to Stamps
    And I select Mail Priority Mail
    Then I verify 1 item on the page

  @usps @smoke @Task5
  Scenario:
#    Given I go to "usps" page
    When I go to "Stamps and Supplies" tab
    Then go to Stamps
    And I unselect "Stamps" checkbox
    Then I select Size "24 Months"
    And I click pink color
    Then I verify "Pink" and "24 Months"
    And verify "Just Delivered™ Onesie - Pink" text

  @usps6
  Scenario: PO Box
#    Given I go to "usps" page
    When I go to PO Boxes under Track & Manage
    And I reserve new PO box for "94022"
    Then I verify that "Los Altos — Post Office™" present
    And I verify that "Size 5-XL" PO Box is available in "Los Altos — Post Office™"