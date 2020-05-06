#Author: mail2prashanth1991@gmail.com
Feature: Test Facebook smoke scenario

  Scenario Outline: Test Login with Valid Credentials
    Given Open browser and start applcation
    When I enter valid "<username>" and "<password>"
    Then user should be able to login succesfully

    Examples: 
      | username  | password |
      | prashanth | test     |
      | prashanth | test     |
      | prashanth | test     |
