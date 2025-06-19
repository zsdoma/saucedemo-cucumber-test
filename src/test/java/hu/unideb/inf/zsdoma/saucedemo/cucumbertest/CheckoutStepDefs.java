package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CheckoutStepDefs extends AbstractStepDefs {

  private static final Map<String, By> ICONS_BY_ID = Map.of(
    "Cart", By.id("shopping_cart_container")
  );

  private static final Map<String, By> LABELS_BY_CLASS = Map.of(
    "Thank you for your order!", By.className("complete-header")
  );

  @Given("the {string} icon is clicked")
  public void iconClicked(final String iconName) {
    homePage.clickElement(ICONS_BY_ID.get(iconName));
  }

  @Given("the {string} label is visible")
  public void labelVisible(final String labelName) {
    homePage.isElementPresent(LABELS_BY_CLASS.get(labelName));
  }

  @Given("the {string} cart item visible")
  public void cartItemVisible(final String itemName) {
    By cartItem = By.cssSelector("div.cart_item_label > " + CommonElements.INVENTORY_ITEM_IDS.get(itemName) +" > div.inventory_item_name");
    Assertions.assertTrue(homePage.isElementPresent(cartItem));
  }

  @Then("cart badge count is {int}")
  public void isTheCardCountValid(final int expectedCount) {
    By cardBadge = CommonElements.COMMON_ELEMENTS_BY_NAME.get("Card Badge");
    Assertions.assertTrue(homePage.isElementPresent(cardBadge));
    int cartCount = Integer.parseInt(homePage.getTextByElement(cardBadge));
    Assertions.assertEquals(expectedCount, cartCount);
  }

}

