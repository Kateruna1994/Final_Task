package blocks;

import java.time.Duration;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.MainPage;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class HeaderMenuBlock {

  private static WebDriver driver;

  public HeaderMenuBlock(WebDriver webDriver) {
    driver = webDriver;

  }

  private final By clickOnSearchButton = By.xpath("//input[@aria-label='Search']");
  private final By hoverClothesButton = By.xpath(
      "//ul[@id='top-menu']//a[text()[normalize-space()='Clothes']]");
  private final By hoverAccessoriesButton = By.xpath(
      "//ul[@id='top-menu']//a[text()[normalize-space()='Accessories']]");
  private final By hoverArtButton = By.xpath(
      "//ul[@id='top-menu']//a[text()[normalize-space()='Art']]");

  public MainPage clickOnSearchOurCatalogButton(String name) {
    BasePage.waitUtilVisible(clickOnSearchButton, 10);
    driver.findElement(clickOnSearchButton).sendKeys(name);
    return new MainPage();
  }

  public MainPage hoverOnClothesButton() {
    BasePage.waitUtilVisible(hoverClothesButton, 10);
    BasePage.hoverMouseOverElementWithLocator(hoverClothesButton);
    return new MainPage();
  }

  public MainPage hoverOnAccessoriesButton() {
    BasePage.hoverMouseOverElementWithLocator(hoverAccessoriesButton);
    return new MainPage();
  }

  public MainPage hoverOnArtButton() {
    BasePage.hoverMouseOverElementWithLocator(hoverArtButton);
    return new MainPage();
  }

}
