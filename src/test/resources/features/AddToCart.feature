@regression
Feature: Add product to cart

  Scenario: User adds a product to cart successfully
    Given user is logged in to SauceDemo
    When user adds "Sauce Labs Backpack" to the cart
    Then cart badge count should be "1"
