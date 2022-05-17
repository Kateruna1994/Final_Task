package pages;

import blocks.OrderBlock;
import io.qameta.allure.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {

  private final By checkTitlePage = By.xpath("//div[@class='col-md-12']/h3");
  private final By productContainer = By.xpath("//div[contains(@class, 'order-line row')]");
  private final By getShippingAngHandlingPrice = By.xpath(
      "//div[@id='order-items']/div[2]/table/tbody/tr[2]/td[2]");
  private final By totalPriceProducts = By.xpath(
      "//div[@id='order-items']/div[2]/table/tbody/tr[3]/td[2]");

  @Step("Check title page your order is confirmed")
  public String checkTitlePageYourOrderIsConfirmed() {
    return getDriver().findElement(checkTitlePage).getAttribute("innerText").substring(1);
  }

  @Step("Get sum total product price")
  public BigDecimal getSumTotalProductsPrice() {
    List<OrderBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      OrderBlock orderBlock = new OrderBlock(container);
      products.add(orderBlock);
    }
    String priceShippingAndHandlingAsString = getDriver().findElement(getShippingAngHandlingPrice)
        .getText().substring(1);
    BigDecimal priceFirstProduct = BigDecimal.valueOf(products.get(0).getTotalPriceAsDouble());
    BigDecimal priceSecondProduct = BigDecimal.valueOf(products.get(1).getTotalPriceAsDouble());
    BigDecimal add = priceFirstProduct.add(priceSecondProduct);
    return add.add(BigDecimal.valueOf(Double.parseDouble(priceShippingAndHandlingAsString)));
  }

  @Step("Get total price with products")
  public double getTotalPriceWithProducts() {
    String getTotalPriceAsString = getDriver().findElement(totalPriceProducts).getText()
        .substring(1);
    return Double.parseDouble(getTotalPriceAsString);
  }
}
