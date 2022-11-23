Feature: working with web application

  Scenario: newtours web app
    Given user is in new tours
    When user need to enter username and password and click on submit
    Then navigate back to register page and capture the dropdown elements and store in xlsheet
    And user takes screenshot
