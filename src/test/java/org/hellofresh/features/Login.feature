Feature: Login verification

  Scenario: An existing user try to login, he should be successfully logged in and shown user details
  	Given User clicks on login button in home page
  	When User enter username as "hf_challenge_123456@hf12345.com" and password as "12345678"
  	Then User should be successfully logged in as "Joe Black"
  	And User clicks on logout