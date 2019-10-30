Feature: Login
  As a user, I want to login to existing account, otherwise I want to sign up.

  @login-feature
  Scenario Outline: Invalid inputs: email, password
    Given I see empty login form
    When I input email <email>
    And I input password <password>
    And I click login button
    Then I should see error on <view> view
    Examples:
      | email          | password | view     |
      | test           | admin    | email    |
      | test@gmail.com |          | password |