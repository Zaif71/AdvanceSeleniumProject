Feature: Validate product details in cart
  As a user
  I want to verify product details in the cart
  So that correct product information is displayed before checkout

  @cart @validation
  Scenario: Validate product name, price and quantity in cart
    When user is logged in to SauceDemo
    And user adds "Sauce Labs Backpack" to the cart
    And user navigates to cart page
    Then product name should be "Sauce Labs Backpack"
    And product price should be "$29.99"
    And product quantity should be "1"

  @cart @validation
  Scenario Outline: Validate multiple product details in cart
    When user is logged in to SauceDemo
    And user adds "<productName>" to the cart
    And user navigates to cart page
    Then product name should be "<productName>"
    And product price should be "<price>"
    And product quantity should be "<quantity>"

    Examples:
      | productName             | price  | quantity |
      | Sauce Labs Backpack     | $29.99 | 1        |
      | Sauce Labs Bike Light   | $9.99  | 1        |
      | Sauce Labs Bolt T-Shirt | $15.99 | 1        |