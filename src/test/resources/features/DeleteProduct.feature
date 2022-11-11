Feature: Delete Product

  @product
  Scenario Outline: Delete Product
    Given Delete product with valid id <id>
    When Send delete product request
    Then Status code should response 200 OK
    Examples:
      | id |
      | 8  |
      | 16 |