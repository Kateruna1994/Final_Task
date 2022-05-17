package pages;

import blocks.BrownBearNotebookBlock;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrownBearNotebookPage extends BasePage {

  private final By productContainer = By.xpath(
      "//div[contains(@class,'js-product-container')]//div[@class='product-information']/..");
  private final By clickOnPaperTypeButton = By.xpath("//select[@id='group_4']");
  private final By clickOnTheQuantityButton = By.xpath("//input[@name='qty']");


  public List<BrownBearNotebookBlock> getProductInfoFromBrownBearNotebook() {
    List<BrownBearNotebookBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      BrownBearNotebookBlock brownBearNotebookBlock = new BrownBearNotebookBlock(container);
      products.add(brownBearNotebookBlock);
    }
    return products;
  }

  @Step("Click on paper type button")
  public BrownBearNotebookPage clickOnPaperTypeButton() {
    List<BrownBearNotebookBlock> productBrownBearNotebookBlock = getProductInfoFromBrownBearNotebook();
    for (BrownBearNotebookBlock product : productBrownBearNotebookBlock) {
      product.getPaperType().click();
    }
    return this;
  }

  public BrownBearNotebookPage getDotedButton() {
    Select select = new Select(getDriver().findElement(clickOnPaperTypeButton));
    select.selectByVisibleText("Doted");
    return this;
  }

  @Step("Click on quantity button")
  public BrownBearNotebookPage clickOnQuantityButton() {
    List<BrownBearNotebookBlock> productBrownBearNotebookBlock = getProductInfoFromBrownBearNotebook();
    for (BrownBearNotebookBlock product : productBrownBearNotebookBlock) {
      product.getQuantity().click();
    }
    return this;
  }

  @Step("Change quantity button {number}")
  public BrownBearNotebookPage changeQuantityButton(String number) {
    waitUtilVisible(clickOnTheQuantityButton, 10);
    pressTheBackspaceKeyOnKeyboard(clickOnTheQuantityButton);
    getDriver().findElement(clickOnTheQuantityButton).sendKeys(number);
    return this;
  }

  @Step("Click add to card button")
  public CartPage clickAddToCardButton() {
    List<BrownBearNotebookBlock> productBrownBearNotebookBlock = getProductInfoFromBrownBearNotebook();
    for (BrownBearNotebookBlock product : productBrownBearNotebookBlock) {
      product.getAddToCard().click();
    }
    return new CartPage();
  }
}


