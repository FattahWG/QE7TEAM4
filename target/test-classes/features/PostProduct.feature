Feature: Post a Product

  @product
  Scenario: Post Create Product With Json Body
    Given Post create product with valid json
    When Send post create product request
    Then Status code should response 200 OK
    And Body response should contain title "BMW Pencils"