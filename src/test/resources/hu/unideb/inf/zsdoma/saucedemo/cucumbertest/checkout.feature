Feature: Checkout

  Background:
    Given the homepage is active
    And type 'standard_user' into 'Username' field
    And type 'secret_sauce' into 'Password' field
    And the 'Login' button is clicked

    Scenario: Buy an item
      Given the 'Sauce Labs Backpack' label is clicked
      And the 'Add to Cart' button is clicked
      And the 'Cart' icon is clicked
      And the 'Checkout' button is clicked
      And type 'Elek' into 'First Name' field
      And type 'Teszt' into 'Last Name' field
      And type '1234' into 'Postal Code' field
      And the 'Continue' button is clicked
      And the 'Finish' button is clicked
      Then the 'Thank you for your order!' label is visible

    Scenario Outline: Try to buy with missing checkout data
      Given the 'BurgerMenuIcon' button is clicked
      And the 'ResetAppState' button is clicked
      And the 'Sauce Labs Backpack' label is clicked
      And the 'Add to Cart' button is clicked
      And the 'Cart' icon is clicked
      And the 'Checkout' button is clicked
      And type '<first_name>' into 'First Name' field
      And type '<last_name>' into 'Last Name' field
      And type '<postal_code>' into 'Postal Code' field
      And the 'Continue' button is clicked
      Then the '<error_message>' message is shown
      Examples:
	| first_name | last_name | postal_code | error_message                  |
	|	     |           |             | Error: First Name is required  |
	| Elek       |           | 1234        | Error: Last Name is required   |
	|            | Teszt     | 1234        | Error: First Name is required  |
	| Elek       | Teszt     |             | Error: Postal Code is required |
