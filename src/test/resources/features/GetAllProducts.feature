Feature: Get All Products

  @product
  Scenario: Get All Products
    Given Get All Products
    When Send all products request
    Then Status code response should be 200 OK
    And Validate get all products json schema