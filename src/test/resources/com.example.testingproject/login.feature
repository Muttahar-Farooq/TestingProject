Feature: YourLogo sign in page test

  Background:
    Given the home page is opened
    And Login Button is clicked

    Scenario: Incorrect Login
      Given the Username is filled with 'softwaretesting@unideb.hu'
      And the Password is filled with 'WrongPassword'
      When the Sign In button is clicked
      Then error message is shown

    Scenario: Correct Login
      Given the Username is filled with 'softwaretesting@unideb.hu'
      And the Password is filled with 'SoftwareTesting098'
      When the Sign In button is clicked
      Then My Account page is opened
