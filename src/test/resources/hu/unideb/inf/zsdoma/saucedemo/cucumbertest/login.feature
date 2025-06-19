Feature: Login

  Background:
    Given go to 'Home' page

    Scenario: Login and logout
      Given type 'standard_user' into 'Username' field 
      And type 'secret_sauce' into 'Password' field 
      And the 'Login' button is clicked
      And the 'BurgerMenuIcon' button is clicked
      And the 'Logout' button is clicked
      Then the 'Login' button is shown

    Scenario Outline: Login with wrong credentials
      Given type '<username>' into 'Username' field 
      And type '<password>' into 'Password' field 
      And the 'Login' button is clicked
      Then the '<error_message>' message is shown
      Examples:
        | username       | password       | error_message                                                             |
        |                |                | Epic sadface: Username is required                                        |
        | standard_user  |                | Epic sadface: Password is required                                        |
        | standard_user  | wrong_password | Epic sadface: Username and password do not match any user in this service |
        | locked_out_user| secret_sauce   | Epic sadface: Sorry, this user has been locked out.                       |
      
