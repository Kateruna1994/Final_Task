package pages;

import blocks.PricesDropBlock;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PricesDropPage extends BasePage {

  private final By productContainer = By.xpath(
      "//div[@class='thumbnail-container reviews-loaded']");

  @Step("Get all product prices drop")
  public List<PricesDropBlock> getAllProductPricesDrop() {
    List<PricesDropBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      PricesDropBlock pricesDropBlock = new PricesDropBlock(container);
      products.add(pricesDropBlock);
    }
    return products;
  }

  @Step("Get price and regular price with all products")
  public List<PricesDropBlock> getPriceAdnRegularPriceWithAllProducts(
      List<PricesDropBlock> products) {
    List<PricesDropBlock> priceProducts = new ArrayList<>();
    for (PricesDropBlock product : products) {
      if (product.getPriceAsDouble() != null && product.getRegularPriceAsDouble() != null) {
        priceProducts.add(product);
      }
    }
    return priceProducts;
  }

  @Step("Get all products with correct price")
  public List<PricesDropBlock> getAllProductWithCorrectPrice(List<PricesDropBlock> products) {
    List<PricesDropBlock> priceProducts = new ArrayList<>();
    for (PricesDropBlock product : products) {
      double priceAllProducts = Double.parseDouble(
          String.format(Locale.ROOT, "%.2f",
              product.getRegularPriceAsDouble() - (product.getRegularPriceAsDouble()
                  * product.getDiscountAsDouble()) / 100));
      if (priceAllProducts == product.getPriceAsDouble()) {
        priceProducts.add(product);
      }
    }
    return priceProducts;
  }
}







