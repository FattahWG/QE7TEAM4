Feature: Delete Cart

  @tugas
  Scenario Outline: Delete Cart With Valid Parameter
    Given Delete cart with valid id <id>
    When Send delete cart request
    Then Status code should response 200 OK
    And Validate delete cart json schema
  Examples:
    | id |
    | 4  |
    | 5  |
    | 6  |

  @tugas
  Scenario Outline: Delete Cart With Invalid Parameter
    Given Delete cart with invalid id <id>
    When Send delete cart request
    Then Status code should response 404 Not Found
  Examples:
    | id  |
    | 300 |
    | 400 |