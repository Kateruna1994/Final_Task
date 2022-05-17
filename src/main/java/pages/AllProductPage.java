package pages;

import blocks.AllProductsBlock;
import io.qameta.allure.Step;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllProductPage extends BasePage {

  private final By clickOnSortByButton = By.xpath("//button[@class='btn-unstyle select-title']");
  private final By clickNameA_To_Z_Field = By.xpath(
      "//div[@class='dropdown-menu']/a[contains(@href,'product.name.asc')]");
  private final By productContainer = By.xpath(
      "//div[@class='thumbnail-container reviews-loaded']");
  private final By clickNameZ_To_A_Field = By.xpath(
      "//div[@class='dropdown-menu']/a[contains(@href,'product.name.desc')]");
  private final By clickPriceLow_To_High = By.xpath(
      "//div[@class='dropdown-menu']/a[contains(@href,'product.price.asc')]");
  private final By clickPriceHigh_To_Low = By.xpath(
      "//div[@class='dropdown-menu']/a[contains(@href,'product.price.desc')]");

  @Step("Click on the sort button")
  public AllProductPage clickOnTheSortByButton() {
    scrollToElement(getDriver(), clickOnSortByButton);
    getDriver().findElement(clickOnSortByButton).click();
    return this;
  }

  @Step("Click sort by name a to z field")
  public AllProductPage clickSortByName_A_To_Z_Field() {
    scrollToElement(getDriver(), clickNameA_To_Z_Field);
    getDriver().findElement(clickNameA_To_Z_Field).click();
    waitRefreshed(productContainer, 10);
    return this;
  }

  @Step("Get all product")
  public List<AllProductsBlock> getAllProduct() {
    List<AllProductsBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      AllProductsBlock allProductsBlock = new AllProductsBlock(container);
      products.add(allProductsBlock);
    }
    return products;
  }

  @Step("Get name before sorting with a to z")
  public List<String> getNameBeforeSortingWith_A_To_Z() {
    List<AllProductsBlock> products = getAllProduct();
    List<String> productName = new ArrayList<>();
    for (AllProductsBlock product : products) {
      productName.add(product.getProductsAsStringName());
    }
    return productName;
  }

  @Step("Get name after sorting with a to z")
  public List<String> getNameAfterSortingWith_A_To_Z() {
    List<AllProductsBlock> products = getAllProduct();
    List<String> productsName = new ArrayList<>();
    for (AllProductsBlock product : products) {
      productsName.add(product.getProductsAsStringName());
    }
    Collections.sort(productsName);
    return productsName;
  }

  @Step("Click sort be name z to a field")
  public AllProductPage clickSortByName_Z_To_A_Field() {
    getDriver().findElement(clickNameZ_To_A_Field).click();
    scrollToElement(getDriver(), productContainer);
    waitRefreshed(productContainer, 10);
    return this;
  }

  @Step("Get name before sorting with z to a")
  public List<String> getNameBeforeSortingWith_Z_To_A() {
    List<AllProductsBlock> products = getAllProduct();
    List<String> productName = new ArrayList<>();
    for (AllProductsBlock product : products) {
      productName.add(product.getProductsAsStringName());
    }
    return productName;
  }

  @Step("Get name after sorting with z to a")
  public List<String> getNameAfterSortingWith_Z_To_A() {
    List<AllProductsBlock> products = getAllProduct();
    List<String> productsName = new ArrayList<>();
    for (AllProductsBlock product : products) {
      productsName.add(product.getProductsAsStringName());
    }
    Collections.sort(productsName);
    Collections.reverse(productsName);
    return productsName;
  }

  @Step("Click sort by price low to high")
  public AllProductPage clickSortByPrice_Low_To_High() {
    waitUtilVisible(clickPriceLow_To_High, 10);
    getDriver().findElement(clickPriceLow_To_High).click();
    scrollToElement(getDriver(), clickOnSortByButton);
    waitRefreshed(productContainer, 10);
    return this;
  }

  @Step("Get price before sorting low to high")
  public List<Double> getPriceBeforeSortingLowToHigh() {
    List<AllProductsBlock> products = getAllProduct();
    List<Double> productsPrice = new ArrayList<>();
    for (AllProductsBlock product : products) {
      productsPrice.add(product.getPriceAsDouble());
    }
    return productsPrice;
  }

  @Step("Get price after sorting low to high")
  public List<Double> getPriceAfterSortingLowToHigh() {
    List<AllProductsBlock> products = getAllProduct();
    List<Double> productsPrice = new ArrayList<>();
    for (AllProductsBlock product : products) {
      productsPrice.add(product.getPriceAsDouble());
    }
    Collections.sort(productsPrice);
    return productsPrice;
  }

  @Step("Click sort by price high to low")
  public AllProductPage clickSortByPrice_High_To_Low() {
    waitUtilVisible(clickPriceHigh_To_Low, 10);
    scrollToElement(getDriver(), clickOnSortByButton);
    getDriver().findElement(clickPriceHigh_To_Low).click();
    waitRefreshed(productContainer, 10);
    return this;
  }

  @Step("Get price before sorting high to low")
  public List<Double> getPriceBeforeSortingHighToLow() {
    List<AllProductsBlock> products = getAllProduct();
    List<Double> productsPrice = new ArrayList<>();
    for (AllProductsBlock product : products) {
      productsPrice.add(product.getPriceAsDouble());
    }
    return productsPrice;
  }

  @Step("Get price after sorting high to low")
  public List<Double> getPriceAfterSortingHighToLow() {
    List<AllProductsBlock> products = getAllProduct();
    List<Double> productsPrice = new ArrayList<>();
    for (AllProductsBlock product : products) {
      productsPrice.add(product.getPriceAsDouble());
    }
    Collections.sort(productsPrice);
    Collections.reverse(productsPrice);
    return productsPrice;
  }

}
