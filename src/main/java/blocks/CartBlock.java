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
public class CartBlock {

  private String namePage;
  private String nameProduct;
  private String priceAsStringProduct;
  private Double priceAsDoubleProduct;
  private String paperType;
  private String quantity;
  private String subtotalPrice;
  private Double subtotalPriceAsDouble;
  private String totalPrice;
  private Double totalPriceAsDouble;

  public CartBlock(WebElement containers) {

    try {
      this.namePage = containers.findElement(By.xpath(".//h4")).getAttribute("innerText")
          .substring(1);
    } catch (NoSuchElementException e) {
      this.namePage = null;
    }

    try {
      this.nameProduct = containers.findElement(By.xpath(".//h6")).getAttribute("innerText");
    } catch (NoSuchElementException e) {
      this.nameProduct = null;
    }

    try {
      this.priceAsStringProduct = containers.findElement(By.xpath(".//p[@class='product-price']"))
          .getText();
      this.priceAsDoubleProduct = Double.parseDouble(priceAsStringProduct.substring(1));
    } catch (NoSuchElementException e) {
      this.priceAsStringProduct = null;
      this.priceAsDoubleProduct = null;
    }

    try {
      this.paperType = containers.findElement(By.xpath(".//span[@class='paper type']/strong"))
          .getText().trim();
    } catch (NoSuchElementException e) {
      this.paperType = null;
    }

    try {
      this.quantity = containers.findElement(By.xpath(".//span[@class='product-quantity']/strong"))
          .getText();
    } catch (NoSuchElementException e) {
      this.quantity = null;
    }

    try {
      this.subtotalPrice = containers.findElement(By.xpath(".//span[@class='subtotal value']"))
          .getText();
      this.subtotalPriceAsDouble = Double.parseDouble(subtotalPrice.substring(1));
    } catch (NoSuchElementException e) {
      this.subtotalPrice = null;
      this.subtotalPriceAsDouble = null;
    }

    try {
      this.totalPrice = containers.findElement(By.xpath(".//span[@class='value']")).getText();
      this.totalPriceAsDouble = Double.parseDouble(totalPrice.substring(1));
    } catch (NoSuchElementException e) {
      this.totalPrice = null;
      this.totalPriceAsDouble = null;
    }
  }

}
