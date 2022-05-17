package blocks;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PricesDropBlock {


  private WebElement img;
  private WebElement nameAsWebElementProduct;
  private String nameAsStringProduct;
  private String price;
  private Double priceAsDouble;
  private String regularPrice;
  private Double regularPriceAsDouble;
  private String discount;
  private Double discountAsDouble;
  private WebElement addWishList;

  public PricesDropBlock(WebElement container) {

    try {
      this.img = container.findElement(By.xpath(".//img"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.nameAsWebElementProduct = container.findElement(By.xpath(".//h2/a"));
      this.nameAsStringProduct = nameAsWebElementProduct.getAttribute("innerText");
    } catch (NoSuchElementException e) {
      this.nameAsWebElementProduct = null;
      this.nameAsStringProduct = null;
    }

    try {
      this.price = container.findElement(By.xpath(".//span[@class='price']")).getText();
      this.priceAsDouble = Double.parseDouble(price.substring(1));
    } catch (NoSuchElementException e) {
      this.price = null;
      this.priceAsDouble = null;
    }

    try {
      this.regularPrice = container.findElement(By.xpath(".//span[@class='regular-price']"))
          .getText();
      this.regularPriceAsDouble = Double.parseDouble(regularPrice.substring(1));
    } catch (NoSuchElementException e) {
      this.regularPrice = null;
      this.regularPriceAsDouble = null;
    }

    try {
      this.discount = container.findElement(By.xpath(".//li[@class='product-flag discount']"))
          .getText();
      this.discountAsDouble = Double.parseDouble(discount.substring(1, discount.length()-1));
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
