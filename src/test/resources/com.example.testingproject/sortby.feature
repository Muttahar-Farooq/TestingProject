Feature: Sort by functionality

  Background:
    Given the home page is opened
    And search bar is clicked
    And item name "backpack" is typed
    And enter button is pressed
    And search page is opened

    Scenario: Sort by Product Name
      Given Sort By dropdown menu is clicked
      When Product Name option is selected
      Then sorting of searched results should be according to Product Name

    Scenario: Sort by Price
      Given Sort By dropdown menu is clicked
      When Price option is selected
      Then sorting of searched results should be according to Price

    Scenario:
      Given Sort By dropdown menu is clicked
      And Product Name option is selected
      When Order modifier button is pressed
      Then the order of items displayed is reversed