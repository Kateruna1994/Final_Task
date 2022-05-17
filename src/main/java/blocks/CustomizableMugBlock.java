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
public class CustomizableMugBlock {

  private String nameProduct;
  private String priceAsString;
  private Double priceAsDouble;
  private WebElement productCustomization;
  private WebElement saveCustomizationButton;
  private WebElement quantity;
  private WebElement addToCardButton;
  private WebElement addWishListButton;

  public CustomizableMugBlock(WebElement container) {

    try {
      this.nameProduct = container.findElement(By.xpath(".//h1")).getAttribute("innerText");
    } catch (NoSuchElementException e) {
      this.nameProduct = null;
    }

    try {
      this.priceAsString = container.findElement(By.xpath(".//span[@class='current-price-value']"))
          .getText();
      this.priceAsDouble = Double.parseDouble(priceAsString.substring(1));
    } catch (NoSuchElementException e) {
      this.priceAsString = null;
      this.priceAsDouble = null;
    }

    try {
      this.productCustomization = container.findElement(By.xpath(".//textarea"));
    } catch (NoSuchElementException e) {
      this.productCustomization = null;
    }

    try {
      this.saveCustomizationButton = container.findElement(
          By.xpath(".//button[@name='submitCustomizedData']"));
    } catch (NoSuchElementException e) {
      this.saveCustomizationButton = null;
    }

    try {
      this.quantity = container.findElement(By.xpath(".//input[@name='qty']"));
    } catch (NoSuchElementException e) {
      this.quantity = null;
    }

    try {
      this.addToCardButton = container.findElement(
          By.xpath(".//button[contains(@class,'add-to-cart')]"));
    } catch (NoSuchElementException e) {
      this.addToCardButton = null;
    }

    try {
      this.addWishListButton = container.findElement(By.xpath(".//i[@class='material-icons']"));
    } catch (NoSuchElementException e) {
      this.addToCardButton = null;
    }
  }
}
