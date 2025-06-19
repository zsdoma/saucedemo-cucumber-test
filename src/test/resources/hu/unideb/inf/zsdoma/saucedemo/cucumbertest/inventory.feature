Feature: Inventory

  Background:
    Given go to 'Home' page
    And type 'standard_user' into 'Username' field
    And type 'secret_sauce' into 'Password' field
    And the 'Login' button is clicked

    Scenario: Reset app state
      Given the 'Sauce Labs Backpack' add button is clicked 
      And the 'Sauce Labs Bike Light' add button is clicked 
      And the 'BurgerMenuIcon' button is clicked
      And the 'ResetAppState' button is clicked
      Then the 'Card Badge' should not be visible

    Scenario Outline: Check item images
      Given the '<item>' label is clicked
      Then the item image is shown with '<item_image_src>' source
      Examples:
	| item			            | item_image_src |
	| Sauce Labs Backpack               | /static/media/sauce-backpack-1200x1500.0a0b85a3.jpg |
	| Sauce Labs Bike Light             | /static/media/bike-light-1200x1500.37c843b0.jpg 	  |
	| Sauce Labs Bolt T-Shirt           | /static/media/bolt-shirt-1200x1500.c2599ac5.jpg 	  |
	| Sauce Labs Fleece Jacket          | /static/media/sauce-pullover-1200x1500.51d7ffaf.jpg |
	| Sauce Labs Onesie                 | /static/media/red-onesie-1200x1500.2ec615b2.jpg 	  |
	| Test.allTheThings() T-Shirt (Red) | /static/media/red-tatt-1200x1500.30dadef4.jpg 	  |

    Scenario Outline: Items reordered
      Given the item sorting by '<selected_sort_option>' 
      Then the items are ordered '<ordered_item_numbers>' 
      Examples:
	| selected_sort_option | ordered_item_numbers |
        | Name (A to Z)        | 4,0,1,5,2,3          |
        | Name (Z to A)        | 3,2,5,1,0,4          |
        | Price (low to high)  | 2,0,1,3,4,5          |
        | Price (high to low)  | 5,4,1,3,0,2          |


