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
Feature: Add Device to Device Pool
  


  @addDevice @smoke
  Scenario Outline: Add a valid Device to pool
    Given the login api and payload having account as "<account>" username as "<username>" and password as "<password>"
    When  User sends Post https Request to login API
    Then Verify status code is 200 and token is generated
    Given Add APi and payload having device SR no, devicetype as <devicetype>, publicKey as "<publicKey>", publicKeyType as "<publicKeyType>"
    When User sends Post request to Add API
    Then Status code should be 200 and user validates response body

    Examples: 
      | account  | username | password  | devicetype | publicKey | publicKeyType |
      | Conti_HQ | Conti_HQ | Conti_HQ  | 1          | -----BEGIN PUBLIC KEY-----\r\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEtwADUKo8jGz48q+hfqXwugWkoGNd\r\nbkOpD3TGW5tqRIyo6XAPetbOQ/b/cf/96AGehX+2QWsItukdmWsaDno7Mg==\r-----END PUBLIC KEY----- | ES256_PEM |
