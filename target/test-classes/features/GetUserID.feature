Feature: Get Post By User ID

  @tugas
 Scenario Outline: Get Post By User ID
    Given Get post by user id wit valid parameter userid <userid>
    When Send get post by user request
    Then Status code should response 200 OK
    And Validate get post by user id json schema
 Examples:
   | userid |
   | 5      |
   | 25     |
   | 50     |

 @tugas
 Scenario Outline:
   Given Get post by user id with invalid parameter userid <userid>
   When Send get post by user request
   Then Status code should response 404 Not Found
 Examples:
   | userid |
   | 150    |
   | 200    |