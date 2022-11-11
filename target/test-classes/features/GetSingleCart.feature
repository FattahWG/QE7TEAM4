Feature: Get Single Cart

  @tugas
  Scenario Outline: Get Single Cart With Valid Paramter
    Given Get single cart with valid id <id>
    When Send get single cart request
    Then Status code should response 200 OK
    And Response body should contain id <id>
    And Validate get single cart json schema
  Examples:
    | id |
    | 5  |
    | 10 |
    | 20 |

  @tugas
  Scenario Outline: Get Single Cat With Invalid Parameter
    Given Get single cart with invalid id <id>
    When Send get single cart request
    Then Status code should response 404 Not Found
  Examples:
    | id   |
    | 1000 |
    | 2000 |
    | 3000 |