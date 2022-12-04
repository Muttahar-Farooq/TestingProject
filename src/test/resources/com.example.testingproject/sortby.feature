Feature: Sort by functionality

  Background:
    Given the home page is opened
    And search bar is clicked
    And item name "backpack" is typed
    And enter button is pressed
    And search page is opened

    Scenario:
      Given Sort By dropdown menu is clicked
      When Product Name option is selected
      Then sorting of searched results should be according to Product Name