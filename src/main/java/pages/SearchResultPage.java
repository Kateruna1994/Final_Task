package pages;

import blocks.SearchResultBearBlock;
import blocks.SearchResultMugBlock;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {

  private final By productContainerBear = By.xpath(
      "//div[@class='thumbnail-container reviews-loaded']");
  private final By productContainerMug = By.xpath("//div[contains(@class,'js-product product')]");
  private final By clickOnTShirt = By.xpath("//a[@class='thumbnail product-thumbnail']/img");

  @Step("Get all products with search result bear page")
  public List<SearchResultBearBlock> getAllProductsWithSearchResultBearPage() {
    waitUtilVisible(productContainerBear, 10);
    List<SearchResultBearBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainerBear);
    for (WebElement container : containers) {
      SearchResultBearBlock searchResultBlock = new SearchResultBearBlock(container);
      products.add(searchResultBlock);
    }
    return products;
  }

  @Step("Click on product with name from bear")
  public BrownBearNotebookPage clickOnProductWithNameFromBear(List<SearchResultBearBlock> products,
      String productName) {
    waitUtilVisible(productContainerBear, 10);
    SearchResultBearBlock brownBearNotebook = products.stream()
        .filter(p -> p.getNameAsStringProducts().equals(productName))
        .findFirst().get();
    brownBearNotebook.getImgProducts().click();
    return new BrownBearNotebookPage();
  }

  @Step("Get all products with search result mug page")
  public List<SearchResultMugBlock> getAllProductsWithSearchResultMugPage() {
    waitUtilVisible(productContainerMug, 10);
    List<SearchResultMugBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainerMug);
    for (WebElement container : containers) {
      SearchResultMugBlock searchResultMugBlock = new SearchResultMugBlock(container);
      products.add(searchResultMugBlock);
    }
    return products;
  }

  @Step("Click on product with name from mug")
  public CustomizableMugPage clickOnProductWithNameFromMug(List<SearchResultMugBlock> products,
      String productName) {
    waitUtilVisible(productContainerMug, 10);
    SearchResultMugBlock customizableMug = products.stream()
        .filter(p -> p.getNameProducts().equals(productName))
        .findFirst().get();
    customizableMug.getImg().click();
    return new CustomizableMugPage();
  }

  @Step("Click on hummingbird printed t-shirt product")
  public HummingbirdPrintedT_ShirtPage clickOnHummingbirdPrintedT_ShirtProduct() {
    getDriver().findElement(clickOnTShirt).click();
    return new HummingbirdPrintedT_ShirtPage();
  }
}
