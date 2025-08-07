@logout_about
Feature: User Navigation

  Background:
    Given User enters username and password and clicks on Login button
    Then User should be redirected to the Products page "Products"
    When User clicks on menu button

  @logout
  Scenario: User logs out successfully

    And User clicks on the Logout link
    Then User should be redirected to the Login Page "Swag Labs"

  @about
  Scenario: User access to the About page

    And User clicks on the About link
    Then User should be redirected to the About page "saucelabs.com"



