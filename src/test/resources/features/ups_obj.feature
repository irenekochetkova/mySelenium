@ups_obj
Feature: UPS Scenarios  in page object

  @ups1_obj @smoke
  Scenario: UPS end to end
    Given I open "ups" page
    And I open Shipping menu on the page
    And I go to Create a Shipment on the page
    When I fill out origin shipment fields on the page
    And I submit the shipment form of the page
    Then I verify origin shipment fields on the page submitted
    When I fill out destination shipment fields on the page
    Then I verify total charges appear on the page
    When I submit the shipment form of the page
    And I set packaging type on the page
    Then I verify total charges changed on the page
    When I submit the shipment form of the page
    And I select cheapest delivery option on the page
    And I submit the shipment form of the page
    And I set Saturday Delivery type of the page
    Then I verify total charges changed on the page
    When I submit the shipment form of the page
#    And I select Paypal payment type
#    And I submit the shipment form
#    Then I review all recorded details on the review page
#    And I cancel the shipment form
#    Then I verify shipment form is reset
