Feature: Delete Post

  @tugas
  Scenario Outline: Delete Post
    Given Delete post with valid id <id>
    When Send delete post request
    Then Status code should response 200 OK
    And Validate delete post json schema
  Examples:
    | id |
    | 8  |
    | 16 |