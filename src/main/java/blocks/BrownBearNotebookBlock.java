package blocks;

import javafx.beans.value.WeakChangeListener;
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
public class BrownBearNotebookBlock {

  private WebElement paperType;
  private WebElement quantity;
  private WebElement addToCard;
  private String nameProduct;
  private String priceAsString;
  private Double priceAsDouble;

  public BrownBearNotebookBlock(WebElement containers) {

    try {
      this.paperType = containers.findElement(By.xpath(".//select[@id='group_4']"));
    } catch (NoSuchElementException e) {
      this.paperType = null;
    }

    try {
      this.quantity = containers.findElement(By.xpath(".//input[@name='qty']"));
    } catch (NoSuchElementException e) {
      this.quantity = null;
    }

    try {
      this.addToCard = containers.findElement(By.xpath(".//button[@type='submit']"));
    } catch (NoSuchElementException e) {
      this.addToCard = null;
    }

    try {
      this.nameProduct = containers.findElement(By.xpath(".//h1[@class='h1']"))
          .getAttribute("innerText");
    } catch (NoSuchElementException e) {
      this.nameProduct = null;
    }

    try {
      this.priceAsString = containers.findElement(By.xpath(".//span[@class='current-price-value']"))
          .getText();
      this.priceAsDouble = Double.parseDouble(priceAsString.substring(1));
    } catch (NoSuchElementException e) {
      this.priceAsString = null;
    }
  }

}
