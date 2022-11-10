Feature: Post Create Post

  @tugas
  Scenario: Post Create Post With Json Body
    Given Post create post with valid json
    When Send post create post request
    Then Status code should response 200 OK
    And Body response should contain title "no title" and userId 5
    And Validate post create post json schema