package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

  private static final String PAGE_URL = "https://www.saucedemo.com/";

  private final WebDriver driver;

  public HomePage(final WebDriver driver) {
    this.driver = driver;
  }

  public void openPage() {
    driver.get(PAGE_URL);
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

  public boolean isElementPresent(final By element) {
    return !driver.findElements(element).isEmpty();
  }

  // TODO delete if not needed
  @Deprecated
  public String getTextByElement(final WebElement element) {
    return element.getText();
  }

  public String getTextByElement(final By element) {
    return driver.findElement(element).getText();
  }

}

