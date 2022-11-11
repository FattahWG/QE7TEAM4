Feature: Get All Products Categories

  @product
  Scenario: Get All Products Categories
    Given Get All Products Categories
    When Send all products categories request
    Then Status code response should be 200 OK