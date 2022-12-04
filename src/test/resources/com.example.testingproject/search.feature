Feature: Search functionality

  Background:
    Given the home page is opened

    Scenario Outline: Search for an item present in inventory
      Given search bar is clicked
      And item name "<item-name>" is typed
      When enter button is pressed
      Then search page is opened
      And item "<item-name>" should be present in search result
      Examples:
        | item-name         |  |
        | Breathe-Easy Tank |  |
        | Fusion Backpack   |  |
        | Radiant Tee       |  |
        | Joust Duffle Bag  |  |

  Scenario: Search for an item NOT present in inventory
      Given search bar is clicked
      And item name "iPhone 14 Pro Max" is typed
      When enter button is pressed
      Then search page is opened
      And item "iPhone 14 Pro Max" should be NOT be present in ANY search result