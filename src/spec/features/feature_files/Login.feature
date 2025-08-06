@login
Feature: User Login

  Background:
    Given User connect on saucedemo site

  @positive_login
  Scenario: Login with valid credentials

    When User enters username as "standard_user" and password as "secret_sauce" and clicks on Login button
    Then User should be redirected to the Products page "Products"

  @negative_login
  Scenario: Login with invalid credentials

    When User enters username as "admin" and password as "wael$123" and clicks on Login button
    Then An error message should be displayed "Epic sadface: Username and password do not match any user in this service"