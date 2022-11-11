Feature: Get All Carts

  @tugas
  Scenario: Get all carts resource
    Given Get all carts
    When Send get all carts request
    Then Status code should response 200 OK
    And Validate get all carts json schema