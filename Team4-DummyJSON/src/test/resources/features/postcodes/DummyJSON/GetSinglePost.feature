Feature: Get Single Post

  @tugas
  Scenario Outline: Get Single Post Valid Parameter
    Given Get single post with parameter id <id>
    When Send get single post request
    Then Status code should response 200 OK
    And Body response page should be id <id>
    And Validate get single post json schema
  Examples:
    | id  |
    | 2   |
    | 20  |
    | 120 |

  @tugas
  Scenario Outline: Get Single Post Invalid Parameter by Number
    Given Get single post with invalid parameter id <id>
    When Send get single post request
    Then Status code should response 404 Not Found
  Examples:
    | id  |
    | 200 |
    | 210 |
