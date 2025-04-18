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


@UI
Feature: General UI Check
  


  @testUI
  Scenario Outline: Verify all required tabs are displayed under HQ
   # Given User launch browser
   # When User opens URL
    And  User enters Account as "<Account>" Username as "<Username>" and Password as "<Password>"
    Then Asset mgmt. tab should be visible
    When User Click on asset mgmt. tab
    Then Asset mgmt. screen should be displayed
    Then StatusOverview tab should be visible
    Then SubscriptionAccount tab should be visible
    Then Device Pool Management tab should be visible
    Then Reports tab should be visible
   # Then Close the Browser

    Examples: 
      | Account  | Username | Password  |
      | Conti_WS | Conti_WS | Conti_WS  |
      

     @E2E 
    Scenario Outline: Verify all required tabs are displayed under HQ
    And  User enters Account as "<Account>" Username as "<Username>" and Password as "<Password>"
    Then Asset mgmt. tab should be visible
    When User Click on asset mgmt. tab
    Then Asset mgmt. screen should be displayed
    Then StatusOverview tab should be visible
    Then SubscriptionAccount tab should be visible
    Then Device Pool Management tab should be visible
    Then Reports tab should be visible
    When User clicks on Device Pool Management tab
    And User clicks on add devices to device pool button
    And User selects add device to device pool manually option
    Then Add Device To Device Pool manually dialog box should be launched
    When User selects publicKeyType "<PublicKeyType>"
    When User selects deviceType "<deviceType>"
    And User enters device SRNo
    And User enters public key "<publicKey>"
    And User clicks on save
    Then The same device no. should be added in device Panel
    When User clicks on Add
    Then Device should be present in device pool
    When User clicks on SubscriptionAccouns tab
    Then End Customers list should be displayed
    When User selcts the endCustomer account
    When User click on add device icon
    
    
    
   

    Examples: 
      | Account  | Username | Password  | deviceType | PublicKeyType |publicKey|
      | Conti_WS | Conti_WS | Conti_WS  | VDOLink    |  RSA_PEM      |-----BEGIN PUBLIC KEY-----\r\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEtwADUKo8jGz48q+hfqXwugWkoGNd\r\nbkOpD3TGW5tqRIyo6XAPetbOQ/b/cf/96AGehX+2QWsItukdmWsaDno7Mg==\r\n-----END PUBLIC KEY-----          |