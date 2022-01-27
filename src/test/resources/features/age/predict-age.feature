Feature: Predict the age

  @StatusCode-200
  Scenario Outline: Predict age based on a name
    When the user send a GET request to predict the age by name "<name>"
    Then the request should return status code as <statusCode>
    And verify the fields in the GET response
    Examples:
      |name |statusCode|
      |Tony |200       |
      |Bruce|200       |


  @StatusCode-422
  Scenario Outline: Predict age when blank name is provided
    When the user send a GET request to predict the age by name "<name>"
    Then the request should return status code as <statusCode>
    Examples:
      |name|statusCode|
      |    |422       |

