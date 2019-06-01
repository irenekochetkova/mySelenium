@sample
Feature: sample scenarios

  @sample1
  Scenario: Search book
    Given I open url "https://www.amazon.com/"
    Then I type "book" into element with xpath "//input[@id='twotabsearchtextbox']"
    Then I click on element with xpath "//input[@value='Go']"
    And I click on element with xpath "//a[@class='nav-a']/*[contains(text(),'Children')]"
    Then I wait for element with xpath "//a[@class='nav-a']/*[contains(text(),'Children')]" to be present
    And I type "potter" into element with xpath "//input[@id='twotabsearchtextbox']"
    Then I click on element with xpath "//input[@value='Go']"
    Then I click on element with xpath "//span[text()='Harry Potter Complete Book Series Special Edition Boxed Set']/.."
    Then I wait for element with xpath "//span[text()='Harry Potter Complete Book Series Special Edition Boxed Set']/.." to be present
    Then I click on element with xpath "//select[@name='quantity']/option[@value='2']"
    And I click on element with xpath "//input[@id='add-to-cart-button']"
    And I click on element with xpath "//a[@id='hlb-ptc-btn-native']/.."
