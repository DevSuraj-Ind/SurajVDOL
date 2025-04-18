#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@API
Feature: Login API should return 200 when success and 401 for invalid credentials

  @login @smoke
  Scenario Outline: Login with valid credentials
    Given the login api and payload having account as "<account>" username as "<username>" and password as "<password>"
    When User sends Post https Request to login API
    Then Verify status code is 200 and token is generated
    
   Examples: 
      | account  | username | password  |
      | Conti_HQ | Conti_HQ | Conti_HQ  |
      
     
     #@smoke 
     #Scenario Outline: Login with invalid credentials
    #Given the login api and payload having account as "<account>" username as "<username>" and password as "<password>"
    #When User sends Post https Request to login API
    #Then Verify status code is 401
    #
   #Examples: 
      #| account  | username | password  |
      #| Test     | Test     | Test      |

    
