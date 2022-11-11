Feature: todos dummyjson

  @todos
  Scenario: Get all todos
    Given Get all todos
    When Send get all todos request
    Then Status code should be 200 OK

  @todos
  Scenario Outline: Get a single todo
    Given Get single todo id <id>
    When Send get single todo id
    Then Status code should be 200 OK
    And Validate get single todo id with valid json
    Examples:
      | id |
      | 1 |
      | 2 |

  @todos
  Scenario: Get all todos by user id
    Given Get all todos by user <id>
    When Send get all todos request
    Then Status code should be 200 OK
