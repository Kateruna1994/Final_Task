package pages;

import blocks.HeaderMenuBlock;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

  public static void setDriverThreadLocal(WebDriver driver) {
    DRIVER_THREAD_LOCAL.set(driver);
  }

  public static ThreadLocal<WebDriver> getDriverThreadLocal(){
    return DRIVER_THREAD_LOCAL;
  }

  public static WebDriver getDriver() {
    return DRIVER_THREAD_LOCAL.get();
  }

  public static WebElement waitUtilVisible(By locator, int second) {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(second))
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static void scrollToElement(WebDriver driver, By element) {
    WebElement webElement = driver.findElement(element);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
  }

  public void switchToFrame() {
    getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe")));
  }

  public static void hoverMouseOverElementWithLocator(By locator) {
    WebElement element = getDriver().findElement(locator);
    Actions actions = new Actions(getDriver());
    actions.moveToElement(element).build().perform();
  }

  public void pressEnterOnTheKeyboard(By locator) {
    WebElement element = getDriver().findElement(locator);
    Actions actions = new Actions(getDriver());
    actions.moveToElement(element).sendKeys(Keys.ENTER).build().perform();
  }

  public void pressTheBackspaceKeyOnKeyboard(By locator) {
    WebElement element = getDriver().findElement(locator);
    Actions actions = new Actions(getDriver());
    actions.moveToElement(element).sendKeys(Keys.BACK_SPACE).build().perform();
  }

  public static Boolean waitRefreshed(By locator, int second) {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(second))
        .until(ExpectedConditions.refreshed(
            ExpectedConditions.stalenessOf(getDriver().findElement(locator))));
  }


  private HeaderMenuBlock headerMenuBlock = new HeaderMenuBlock(getDriver());

  public HeaderMenuBlock getHeaderMenuBlock() {
    return headerMenuBlock;
  }
}
