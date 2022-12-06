Feature: Checkout functionality
  Background:
    When the user is on Hero Hoodie page
    And size 'S' is selected
    And 'Green' is selected
    And quantity is set to '1'
    And add to cart is selected
    And cart icon is clicked on Hero Hoodie page
    And proceed to cart is clicked

    Scenario:
      Given email is filled with 'testing@example.com'
      Given first name is filled with 'Software'
      And last name is filled with 'Testing'
      And address is filled with 'Test Address'
      And city is filled with 'Test City'
      And zip code is filled with '1234'
      And country is selected as 'Afghanistan'
      And phone number is filled with '123456789'
      When next button is clicked
      And place order button is clicked
      Then Thank message is shown