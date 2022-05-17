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
public class SearchResultMugBlock {

  private WebElement img;
  private String nameProducts;
  private String priceProductsAsString;
  private Double priceProductsAsDouble;
  private WebElement addWishList;

  public SearchResultMugBlock(WebElement container) {

    try {
      this.img = container.findElement(By.xpath(".//img"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.nameProducts = container.findElement(By.xpath(".//h2/a")).getAttribute("innerText");
    } catch (NoSuchElementException e) {
      this.nameProducts = null;
    }

    try {
      this.priceProductsAsString = container.findElement(By.xpath(".//span[@class='price']"))
          .getText();
      this.priceProductsAsDouble = Double.parseDouble(priceProductsAsString.substring(1));
    } catch (NoSuchElementException e) {
      this.priceProductsAsString = null;
      this.priceProductsAsDouble = null;
    }

    try {
      this.addWishList = container.findElement(By.xpath("//i[@class='material-icons']"));
    } catch (NoSuchElementException e) {
      this.addWishList = null;
    }
  }

}
