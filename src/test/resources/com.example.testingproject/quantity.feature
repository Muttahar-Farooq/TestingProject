Feature: Testing the change of quantity

  Background:
    Given the user is on Hero Hoodie page

    Scenario Outline: Adding multiple items to the cart within the allowed range
      When 'Green' is selected
      And size 'S' is selected
      And quantity is set to '<quantity>'
      When add to cart is selected
      Then Cart should have '<total>' items
      Examples:
        | quantity | total |
        | 1        | 1     |
        | 5        | 5     |
        | 100      | 100   |


  Scenario: Adding multiple items to the cart outside the allowed range
      When 'Green' is selected
      And size 'S' is selected
      And quantity is set to '100000'
      When add to cart is selected
      Then Purchase limit error must be shown