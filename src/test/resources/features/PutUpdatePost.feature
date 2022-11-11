Feature: Put Update Post

  @tugas
  Scenario Outline: Put Update Post
    Given Put update post with valid json with id <id>
    When Send put update post request
    Then Status code should response 200 OK
    And Body response should contain title "not a title" and body "yuhuu"
    And Validate put update post json schema
  Examples:
    | id |
    | 5  |
    | 10 |