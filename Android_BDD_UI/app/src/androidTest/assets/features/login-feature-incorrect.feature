Feature: Login Incorret
  Perform login on username and password are inputted

  @login-feature-incorrect
  Scenario Outline: Input incorrect username and/or password
    Given I have a login activity
    When I input username <username>
    And I input password <password>
    And I press submit button
    Then I should not see the next activity


    Examples:
      | username    | password     |
      | test1       | 123456_wrong |
      | test2_wrong | 987654321    |
      | test3_wrong | qwerty_wrong |
