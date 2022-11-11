Feature: Get Single Product

  @product
  Scenario Outline: Get Single Product With Valid Parameter
    Given Get single product with valid parameter id <id>
    When Send get single product request
    Then Status code response should be 200 OK
    And Body response should contain id <id>
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @product
  Scenario Outline: Get Single Product With Invalid Parameter
    Given Get single product with invalid parameter id <id>
    When Send get single product request
    Then Status code response should be 404 Not Found
  Examples:
    | id   |
    | 1000 |
    | 2000 |