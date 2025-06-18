package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import java.util.Map;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

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

}

