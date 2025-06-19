package hu.unideb.inf.zsdoma.saucedemo.cucumbertest;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractStepDefs {
  private static final int WAIT_TIME = 10;

  private static final WebDriver driver;

  protected static HomePage homePage;

  private static boolean headless = false;

  static {
    WebDriverManager.firefoxdriver().setup();

    String headlessProperty = System.getProperty("selenium.firefox.headless");
    if (Objects.nonNull(headlessProperty)) {
      headless = Boolean.parseBoolean(headlessProperty);
    }

    if (headless) {
      FirefoxOptions options = new FirefoxOptions();
      options.addArguments("--headless");
      driver = new FirefoxDriver(options);
    } else {
      driver = new FirefoxDriver();
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
    homePage = new HomePage(driver);
  }
}
