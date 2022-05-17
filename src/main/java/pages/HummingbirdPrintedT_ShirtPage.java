package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HummingbirdPrintedT_ShirtPage extends BasePage {

  private final By clickOnColor = By.xpath("//input[@title='Black']");
  private final By clickAddToCartButton = By.xpath("//div[@class='add']/button");
  private final By clickProceedToCheckoutButton = By.xpath(
      "//div[@class='cart-content-btn']/a[contains(@class,'btn-primary')]");

  @Step("Click on black color button")
  public HummingbirdPrintedT_ShirtPage clickOnBlackColorButton() {
    getDriver().findElement(clickOnColor).click();
    return this;
  }

  @Step("Click on add to cart button")
  public HummingbirdPrintedT_ShirtPage clickOnAddToCartButton() {
    getDriver().findElement(clickAddToCartButton).click();
    return this;
  }

  @Step("Click on proceed to checkout button")
  public CartPage clickOnProceedToCheckoutButton() {
    waitUtilVisible(clickProceedToCheckoutButton, 10);
    getDriver().findElement(clickProceedToCheckoutButton).click();
    return new CartPage();
  }
}
