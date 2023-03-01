Feature: Login
  Perform login on username and password are inputted

  @login-feature
  Scenario Outline: Input username and password, login sucess and search on Google
    Given I have a login activity
    When I input username <username>
    And I input password <password>
    And I press submit button
    Then I should see on next activity
    And I should be connected to the Yummly website

    Examples:
      | username | password |
      | admin    | 12345    |






