Feature: working on login window
Scenario Outline: newtours application
Given user is in newtours
When user needs to enter <uname> and <password>
Then user click on signon button
And user navigate to home page