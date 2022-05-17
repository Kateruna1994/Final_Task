package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CustomizableMugPage extends BasePage {

  private final By enterProductCustomization = By.xpath("//textarea");
  private final By clickSaveCustomization = By.xpath("//button[@name='submitCustomizedData']");
  private final By clickAddToCart = By.xpath("//button[contains(@class,'add-to-cart')]");


  @Step("Click and end Enter product customization {name}")
  public CustomizableMugPage clickAndEndEnterProductCustomization(String name) {
    getDriver().findElement(enterProductCustomization).sendKeys(name);
    return this;
  }

  @Step("Click on save customization button")
  public CustomizableMugPage clickOnSaveCustomizationButton() {
    scrollToElement(getDriver(), clickSaveCustomization);
    getDriver().findElement(clickSaveCustomization).click();
    return this;
  }

  @Step("Click on add to cart button")
  public CartPage clickOnAddToCartButton() {
    getDriver().findElement(clickAddToCart).click();
    return new CartPage();
  }
}
