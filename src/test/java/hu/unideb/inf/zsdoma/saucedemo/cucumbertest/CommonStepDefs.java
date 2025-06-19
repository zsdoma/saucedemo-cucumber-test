package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepDefs extends AbstractStepDefs {

  private static final Map<String, String> PAGE_PATHS = Map.of(
      "Home", "/",
      "Checkout", "/checkout-step-one.html"
  );

  protected static final Map<String, By> INPUT_IDS_BY_NAME = Map.ofEntries(
      Map.entry("Username", By.id("user-name")),
      Map.entry("Password", By.id("password")),
      Map.entry("Login", By.id("login-button")),
      Map.entry("BurgerMenuIcon", By.id("react-burger-menu-btn")),
      Map.entry("Logout", By.id("logout_sidebar_link")),
      Map.entry("ResetAppState", By.id("reset_sidebar_link")),
      Map.entry("Add to Cart", By.id("add-to-cart")),
      Map.entry("Checkout", By.id("checkout")),
      Map.entry("Continue", By.id("continue")),
      Map.entry("Finish", By.id("finish")),
      Map.entry("First Name", By.id("first-name")),
      Map.entry("Last Name", By.id("last-name")),
      Map.entry("Postal Code", By.id("postal-code"))
  );

  @Given("go to {string} page")
  public void homepage(final String pageName) {
    homePage.openPage(PAGE_PATHS.get(pageName));
  }

  @Given("type {string} into {string} field")
  public void fillInputWithText(final String text, final String inputName) {
    homePage.fillInputWithText(INPUT_IDS_BY_NAME.get(inputName), text);
  }

  @Given("the {string} button is clicked")
  public void clickButton(final String buttonName) {
    homePage.clickElement(INPUT_IDS_BY_NAME.get(buttonName));
  }

  @Then("the {string} button is shown")
  public void isButtonPresent(final String buttonName) {
    Assertions.assertTrue(homePage.isElementPresent(INPUT_IDS_BY_NAME.get(buttonName)));
  }

  @AfterAll
  public static void closeBrowser() {
    homePage.closePage();
  }
}

