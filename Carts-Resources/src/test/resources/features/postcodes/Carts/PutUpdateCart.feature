Feature: Put Update Cart

  @tugas
  Scenario Outline: Put Update Cart
    Given Put update cart with valid json with id <id>
    When Send update cart request
    Then Status code should response 200 OK
    And Validate put update cart json schema
  Examples:
    | id |
    | 6  |