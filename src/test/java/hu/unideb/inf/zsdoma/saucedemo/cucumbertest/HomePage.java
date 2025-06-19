package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

  public static final String PAGE_URL = "https://www.saucedemo.com";

  private final WebDriver driver;

  public HomePage(final WebDriver driver) {
    this.driver = driver;
  }

  public void openPage(final String pagePath) {
    driver.get(PAGE_URL + pagePath);
    PageFactory.initElements(driver, this);
  }

  public void closePage() {
    driver.quit();
  }

  public void fillInputWithText(final By input, final String text) {
    driver.findElement(input).sendKeys(text);
  }
 
  public void clickElement(final By element) {
    driver.findElement(element).click();
  }

  public void setItemSorting(final By selectElement, final String sortingType) {
    WebElement sortingDropdown = driver.findElement(selectElement);
    Select sortingSelect = new Select(sortingDropdown);
    sortingSelect.selectByVisibleText(sortingType);
  }
  public boolean isElementPresent(final By element) {
    return !driver.findElements(element).isEmpty();
  }

  public String getItemImageSrc(By itemImageElement) {
    return driver.findElement(itemImageElement).getDomAttribute("src");
  }

  public String getTextByElement(final By element) {
    return driver.findElement(element).getText();
  }

  public String listInventoryImageLinkIds() {
    return driver.findElements(By.cssSelector("div.inventory_item > div.inventory_item_img a")).stream()
      .map(element -> element.getDomAttribute("id")).collect(Collectors.joining(", "));
  }
}

