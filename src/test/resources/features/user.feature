Feature: User DummyJson
  Scenario: Get list user with valid path
    Given Get list user with valid path
    When Send get list user request
    Then Status code should be 200 OK
    And Validate get list user with valid json

  Scenario Outline: Get single user with valid parameter id
    Given Get single user with valid parameter id <id>
    When Send get single user request
    Then Status code should be 200 OK
    And Validate get single user with valid json
    Examples:
      | id |
      | 1 |

    Scenario Outline: Get single user with invalid parameter page
      Given Get single user with invalid parameter page "<page>"
      When Send get single user request
      Then Status code should be 400 Bad request
      Examples:
        | page    |
        | 1jdnc   |
        | adafjdf |
        | !@#$%   |

  Scenario Outline: Get single user with invalid parameter id
    Given Get single user with invalid parameter id <id>
    When Send get single user request
    Then Status code should be 404 Not Found
    Examples:
      | id   |
      | 1234 |
      | 5678 |

  Scenario Outline: Get search user with valid path
    Given Get search user with valid page "<page>"
    When Send get search user request
    Then Status code should be 200 OK
    And Validate get search user with valid json
    Examples:
      | page |
      | Jhon |
      | 12   |
      | 1    |

  Scenario Outline: Get search user with invalid path
    Given Get search user with invalid page "<page>"
    When Send get search user request
    Then Status code should be 400 Bad request
    Examples:
      | page  |
      | !@#$% |

  Scenario Outline: Get filter user with valid path
    Given Get filter user with valid key "<key>" and value "<value>"
    When Send get filter user request
    Then Status code should be 200 OK
    And Validate get filter user with valid json
    Examples:
      | key        | value |
      | hair.color | Brown |


  Scenario Outline: Get user carts by user id
    Given Get user carts with valid path by user id <id>
    When Send get user carts request
    Then Status code should be 200 OK
    And Validate get user carts by id with valid json
    Examples:
      | id |
      | 5  |
      | 7  |

  Scenario Outline: Get user carts with invalid user id
    Given Get user carts with invalid path by user id "<id>"
    When Send get user carts request
    Then Status code should be 400 Bad request
    Examples:
      | id    |
      | @#$%  |
      | esdbh |
      | 1dw89 |
      | +)#dq |
      | @12zx |

  Scenario Outline: Get user posts by user id
    Given Get user post with valid id <id>
    When Send get user posts request
    Then Status code should be 200 OK
    And Validate get user posts with valid json
    Examples:
      | id |
      | 5  |
      | 7  |
      | 1  |


  Scenario Outline: Get user todos by user id
    Given Get user todos with valid id <id>
    When Send get user todos request
    Then Status code should be 200 OK
    And Validate get user todos with valid json
    Examples:
      | id |
      | 5  |

  Scenario Outline: Get user todos with invalid user id
    Given Get user todos with invalid path by user id "<id>"
    When Send get user todos request
    Then Status code should be 400 Bad request
    Examples:
      | id      |
      | !@ght#5 |
      | zxcvfr  |
      | !@#$%   |

  Scenario: Post add a new user
    Given Post add a new user with valid json
    When Send post add a new user
    Then Status code should be 200 OK
    And Validate post add a new user with valid json

  Scenario Outline: Put update user
    Given Put update user id <id> with valid json
    When Send put update user request
    Then Status code should be 200 OK
    And Validate put update user with valid json
    Examples:
      | id |
      | 1  |


  Scenario Outline: Delete user with valid id
    Given Delete user with id <id>
    When Send delete user request
    Then Status code should be 200 OK
    Examples:
      | id |
      | 2  |


