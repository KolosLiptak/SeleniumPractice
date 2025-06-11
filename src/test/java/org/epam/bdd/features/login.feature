Feature: Login functionality

    Background:
        Given I am on the login page

    @saucedemo @smoke
    Scenario: Successful login
        When I log in with username "standard_user" and password "secret_sauce"
        Then I should see my dashboard

    @saucedemo
    Scenario Outline: Failed login
        When I log in with username "<username>" and password "<password>"
        Then I should see error message

        Examples:
            |   username        |   password    |
            |   standard_user   |   abcd123     |
            |   invalid         |   invalid     |
            |   admin           |   admin       |
