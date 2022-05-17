package blocks;

import java.math.BigDecimal;
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
public class ShoppingCartBlock {

  private WebElement img;
  private WebElement productsName;
  private String productsAsStringName;
  private String productsQuantity;
  private Double productAsDoubleQuantity;
  private String productsAsStringPrice;
  private double productDoublePrice;
  private BigDecimal productsAsBigDecimalPrice;

  public ShoppingCartBlock(WebElement containers) {

    try {
      this.img = containers.findElement(By.xpath(".//img"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.productsName = containers.findElement(By.xpath(".//a[@class='label']"));
      this.productsAsStringName = productsName.getAttribute("innerText");
    } catch (NoSuchElementException e) {
      this.productsName = null;
      this.productsAsStringName = null;
    }

    try {
      this.productsQuantity = containers.findElement(
              By.xpath(".//input[contains(@class,'product-quantity form-control')]"))
          .getAttribute("valueAsNumber");
      this.productAsDoubleQuantity = Double.parseDouble(productsQuantity);
    } catch (NoSuchElementException e) {
      this.productsQuantity = null;
    }

    try {
      this.productsAsStringPrice = containers.findElement(
          By.xpath(".//span[@class='product-price']")).getText();
      this.productsAsBigDecimalPrice = new BigDecimal(productsAsStringPrice.substring(1));
    } catch (NoSuchElementException e) {
      this.productsAsStringPrice = null;
    }

  }
}
