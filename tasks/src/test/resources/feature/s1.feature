Feature: working with web application

  Scenario: amazon web page
    Given user is in amazon page
    When user needs to get url and get title
    Then get links frpm dropdown and navigate back and capture the dropdown elements and store in xlsheet
    And user takes screenshot of the page