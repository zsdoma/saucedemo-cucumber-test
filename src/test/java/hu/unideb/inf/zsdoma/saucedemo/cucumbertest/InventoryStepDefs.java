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

  private static final By itemImageBy = By.className("inventory_details_img");

  private static final By productSortSelect = By.className("product_sort_container");

  @Given("the {string} add button is clicked")
  public void clickAddButton(final String itemName) {
    homePage.clickElement(By.id("add-to-cart-" + CommonElements.INVENTORY_ITEM_CLASS_POSTFIXS.get(itemName)));
  }

  @Given("the {string} remove button is clicked")
  public void clickRemoveButton(final String itemName) {
    homePage.clickElement(By.id("remove-" + CommonElements.INVENTORY_ITEM_CLASS_POSTFIXS.get(itemName)));
  }

  @Given("the {string} label is clicked")
  public void clickItemLabel(final String itemName) {
    homePage.clickElement(By.cssSelector(CommonElements.INVENTORY_ITEM_IDS.get(itemName) + " > div:nth-child(1)"));
  }

  @Given("the item sorting by {string}")
  public void sortItems(final String sortingType) {
    homePage.setItemSorting(productSortSelect, sortingType);
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

