package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import java.util.Map;

import org.openqa.selenium.By;

public final class CommonElements {

  public static final Map<String, String> INVENTORY_ITEM_IDS = Map.of(
    "Sauce Labs Backpack", "#item_4_title_link",
    "Sauce Labs Bike Light", "#item_0_title_link",
    "Sauce Labs Bolt T-Shirt", "#item_1_title_link",
    "Sauce Labs Fleece Jacket", "#item_5_title_link",
    "Sauce Labs Onesie", "#item_2_title_link",
    "Test.allTheThings() T-Shirt (Red)", "#item_3_title_link"
  );

  public static final Map<String, String> INVENTORY_ITEM_CLASS_POSTFIXS = Map.of(
    "Sauce Labs Backpack", "sauce-labs-backpack",
    "Sauce Labs Bike Light", "sauce-labs-bike-light",
    "Sauce Labs Bolt T-Shirt", "sauce-labs-bolt-t-shirt",
    "Sauce Labs Fleece Jacket", "sauce-labs-fleece-jacket",
    "Sauce Labs Onesie", "sauce-labs-onesie",
    "Test.allTheThings() T-Shirt (Red)", "test.allthethings()-t-shirt-(red)"
  );

  public static final Map<String, By> COMMON_ELEMENTS_BY_NAME = Map.of(
    "Card Badge", By.className("shopping_cart_badge")
  );

  private CommonElements() {
    // do nothing
  }

}

