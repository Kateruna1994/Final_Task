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
public class SearchResultBearBlock {

  private WebElement imgProducts;
  private WebElement nameAsWebElementProducts;
  private String nameAsStringProducts;
  private String priceProducts;
  private Double priceProductsAsDouble;
  private WebElement addWishList;

  public SearchResultBearBlock(WebElement container) {

    try {
      this.imgProducts = container.findElement(By.xpath(".//img"));
    } catch (NoSuchElementException e) {
      this.imgProducts = null;
    }

    try {
      this.nameAsWebElementProducts = container.findElement(By.xpath(".//h2/a"));
      this.nameAsStringProducts = nameAsWebElementProducts.getAttribute("innerText");
    } catch (NoSuchElementException e) {
      this.nameAsWebElementProducts = null;
      this.nameAsStringProducts = null;
    }

    try {
      this.priceProducts = container.findElement(By.xpath(".//span[@class='price']")).getText();
      this.priceProductsAsDouble = Double.parseDouble(priceProducts.substring(1));
    } catch (NoSuchElementException e) {
      this.priceProducts = null;
      this.priceProductsAsDouble = null;
    }

    try {
      this.addWishList = container.findElement(By.xpath(".//i[@class='material-icons']"));
    } catch (NoSuchElementException e) {
      this.addWishList = null;
    }
  }


}
