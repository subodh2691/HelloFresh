Feature: Create a new account for new user

  Scenario Outline: For new user, click on login and create a new account
  	Given User clicks on login button in home page
  	When User enters his email and click on submit
  	And User enter Firstname as "<Firstname>", lastname as "<Lastname>" and password as "<Password>"
  	And User enter contact details as "<Company>", "<Address1>", "<Address2>", "<City>", "<State>", "<PostCode>", "<Phone>", "<Mobile>", "<Alias>"
  	Then User account should be created successfully with name as "<Firstname>" "<Lastname>"
  	 Examples:
    | Firstname | Lastname | Password | Company | Address1 | Address2 | City | State | PostCode | Phone | Mobile | Alias |
    |    Subodh |   Agnihotri | testHelloFresh | Company | Qwerty, 123 | zxcvb | Qwerty | Colorado | 12345 | 12345123123 | 12345123123 | hf |