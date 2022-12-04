Feature: Testing Cart functionality

  Background:
    Given the home page is opened

    Scenario: Cart is initially empty
      When cart icon is clicked
      Then empty cart message is displayed

    Scenario: Message shown on adding an item to the cart
      Given item Radiant Tee is selected
      And size XS is selected
      And color Orange is selected
      When add to cart of selected item is clicked
      Then added to cart message is displayed

    Scenario: Added item is available in the cart
      Given item Radiant Tee is selected
      And size XS is selected
      And color Orange is selected
      When add to cart of selected item is clicked
      And cart icon is clicked
      Then Radian Tee item is shown in cart
      And the item can be checked out

    Scenario: Remove all items from cart
      Given item Radiant Tee is added to cart
      When remove item button is clicked
      And OK option is selected in confirmation prompt
      Then empty cart message is displayed


