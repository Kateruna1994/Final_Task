package pages;

import blocks.PopularProductsBlock;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class MainPage extends BasePage {

  private final By checkTheTextInFrontOfTheEmailField = By.xpath(
      "//p[@id='block-newsletter-label']");
  private final By checkTheTextAtTheBottomOfThePageBelowTheEmailField = By.xpath(
      "//div[@class='col-xs-12']/p");
  private final By clothesSubMenu = By.xpath(
      "//li//a[text()[normalize-space()='Clothes']]//following-sibling::div");
  private final By accessoriesSubMenu = By.xpath(
      "//li//a[text()[normalize-space()='Accessories']]//following-sibling::div");
  private final By artSubMenu = By.xpath(
      "//li//a[text()[normalize-space()='Art']]//following-sibling::div");
  private final By checkSubmitButton = By.xpath("//input[@value='Subscribe']");
  private final By clickSingInButton = By.xpath("//a[contains(@title,'customer account')]");
  private final By checkTheListOfLanguages = By.xpath("//select[@class='link hidden-md-up']");
  private final By clickOnLanguageButton = By.id("_desktop_language_selector");
  private final By popularProductContainer = By.xpath(
      "//div[contains(@class,'thumbnail-container reviews-loaded')]");
  private final By clickOnLink = By.id("link-product-page-prices-drop-1");
  private final By clickOnProductButton = By.xpath("//a[contains(@class,'all-product-link')]");
  private final By clickOnSearchButton = By.xpath("//input[@aria-label='Search']");

  @Step("Open main page")
  public MainPage openMainPage() {
    getDriver().get("https://demo.prestashop.com/");
    switchToFrame();
    return new MainPage();
  }

  @Step("Check that text near the email field equals get our latest news and special sales")
  public String checkThatTextNearTheEmailFieldEqualsGetOurLatestNewsAndSpecialSales() {
    waitUtilVisible(checkTheTextInFrontOfTheEmailField, 10);
    scrollToElement(getDriver(), checkTheTextInFrontOfTheEmailField);
    return getDriver().findElement(checkTheTextInFrontOfTheEmailField).getText();
  }

  @Step("Check that text under email field contains")
  public String checkThatTextUnderEmailFieldContains() {
    return getDriver().findElement(checkTheTextAtTheBottomOfThePageBelowTheEmailField).getText();
  }

  @Step("Check the submit button is uppercase")
  public String checkTheSubmitButton() {
    return getDriver().findElement(checkSubmitButton).getAttribute("value").toUpperCase();
  }

  @Step("Click on the language button")
  public MainPage clickOnTheLanguageButton() {
    waitUtilVisible(clickOnLanguageButton, 10);
    getDriver().findElement(clickOnLanguageButton).click();
    return this;
  }

  @Step("Get clothes sub menu")
  public int getClothesSubMenu() {
    return getDriver().findElements(clothesSubMenu).size();
  }

  @Step("Get accessories sub menu")
  public int getAccessoriesSubMenu() {
    return getDriver().findElements(accessoriesSubMenu).size();
  }

  @Step("Get art sub menu")
  public int getArtSubMenu() {
    return getDriver().findElements(artSubMenu).size();
  }

  public int checkTheNumberOfLanguagesInTheList() {
    Select select = new Select(getDriver().findElement(checkTheListOfLanguages));
    List<WebElement> option = select.getOptions();
    return option.size();
  }

  @Step("Check that Ukrainian is on the list of languages")
  public boolean checkThatUkrainianIsOnTheListOfLanguages() {
    return getDriver().findElement(checkTheListOfLanguages).getAttribute("innerText")
        .contains("Українська");
  }

  @Step("Click on sing button")
  public LoginPage clickOnSingInButton() {
    waitUtilVisible(clickSingInButton, 10);
    getDriver().findElement(clickSingInButton).click();
    return new LoginPage();
  }

  @Step("Get name near cart button")
  public String getNameNearCartButton() {
    return getDriver().findElement(By.xpath("//span[@class='hidden-sm-down']")).getText();
  }

  public List<PopularProductsBlock> getAllPopularProduct() {
    waitUtilVisible(popularProductContainer, 10);
    scrollToElement(getDriver(), popularProductContainer);
    List<PopularProductsBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(popularProductContainer);
    for (WebElement container : containers) {
      PopularProductsBlock popularProductsBlock = new PopularProductsBlock(container);
      products.add(popularProductsBlock);
    }
    return products;
  }

  @Step("Get name popular products")
  public List<String> getNamePopularProducts(List<PopularProductsBlock> products) {
    List<String> namesPopularProduct = new ArrayList<>();
    for (PopularProductsBlock product : products) {
      namesPopularProduct.add(product.getNameAsStringProduct());
    }
    return namesPopularProduct;
  }

  @Step("Get price popular products")
  public List<String> getPricePopularProducts(List<PopularProductsBlock> products) {
    List<String> pricesPopularProduct = new ArrayList<>();
    for (PopularProductsBlock product : products) {
      pricesPopularProduct.add(product.getPrice().substring(1));
    }
    return pricesPopularProduct;
  }

  @Step("Get price products that are more '0.00'")
  public boolean getPriceProductsThatAreMoreZero(List<PopularProductsBlock> products) {
    for (PopularProductsBlock product : products) {
      if (product.getPriceAsDouble() <= 0.00) {
        return false;
      }
    }
    return true;
  }

  @Step("Click on prices drop link")
  public PricesDropPage clickOnPricesDropLink() {
    waitUtilVisible(clickOnLink, 10);
    scrollToElement(getDriver(), clickOnLink);
    getDriver().findElement(clickOnLink).click();
    return new PricesDropPage();
  }

  @Step("Click on all products button")
  public AllProductPage clickOnAllProductsButton() {
    waitUtilVisible(clickOnProductButton, 10);
    getDriver().findElement(clickOnProductButton).click();
    return new AllProductPage();
  }


  public SearchResultPage pressButtonEnterOnTheKeyboard() {
    pressEnterOnTheKeyboard(clickOnSearchButton);
    return new SearchResultPage();
  }


}
