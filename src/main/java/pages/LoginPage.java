package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  private final By clickLink = By.xpath("//div[@class='no-account']/a");

  @Step("Click on link no account")
  public RegistrationPage clickOnLinkNoAccount() {
    getDriver().findElement(clickLink).click();
    return new RegistrationPage();
  }

}
