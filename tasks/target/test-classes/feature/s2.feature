Feature: web application

  Scenario: newtours application
    Given Opening chrome browser  & Navigate to newtours.demoaut.com
    When Get the title & url of the page
    Then Check the expected title to actual title of the page & Count all links and store in excelsheet
    And Take the screenshot & Close the browser
