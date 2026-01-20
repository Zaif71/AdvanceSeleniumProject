@regression
Feature: Add products to the cart

  Background:
    Given user is logged in to SauceDemo

  Scenario: User adds multiple products to the cart
    When user adds "Sauce Labs Backpack" to the cart
    And user adds "Sauce Labs Bike Light" to the cart
    Then cart badge count should be "2"

  Scenario: User completes checkout with products in cart
    When user navigates to cart
    And user proceeds to checkout
    And user enters checkout details
      | firstName | Zaif   |
      | lastName  | Techi  |
      | zipCode   | 122107 |
    And user completes the checkout
    Then checkout should be successful
  
