Feature: Login
  As a user, I want to see text: Hello World!

  @login-feature
  Scenario: Invalid password
    Given I see empty login form
    When I input valid email
    And I input invalid password
    And I press login button
    Then I should see error on password view