Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given user is on login page
    When user enters valid username "student" and password "Password123"
    And user clicks on login button
    Then "Logged In Successfully" message should be displayed
