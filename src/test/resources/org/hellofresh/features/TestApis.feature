Feature: [JSON] Test api

  Scenario: Get All Country and verify
    Given with resource url as "/country/get/all" ,get request details
    Then verify respone with status code as "200"
    And validate that "US,DE,GB" were returned in the response

  Scenario: Get particular country detail and verify
    Given with resource url as "/country/get/iso2code/US" ,get request details
    Then verify respone with status code as "200"
    And validate that country name "United States of America" were returned in the response

  Scenario: Add country and verify
    Given with resource url as "/country/post/addcountry" ,post request to add country with json as:
      """
      {
       name: "Test Country",
       alpha2_code: "TC",
       alpha3_code: "TCY"
      }
      """
    Then verify respone with status code as "200"
