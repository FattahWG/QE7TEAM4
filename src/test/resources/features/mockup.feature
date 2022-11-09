Feature: Mockup http dummyjson
  @mockup
  Scenario Outline: Http mockup
    Given Get http mockup <status>
    When Send get http request
    Then Status code should be <status> <message>
    And Respon body should be status <status> and message <message>
    And Validate http mocukup with valid json
    Examples:
      | status | message     |
      | "200"  | "OK"        |
      | "404"  | "Not Found" |