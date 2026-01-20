@logout
Feature: Logout functionality

  Background:
    Given user is logged in to SauceDemo

  Scenario: User logs out successfully
    When user clicks on logout
    Then user should be redirected to login page
    And login page should be displayed
