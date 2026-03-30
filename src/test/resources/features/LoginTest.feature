Feature: Login Functionality

  As a user
  I want to login to the application
  So that I can access my dashboard

  Background:
    Given the user is on the login page "https://practicetestautomation.com/practice-test-login/"

  Scenario Outline: Successful and unsuccessful login
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks the login button
    Then the user should be "<outcome>"

    Examples:
      | username      | password    | outcome     |
      | student       | Password123 | logged in   |
      # | incorrectUser | wrongpass   | shown error |
      # | student       |             | shown error |
