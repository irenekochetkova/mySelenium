@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@value='Google Search'])[2]"
    Then I wait for element with xpath "//*[@id='ires']" to be present
    Then element with xpath "//*[@id='ires']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title contains "Bing"
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//input[@id='sb_form_go']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com"
    Then I should see page title as "Yahoo"
    Then element with xpath "//input[@name='p']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='p']"
    Then I click on element using JavaScript with xpath "//button[@title='Search Web']"
    Then I wait for element with xpath "//div[@id='web']" to be present
    Then element with xpath "//div[@id='web']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "http://gibiru.com"
    Then I should see page title as "Gibiru - Uncensored Anonymous Search"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@class='gsc-wrapper']" to be present
    Then element with xpath "//div[@class='gsc-wrapper']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@id='links']" to be present
    Then element with xpath "//div[@id='links']" should contain text "Agile"



  @predefined6!!!!!!!!!!!!!!!!!!!!!
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title contains "Swisscows the data"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    And I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//article[@class='item item--web']" to be present
    Then element with xpath "//article[@class='item item--web']" should contain text "methodology"

  @predefined7
  Scenario: Predefined steps for SearchEncrypt
    Given I open url "https://www.searchencrypt.com/"
    Then  I should see page title contains "Search Encrypt"
    Then element with xpath "(//input[@name='q'])[1]" should be present
    When I type "Behavior Driven Development" into element with xpath "(//input[@name='q'])[1]"
    And I click on element with xpath "(//button[@id='btn-secure-search'])[1]"
    Then I wait for element with xpath "//div[@id='results-list']" to be present
    Then element with xpath "//div[@id='results-list']" should contain text "methodology"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    And I click on element with xpath "//span[@class='search-form__button-icon']"
    Then I wait for element with xpath "//ol[@class='list-flat']" to be present
    Then element with xpath "//ol[@class='list-flat']" should contain text "Cucumber"

    @Predefined9
    Scenario: Predefined steps for Yandex
      Given I open url "https://yandex.com/"
      Then I should see page title as "Yandex"
      Then element with xpath "//input[@name='text']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='text']"
      And I click on element with xpath "//button[@type='submit']"
      Then I wait for element with xpath "//div[@class='content__left']" to be present
      Then element with xpath "//div[@class='content__left']" should contain text "methodology"

    @Predefined10
    Scenario: Predefined steps for Boardreader
      Given I open url "http://boardreader.com/"
      Then I should see page title contains "Boardreader"
      Then element with xpath "//input[@id='title-query']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
      And I click on element with xpath "//button[@id='title-submit']"
      Then I wait for element with xpath "//ul[@class='mdl-list']" to be present
      Then element with xpath "//ul[@class='mdl-list']" should contain text "design"

    @Predefined11
    Scenario: Predefined steps for Ecosia
      Given I open url "https://www.ecosia.org/"
      Then I should see page title contains "Ecosia"
      Then element with xpath "//input[@name='q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
      And I click on element with xpath "//button[@type='submit']"
      Then I wait for element with xpath "//p[@class='disclaimer']/.." to be present
      Then element with xpath "//p[@class='disclaimer']/.." should contain text "methodology"
    







