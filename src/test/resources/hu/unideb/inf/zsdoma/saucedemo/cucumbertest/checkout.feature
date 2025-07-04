Feature: Checkout

  Background:
    Given go to 'Home' page
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
      # TODO check data
      And the 'Finish' button is clicked
      Then the 'Thank you for your order!' label is visible

    Scenario: Choose two items and empty the cart
      Given the 'Sauce Labs Backpack' label is clicked
      And the 'Add to Cart' button is clicked
      And the 'Cart' icon is clicked
      Then the 'Sauce Labs Backpack' cart item visible
      Then cart badge count is 1
      And the 'Continue Shopping' button is clicked
      And the 'Sauce Labs Onesie' label is clicked
      And the 'Add to Cart' button is clicked
      And the 'Cart' icon is clicked
      Then the 'Sauce Labs Backpack' cart item visible
      Then the 'Sauce Labs Onesie' cart item visible
      Then cart badge count is 2
      And the 'Sauce Labs Backpack' remove button is clicked
      And the 'Sauce Labs Onesie' remove button is clicked
      Then the 'Card Badge' should not be visible

    Scenario Outline: Try to buy with missing checkout data
      Given go to 'Checkout' page
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
