package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class InventoryStepDefs extends AbstractStepDefs {

  private static final String ITEM_IMAGE_LINK_PATTERN = "item_%s_img_link";

  private static final Map<String, By> BUTTON_ELEMENTS_BY_NAME = Map.of(
      "Sauce Labs Backpack", By.id("add-to-cart-sauce-labs-backpack"),
      "Sauce Labs Bike Light", By.id("add-to-cart-sauce-labs-bike-light"),
      "Sauce Labs Bolt T-Shirt", By.id("add-to-cart-sauce-labs-bolt-t-shirt"),
      "Sauce Labs Fleece Jacket", By.id("add-to-cart-sauce-labs-fleece-jacket"),
      "Sauce Labs Onesie", By.id("add-to-cart-sauce-labs-onesie"),
      "Test.allTheThings() T-Shirt (Red)", By.id("add-to-cart-test.allthethings()-t-shirt-(red)"),
      "Card Badge", By.className("shopping_cart_badge") // TODO move to common
  );

  private static final Map<String, String> ELEMENTS_BY_NAME = Map.of(
      "Sauce Labs Backpack", "sauce-labs-backpack",
      "Sauce Labs Bike Light", "sauce-labs-bike-light",
      "Sauce Labs Bolt T-Shirt", "sauce-labs-bolt-t-shirt",
      "Sauce Labs Fleece Jacket", "sauce-labs-fleece-jacket",
      "Sauce Labs Onesie", "sauce-labs-onesie",
      "Test.allTheThings() T-Shirt (Red)", "test.allthethings()-t-shirt-(red)"
  );

  private static final Map<String, By> ITEM_LABEL_LINK_IDS = Map.of(
      "Sauce Labs Backpack", By.cssSelector("#item_4_title_link > div:nth-child(1)"),
      "Sauce Labs Bike Light", By.cssSelector("#item_0_title_link > div:nth-child(1)"),
      "Sauce Labs Bolt T-Shirt", By.cssSelector("#item_1_title_link > div:nth-child(1)"),
      "Sauce Labs Fleece Jacket", By.cssSelector("#item_5_title_link > div:nth-child(1)"),
      "Sauce Labs Onesie", By.cssSelector("#item_2_title_link > div:nth-child(1)"),
      "Test.allTheThings() T-Shirt (Red)", By.cssSelector("#item_3_title_link > div:nth-child(1)")
  );

  private static final By itemImageBy = By.className("inventory_details_img");

  private static final By productSortSelect = By.className("product_sort_container");

  @Given("the {string} add button is clicked")
  public void clickAddButton(final String itemName) {
    homePage.clickElement(BUTTON_ELEMENTS_BY_NAME.get(itemName));
  }

  @Given("the {string} remove button is clicked")
  public void clickRemoveButton(final String itemName) {
    homePage.clickElement(By.id("remove-" + ELEMENTS_BY_NAME.get(itemName)));
  }

  @Given("the {string} label is clicked")
  public void clickItemLabel(final String itemName) {
    homePage.clickElement(ITEM_LABEL_LINK_IDS.get(itemName));
  }

  @Given("the item sorting by {string}")
  public void sortItems(final String sortingType) {
    homePage.setItemSorting(productSortSelect, sortingType);
  }

  @Then("the {string} should not be visible")
  public void isElementNotVisible(final String elementName) {
    Assertions.assertFalse(homePage.isElementPresent(BUTTON_ELEMENTS_BY_NAME.get(elementName)));
  }

  @Then("the item image is shown with {string} source")
  public void isItemImageValid(final String itemSrc) {
    Assertions.assertEquals(itemSrc, homePage.getItemImageSrc(itemImageBy));
  }

  @Then("the items are ordered {string}")
  public void areItemsOrderedAs(final String expectedOrder) {
    String expectedInventoryImageIds = Arrays.stream(expectedOrder.split(","))
      .map(String::trim)
      .map(item -> ITEM_IMAGE_LINK_PATTERN.formatted(item))
      .collect(Collectors.joining(", "));
    String inventoryImageLinks = homePage.listInventoryImageLinkIds();
    Assertions.assertEquals(expectedInventoryImageIds, inventoryImageLinks);
  }
}

