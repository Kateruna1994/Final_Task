package pages;

import io.qameta.allure.Step;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

  private final By clickSocialTitle = By.id("field-id_gender-2");
  private final By clickOnFirstNameField = By.id("field-firstname");
  private final By clickOnLastNameField = By.id("field-lastname");
  private final By clickOnEmailField = By.id("field-email");
  private final By clickOnPasswordField = By.xpath("//input[@name='password']");
  private final By clickOnBirthdayField = By.id("field-birthday");
  private final By clickOnCheckBox = By.xpath("//input[@name='optin']");
  private final By clickOnCheckBoxCustomer = By.xpath("//input[@name='customer_privacy']");
  private final By clickOnCheckBoxNewsletter = By.xpath("//input[@name='newsletter']");
  private final By clickOnSaveButton = By.xpath("//button[@type='submit']");

  @Step("Click on check box social title")
  public RegistrationPage clickOnCheckBoxSocialTitle() {
    getDriver().findElement(clickSocialTitle).click();
    return this;
  }

  @Step("Enter first name as {firstName}")
  public RegistrationPage enterFirstName(String firstName) {
    getDriver().findElement(clickOnFirstNameField).sendKeys(firstName);
    return this;
  }

  @Step("Enter last name as {lastName}")
  public RegistrationPage enterLastName(String lastName) {
    getDriver().findElement(clickOnLastNameField).sendKeys(lastName);
    return this;
  }

  @Step("Enter email as {email}")
  public RegistrationPage enterEmail(String email) {
    getDriver().findElement(clickOnEmailField).sendKeys(email);
    return this;
  }

  @Step("Enter password as {password}")
  public RegistrationPage enterPassword(String password) {
    getDriver().findElement(clickOnPasswordField).sendKeys(password);
    return this;
  }

  @Step("Enter birthday")
  public RegistrationPage enterBirthday() {
    int day = 8;
    int month = 7;
    int year = 28;
    LocalDate dateRedeemed = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    String newDate = dateRedeemed.minusDays(day).plusMonths(month).minusYears(year)
        .format(formatter);
    getDriver().findElement(clickOnBirthdayField).sendKeys(newDate);
    return this;
  }

  @Step("Click on receive offers from our partners check box")
  public RegistrationPage clickOnReceiveOffersFromOurPartnersCheckBox() {
    getDriver().findElement(clickOnCheckBox).click();
    return this;
  }

  @Step("Click on customer data privacy check box")
  public RegistrationPage clickOnCustomerDataPrivacyCheckBox() {
    getDriver().findElement(clickOnCheckBoxCustomer).click();
    return this;
  }

  @Step("Click on sign up for our newsletter")
  public RegistrationPage clickOnSignUpForOurNewsletter() {
    getDriver().findElement(clickOnCheckBoxNewsletter).click();
    return this;
  }

  @Step("Click on the save button")
  public MainPage clickOnTheSaveButton() {
    getDriver().findElement(clickOnSaveButton).click();
    return new MainPage();
  }

  @Step("Click save button and check for error")
  public RegistrationPage clickSaveButtonAndCheckForError() {
    getDriver().findElement(clickOnSaveButton).click();
    return this;
  }

  @Step("Check that the frame of the first name field is red")
  public String checkThatTheFrameOfTheFirstNameFieldIsRed() {
    WebElement element = getDriver().findElement(clickOnFirstNameField);
    element.click();
    return element.getCssValue("outline-color");
  }

  @Step("Get text under field first name")
  public String getTextUnderFieldFirstName() {
    return getDriver().findElement(By.xpath("//li[@class='alert alert-danger']")).getText();
  }
}
