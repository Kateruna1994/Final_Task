package storeTests;

import core.EventDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTest {

  @BeforeMethod
  public synchronized void setUp() {
    WebDriver driver;

    String browser = System.getProperty("browser");
    int browserHeight = Integer.parseInt(System.getProperty("browserWidth"));
    int browserWidth = Integer.parseInt(System.getProperty("browserHeight"));

    switch (browser) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-site-isolation-trials");
        driver = new ChromeDriver(chromeOptions);
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
      default:
        throw new IllegalStateException("Unexpected value " + browser);

    }

    WebDriverListener listener = new EventDriver();
    WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);
    BasePage.setDriverThreadLocal(decorated);
    BasePage.getDriver().manage().window().setSize(new Dimension(browserWidth, browserHeight));

  }

  @AfterMethod(alwaysRun = true)
  public void quite() {
    if (BasePage.getDriverThreadLocal() != null) {
      BasePage.getDriverThreadLocal().get().quit();
      BasePage.getDriverThreadLocal().remove();
    }
  }
}
