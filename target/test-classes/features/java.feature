@java
Feature: Java intro

  @java1
  Scenario: Custom step
    Given I write my step

  @java2
  Scenario: Strings
    Given I do actions with "my var" and "my VAR"

  @java3
  Scenario: Printing
    Given I print "my value"
    And I print "new value"

  @java4
  Scenario: Impl steps
    Given I print "Google"
    And I do actions with "orange" and "ORANGE"


  @java5
  Scenario: comparison
    Given I compare "apple" and "orange"

  @java6
  Scenario: Print URL for a given site
    Given I print url for site "yahoo"

  @java7
  Scenario: Arrays
    Given I work with arrays


  @java8
  Scenario: Maps
    Given I work with maps

  @java9
  Scenario: Tests
    Given I play with string

  @java10
  Scenario: Classes
    Given I create classes

