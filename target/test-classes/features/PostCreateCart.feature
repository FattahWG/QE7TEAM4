Feature: Post Create Cart

  @tugas
  Scenario: Post Create Cart With Json Body
    Given Post create cart with valid json
    When Send post create cart request
    Then Status code should response 200 OK
    And Response body should contain id 21 and userId 1
    And Validate post create cart json schema