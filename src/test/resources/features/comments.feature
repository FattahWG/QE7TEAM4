Feature: comments dummyjson

  @comments
  Scenario: Get list comments
    Given Get list comments with valid path
    When Send get list comments request
    Then Status code should be 200 OK
    And  Respon body should be total comment 340 and limit view 30
    And Validate get list comments with valid json


  @comments
  Scenario Outline: Get comments id
    Given Get comments id <id>
    When Send get comments id
    Then Status code should be 200 OK
    And Respon body should be id <id> and post id <postId>
    And Validate get comments id with valid json
    Examples:
      | id | postId |
      | 1  | 100    |
      | 2  | 27     |
      | 3  | 61     |

  @comments
  Scenario Outline: Get comments post id
    Given Get comments post id <postId>
    When Send get comments post id
    Then Status code should be 200 OK
    And Respon body should be total comments <total>
    And Validate get comments post id with valid json
    Examples:
      | postId | total |
      | 1      | 1     |
      | 2      | 5     |
      | 3      | 6     |
      | 4      | 4     |

  @comments
  Scenario: Get comment with invalid id
    Given Get comments invalid id comments 341
    When Send get comments invalid id
    Then Status code should be 404 Not Found
    And Respon body should be "Comment with id '341' not found"
    And Validate get comment invalid id with valid json

  @comments
  Scenario: Post new comments
    Given Post new comments with valid json
    When Send post new comments request
    Then Status code should be 200 OK
    And Respon body should be new id 341 and post id 3
    And Validate post new comments with valid json

  @comments
  Scenario Outline: Put update comments
    Given Put update comments id <id> with valid json
    When Send put update comments request
    Then Status code should be 200 OK
    And Respon body should be id <id> and comments <comments>
    And Validate put update comments with valid json
    Examples:
      | id | comments                             |
      | 1  | "I think I should shift to the moon" |
      | 2  | "I think I should shift to the moon" |
      | 3  | "I think I should shift to the moon" |

  @comments
  Scenario Outline: Delete comments
    Given Delete comments id <id>
    When Send delete comments id
    Then Status code should be 200 OK
    And Respon body should be id <id> and user id <userId>
    And Validate delete comments with valid json
    Examples:
      | id | userId |
      | 1  | 63     |
      | 2  | 71     |
      | 3  |29      |




