Feature: Login
    As a user, I want to see text: Hello World!

    @login-feature
    Scenario: Show Hello World!
        Given I am on login screen
        Then I should see text: Hello World!