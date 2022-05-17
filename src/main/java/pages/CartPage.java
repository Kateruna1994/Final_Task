package pages;

import blocks.ShoppingCartBlock;
import io.qameta.allure.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

  private final By checkForTex = By.xpath(
      "//div[@id='blockcart-modal']//div[@class='modal-content']//h4");
  private final By checkForPaperTypeField = By.xpath("//span[@class='paper type']/strong");
  private final By checkForQuantity = By.xpath("//span[@class='product-quantity']/strong");
  private final By clickContinueShopping = By.xpath("//button[@class='btn btn-secondary']");
  private final By productContainer = By.xpath("//div[@class='product-line-grid']");
  private final By clickProceedToCheckout = By.xpath("//a[@class='btn btn-primary']");

  @Step("Check new window with title")
  public String checkNewWindowWithTitle() {
    waitUtilVisible(checkForTex, 10);
    return getDriver().findElement(checkForTex).getAttribute("outerText").substring(1);
  }

  @Step("Check correct paper type field")
  public String checkCorrectPaperTypeField() {
    return getDriver().findElement(checkForPaperTypeField).getText().trim();
  }

  @Step("Check quantity field")
  public String checkQuantityField() {
    return getDriver().findElement(checkForQuantity).getText();
  }

  @Step("Get price product")
  public double getPriceProduct() {
    String getQuantityAsString = getDriver().findElement(checkForQuantity)
        .getAttribute("innerText");
    double getQuantityProductAsDouble = Double.parseDouble(getQuantityAsString);
    String productPrice = getDriver().findElement(By.xpath("//p[@class='product-price']")).getText()
        .substring(1);
    double getProductPriceAsDouble = Double.parseDouble(productPrice);
    return (getQuantityProductAsDouble * getProductPriceAsDouble);
  }

  @Step("Click on continue shopping button")
  public CartPage clickOnContinueShoppingButton() {
    waitUtilVisible(clickContinueShopping, 10);
    getDriver().findElement(clickContinueShopping).click();
    return this;
  }

  @Step("Get price")
  public BigDecimal getTotalPriceCustomizableMugAndT_Shirt() {
    List<ShoppingCartBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      ShoppingCartBlock shoppingCartBlock = new ShoppingCartBlock(container);
      products.add(shoppingCartBlock);
    }
    BigDecimal firstPrice = products.get(0).getProductsAsBigDecimalPrice();
    BigDecimal secondPrice = products.get(1).getProductsAsBigDecimalPrice();
    BigDecimal sum = firstPrice.add(secondPrice);
    return sum;

  }

  @Step("Click on proceed to checkout button")
  public PersonalInformationPage clickOnProceedToCheckoutButton() {
    waitUtilVisible(clickProceedToCheckout, 10);
    getDriver().findElement(clickProceedToCheckout).click();
    return new PersonalInformationPage();
  }
}
