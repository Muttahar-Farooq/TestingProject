Feature: Testing Cart functionality

  Background:
    Given the home page is opened

    Scenario: Cart is initially empty
      When cart icon is clicked
      Then empty cart message is displayed

    Scenario: Adding One item to the cart
      Given item Radiant Tee is selected
      And size XS is selected
      And color Orange is selected
      When add to cart of selected item is clicked
      Then added to cart message is displayed


