Feature: quotes dummyjson

  @quotes
  Scenario: Get all quotes
    Given Get all quotes
    When Send get Get all quotes request
    Then Status code should be 200 OK

  @quotes
  Scenario Outline: Get a single quote valid id
    Given Get single quote id <id>
    When Send get single quote id
    Then Status code should be 200 OK
    And Validate get single qute id with valid json
    Examples:
      | id |
      | 11 |
      | 20 |

  @quotes
  Scenario Outline: Get a single quote invalid id
    Given Get quote invalid id <id>
    When Send get single quote invalid id
    Then Status code should be 404 Not Found
    Examples:
      | id   |
      | 1100 |
      | 2010 |

 @quotes
  Scenario: Get a random quotes
    Given Get a random quotes
    When Send get a random quotes request
    Then Status code should be 200 OK


