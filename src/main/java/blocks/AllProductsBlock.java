package blocks;

import java.time.Duration;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AllProductsBlock {

  private WebElement imgProduct;
  private String productsAsStringName;
  private WebElement productsAsWebElementName;
  private String priceAsString;
  private Double priceAsDouble;
  private String regularPriceAsString;
  private Double regularPriceAsDouble;
  private String discount;
  private WebElement addWishList;

  public AllProductsBlock(WebElement container) {

    try {
      this.imgProduct = container.findElement(By.xpath(".//img"));
    } catch (NoSuchElementException e) {
      this.imgProduct = null;
    }

    try {
      this.productsAsWebElementName = container.findElement(By.xpath(".//h2/a"));
      this.productsAsStringName = productsAsWebElementName.getAttribute("innerText");
    } catch (NoSuchElementException e) {
      this.productsAsWebElementName = null;
      this.productsAsStringName = null;
    }

    try {
      this.priceAsString = container.findElement(By.xpath(".//span[@class='price']")).getText();
      this.priceAsDouble = Double.parseDouble(priceAsString.substring(1));
    } catch (NoSuchElementException e) {
      this.priceAsString = null;
      this.priceAsDouble = null;
    }

    try {
      this.regularPriceAsString = container.findElement(By.xpath(".//span[@class='regular-price']"))
          .getText();
      this.regularPriceAsDouble = Double.parseDouble(regularPriceAsString.substring(1));
    } catch (NoSuchElementException e) {
      this.regularPriceAsString = null;
      this.regularPriceAsDouble = null;
    }

    try {
      this.discount = container.findElement(By.xpath(".//li[@class='product-flag discount']"))
          .getText();
    } catch (NoSuchElementException e) {
      this.discount = null;
    }

    try {
      this.addWishList = container.findElement(By.xpath(".//i[@class='material-icons']"));
    } catch (NoSuchElementException e) {
      this.addWishList = null;
    }
  }

}
