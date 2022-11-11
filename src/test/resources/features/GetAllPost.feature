Feature: Get All Posts

  @tugas
  Scenario: Get All Posts
    Given Get all posts
    When Send get all posts request
    Then Status code should response 200 OK
    And Validate get all post json schema