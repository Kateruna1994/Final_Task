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
@EqualsAndHashCode
@ToString
public class PopularProductsBlock {


  private WebElement img;
  private WebElement nameAsWebElementProduct;
  private String nameAsStringProduct;
  private String price;
  private Double priceAsDouble;
  private String discount;
  private String regularPrice;
  private WebElement addWishList;

  public PopularProductsBlock(WebElement container) {

    try {
      this.img = container.findElement(By.xpath(".//img"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.nameAsWebElementProduct = container.findElement(By.xpath(".//h3/a"));
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
      this.discount = container.findElement(By.xpath(".//li[@class='product-flag discount']"))
          .getText();
    } catch (NoSuchElementException e) {
      this.discount = null;
    }

    try {
      this.regularPrice = container.findElement(By.xpath(".//span[@class='regular-price']"))
          .getText();
    } catch (NoSuchElementException e) {
      this.regularPrice = null;
    }

    try {
      this.addWishList = container.findElement(By.xpath(".//button[@class='wishlist-button-add']"));
    } catch (NoSuchElementException e) {
      this.addWishList = null;
    }

  }


}
