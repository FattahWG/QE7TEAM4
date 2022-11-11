Feature: Get Search Post Body

  @tugas
  Scenario Outline: Get Search Post Body
    Given Get search post body with valid parameter word "<word>"
    When Send get search post body request
    Then Status code should response 200 OK
    And Validate get search post body json schema
  Examples:
    | word |
    | love |
    | how  |
    | 25   |