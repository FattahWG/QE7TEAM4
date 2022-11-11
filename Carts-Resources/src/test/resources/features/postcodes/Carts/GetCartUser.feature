Feature: Get Cart User By User ID

  @tugas
  Scenario Outline: Get Cart User With Valid Parameter
    Given Get cart user with valid userId <userId>
    When Send get cart user request
    Then Status code should response 200 OK
  Examples:
    | userId |
    | 1      |
    | 5      |

  @tugas
  Scenario Outline: Get Cart User With Invalid Parameter
    Given Get cart user with invalid userId <userId>
    When Send get cart user request
    Then Status code should response 404 Not Found
  Examples:
    | userId |
    | 700    |
    | 800    |
    | 900    |