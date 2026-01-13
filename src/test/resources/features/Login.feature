Feature: SauceDemo Login

  Scenario Outline: Login with different credentials
    Given user is on SauceDemo login page
    When user logs in with "<username>" and "<password>"
    Then login outcome should be "<result>"

    Examples:
      | username        | password     | result  |
      | standard_user   | secret_sauce | success |
      | standard_user   | wrong_pass   | failure |
      | locked_out_user | secret_sauce | failure |
      |                 | secret_sauce | failure |
      | standard_user   |              | failure |
      |                 |              | failure |





