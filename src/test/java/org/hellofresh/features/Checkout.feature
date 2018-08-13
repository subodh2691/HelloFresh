Feature: Checkout verification

  Scenario Outline: An existing user try to place an order, he should successfully be able to complete the checkout
  	Given User clicks on login button in home page
  	When User enter username as "hf_challenge_123456@hf12345.com" and password as "12345678"
  	And User should be successfully logged in as "Joe Black"
  	And User selects "Women" category
  	And User selects product "<Product_Name>" with size as "<size>", quantity as "<quantity>" and colour as "<color>"
  	And User initiates the checkout
  	Then Order should be successfully placed
  	And User clicks on logout
  	 Examples:
  	 | Product_Name | size | quantity | color |
  	 | Faded Short Sleeve T-shirts | M | 2 | Blue |
  	 | Blouse | L | 5 | White |