Feature: Put Update Product

  @product
  Scenario Outline: Put Update Product
    Given Put update product with valid json with id <id>
    When Send put update product request
    Then Status code should response 200 OK
    And Body response should contain title "BMW Pencils update"
    Examples:
      | id |
      | 5  |
      | 10 |