@regression
Feature: Filter and Sort Products

  Background:
    Given user is logged in to SauceDemo

  Scenario: User filters products by price low to high
    When user sorts products by "Price (low to high)"
    Then products should be displayed in ascending price order

  Scenario: User filters products by price high to low
    When user sorts products by "Price (high to low)"
    Then products should be displayed in descending price order

  Scenario: User filters products by name A to Z
    When user sorts products by "Name (A to Z)"
    Then products should be displayed in alphabetical order