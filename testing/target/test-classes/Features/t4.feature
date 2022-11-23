Feature: working with web application

  Scenario: newtours web app
    Given user is in new tours
    When user need to enter username and password
    Then user clicks on submit button
    And user takes screenshot and close the page
