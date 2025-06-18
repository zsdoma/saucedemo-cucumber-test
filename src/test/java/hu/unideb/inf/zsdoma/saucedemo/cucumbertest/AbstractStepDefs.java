package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractStepDefs {
  private static final int WAIT_TIME = 10;

  private static final WebDriver driver;

  protected static HomePage homePage;

  static {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
    homePage = new HomePage(driver);
  }
}
