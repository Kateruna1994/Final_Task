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
public class OrderBlock {

  private WebElement img;
  private String productName;
  private String unitPriceAsString;
  private Double unitPriceAsDouble;
  private String totalPriceAsString;
  private Double totalPriceAsDouble;


  public OrderBlock(WebElement container) {
    try {
      this.img = container.findElement(By.xpath(".//img"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.productName = container.findElement(
          By.xpath(".//div[@class='col-sm-4 col-xs-9 details']/span")).getAttribute("innerText");
    } catch (NoSuchElementException e) {
      this.productName = null;
    }

    try {
      this.unitPriceAsString = container.findElement(
          By.xpath(".//div[@class='row']/div[contains(@class,'text-xs-left')]")).getText();
      this.unitPriceAsDouble = Double.parseDouble(unitPriceAsString.substring(1));
    } catch (NoSuchElementException e) {
      this.unitPriceAsString = null;
      this.unitPriceAsDouble = null;
    }

    try {
      this.totalPriceAsString = container.findElement(
          By.xpath(".//div[@class='row']/div[contains(@class,'text-xs-right bold')]")).getText();
      this.totalPriceAsDouble = Double.parseDouble(totalPriceAsString.substring(1));
    } catch (NoSuchElementException e) {
      this.totalPriceAsString = null;
      this.totalPriceAsDouble = null;
    }
  }

}
