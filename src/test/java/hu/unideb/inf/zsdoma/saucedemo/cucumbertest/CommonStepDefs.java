package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepDefs extends AbstractStepDefs {

  protected static final Map<String, By> INPUT_IDS_BY_NAME = Map.of(
      "Username", By.id("user-name"),
      "Password", By.id("password"),
      "Login", By.id("login-button"),
      "BurgerMenuIcon", By.id("react-burger-menu-btn"),
      "Logout", By.id("logout_sidebar_link"),
      "ResetAppState", By.id("reset_sidebar_link")
  );


  @Given("the homepage is active")
  public void homepage() {
    homePage.openPage();
  }

  @Given("type {string} into {string} field")
  public void fillInputWithText(final String text, final String inputName) {
    homePage.fillInputWithText(INPUT_IDS_BY_NAME.get(inputName), text);
  }

  @Given("the {string} button clicked")
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

