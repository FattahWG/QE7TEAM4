Feature: Get Post ID

  @tugas
  Scenario Outline: Get Post ID Valid Parameter
    Given Get post ID with parameter postid <postid>
    When Send get post ID request
    Then Status code should response 200 OK
    And Validate get post id json schema
    Examples:
      | postid |
      | 1   |
      | 10  |
      | 100 |

  @tugas
  Scenario Outline: Get Post ID Invalid Parameter by Number
    Given Get post ID with invalid parameter postid <postid>
    When Send get post ID request
    Then Status code should response 404 Not Found
    Examples:
      | postid |
      | 200    |
      | 500    |