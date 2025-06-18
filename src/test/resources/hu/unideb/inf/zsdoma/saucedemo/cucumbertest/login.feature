Feature: Login

  Background:
    Given the homepage is active

    Scenario: Login and logout
      Given type 'standard_user' into 'Username' field 
      And type 'secret_sauce' into 'Password' field 
      And the 'Login' button clicked
      And the 'BurgerMenuIcon' button clicked
      And the 'Logout' button clicked
      Then the 'Login' button is shown

    Scenario Outline: Login with wrong credentials
      Given type '<username>' into 'Username' field 
      And type '<password>' into 'Password' field 
      And the 'Login' button clicked
      Then the '<error_message>' message is shown
      Examples:
        | username       | password       | error_message                       |
        |                |                | Epic sadface: Username is required |
        | standard_user  |                | Epic sadface: Password is required |
        | standard_user  | wrong_password | Epic sadface: Username and password do not match any user in this service |
        | locked_out_user| secret_sauce   | Epic sadface: Sorry, this user has been locked out. |
      
