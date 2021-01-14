#Author: mail2prashanth1991@gmail.com
Feature: Test Facebook smoke scenario

#Background: 
    #Given Open the browser and start application
    #When I enter username and password
      #| mail2prashanth1991@gmail.com | Meenakshi@123 |
    #And click on login
    
  Scenario Outline: Test Login with Valid Credentials
    Given Open the browser and start application
    When I enter valid "<username>" and "<password>"
    Then user should be able to login successfully

    Examples: 
      | username  | password |
      | prashanth | test     |
      | prashanth | test     |
      | prashanth | test     |
      
       

