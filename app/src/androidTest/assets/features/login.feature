Feature: Login
  As a user, I want to login to existing account, otherwise I want to sign up.

  @login-feature
  Scenario Outline: Input validation: email or password in wrong format
    Given I see empty login form
    When I input email <email>
    And I input password <password>
    And I click login button
    Then I should see error on <view> view
    Examples:
      | email          | password | view     |
      | test           | admin    | email    |
      | test@gmail.com |          | password |

  @login-feature
  Scenario Outline: Credentials authorization: email and password in correct format
    Given I see empty login form
    When I input email <email>
    And I input password <password>
    And I click login button
    Then I should see authorization error <visible>
    Examples:
      | email          | password | visible |
      | test@gmail.com | kitkat   | false   |
      | test@gmail.com | doughnut | true    |
      | user@gmail.com | kitkat   | true    |