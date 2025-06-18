package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import io.cucumber.java.en.Then;

public class LoginStepDefs extends AbstractStepDefs {

  // @FindBy(css = ".error-message-container > h3:nth-child(1)")
  // private WebElement errorMessageElement;

  @Then("the {string} message is shown")
  public void isMessagePresent(final String message) {
    By errorMessageElement = By.cssSelector(".error-message-container > h3:nth-child(1)");
    Assertions.assertEquals(message, homePage.getTextByElement(errorMessageElement));
  }

}

