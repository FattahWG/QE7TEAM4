Feature: Mockup http dummyjson
  @mockup
  Scenario Outline: Http mockup
    Given Get http mockup <status>
    When Send get http request
    Then Status code should be <status> <message>
    And Respon body should be status <status> and message <message>
    And Validate http mockup with valid json
    Examples:
      | status | message     |
      | "200"  | "OK"        |
      | "404"  | "Not Found" |

  @mockup
  Scenario: Http mockup custom
    Given Post http mockup custom "Hello_Peter"
    When Send post http mockup custom
    Then Status code should be 404 Not Found
    And Respon body should be status "404" and message "Hello_Peter"
    And Validate http mockup custom with valid json