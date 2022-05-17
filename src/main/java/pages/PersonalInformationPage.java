package pages;

import io.qameta.allure.Step;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;

public class PersonalInformationPage extends BasePage {

  private final By clickSocialTitle = By.id("field-id_gender-2");
  private final By clickFirstName = By.id("field-firstname");
  private final By clickLastName = By.id("field-lastname");
  private final By clickEmailAddress = By.id("field-email");
  private final By clickBirthday = By.id("field-birthday");
  private final By clickOnCheckBoxReceiveOffersFromOurPartners = By.xpath(
      "//input[@name='optin']");
  private final By clickOnCheckBoxCustomerDataPrivacy = By.xpath(
      "//input[@name='customer_privacy']");
  private final By clickOnCheckBoxSignUpForOurNewsletter = By.xpath(
      "//input[@name='newsletter']");
  private final By clickContinueButton = By.xpath(
      "//footer[@class='form-footer clearfix']/button[contains(@class,'continue btn btn-primary')]");
  private final By clickCompanyField = By.id("field-company");
  private final By clickVATNumber = By.id("field-vat_number");
  private final By clickAddressField = By.id("field-address1");
  private final By clickOnAddressCompleted = By.id("field-address2");
  private final By clickPostalCode = By.id("field-postcode");
  private final By clickCity = By.id("field-city");
  private final By clickPhone = By.id("field-phone");
  private final By clickButtonContinue = By.xpath("//button[@name='confirm-addresses']");
  private final By clickOnCheckBoxMyCarrier = By.id("delivery_option_2");
  private final By clickOnButton = By.xpath("//button[@name='confirmDeliveryOption']");
  private final By clickCheckBoxPayByCheck = By.id("payment-option-1");
  private final By subtotalPrice = By.xpath(
      "//div[@id='cart-subtotal-products']/span[@class='value']");
  private final By shippingPrice = By.xpath(
      "//div[@id='cart-subtotal-shipping']/span[@class='value']");
  private final By clickCheckBoxIAgree = By.id("conditions_to_approve[terms-and-conditions]");
  private final By clickPlaceOrderButton = By.xpath("//div[@class='ps-shown-by-js']/button");

  @Step("Click on social title button")
  public PersonalInformationPage clickOnSocialTitleButton() {
    getDriver().findElement(clickSocialTitle).click();
    return this;
  }

  @Step("Enter first name as {firstName}")
  public PersonalInformationPage enterFirstNameAs(String firstName) {
    getDriver().findElement(clickFirstName).sendKeys(firstName);
    return this;
  }

  @Step("Enter last name as {lastName}")
  public PersonalInformationPage enterLastNameAs(String lastName) {
    getDriver().findElement(clickLastName).sendKeys(lastName);
    return this;
  }

  @Step("Enter email address as {email}")
  public PersonalInformationPage enterEmailAddressAs(String email) {
    getDriver().findElement(clickEmailAddress).sendKeys(email);
    return this;
  }

  @Step("Enter birthday as")
  public PersonalInformationPage enterBirthdayAs() {
    int day = 8;
    int month = 7;
    int year = 28;
    LocalDate dateRedeemed = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    String newDate = dateRedeemed.minusDays(day).plusMonths(month).minusYears(year)
        .format(formatter);
    getDriver().findElement(clickBirthday).sendKeys(newDate);
    return this;
  }

  @Step("Click on the check box receive offers from our partners")
  public PersonalInformationPage clickOnTheCheckBoxReceiveOffersFromOurPartners() {
    getDriver().findElement(clickOnCheckBoxReceiveOffersFromOurPartners).click();
    return this;
  }

  @Step("Click on the check box customer data privacy")
  public PersonalInformationPage clickOnTheCheckBoxCustomerDataPrivacy() {
    getDriver().findElement(clickOnCheckBoxCustomerDataPrivacy).click();
    return this;
  }

  @Step("Click on the check box sign up for our newsletter")
  public PersonalInformationPage clickOnTheCheckBoxSignUpForOurNewsletter() {
    getDriver().findElement(clickOnCheckBoxSignUpForOurNewsletter).click();
    return this;
  }

  @Step("Click on continue button")
  public PersonalInformationPage clickOnContinueButton() {
    getDriver().findElement(clickContinueButton).click();
    return this;
  }

  @Step("Enter company as {company}")
  public PersonalInformationPage enterCompanyAs(String company) {
    getDriver().findElement(clickCompanyField).sendKeys(company);
    return this;
  }

  @Step("Enter VAT number {vatNumber}")
  public PersonalInformationPage enterVATNumber(String vatNumber) {
    getDriver().findElement(clickVATNumber).sendKeys(vatNumber);
    return this;
  }

  @Step("Enter address {addressField}")
  public PersonalInformationPage enterAddress(String addressField) {
    getDriver().findElement(clickAddressField).sendKeys(addressField);
    return this;
  }

  @Step("Enter address completed {addressCompleted}")
  public PersonalInformationPage enterAddressCompleted(String addressCompleted) {
    getDriver().findElement(clickOnAddressCompleted).sendKeys(addressCompleted);
    return this;
  }

  @Step("Enter postal code {postalCode}")
  public PersonalInformationPage enterPostalCode(String postalCode) {
    waitUtilVisible(clickPostalCode, 10);
    getDriver().findElement(clickPostalCode).sendKeys(postalCode);
    return this;
  }

  @Step("Enter city {city}")
  public PersonalInformationPage enterCity(String city) {
    getDriver().findElement(clickCity).sendKeys(city);
    return this;
  }

  @Step("Enter phone {phone}")
  public PersonalInformationPage enterPhone(String phone) {
    getDriver().findElement(clickPhone).sendKeys(phone);
    return this;
  }

  @Step("Click on the button continues")
  public PersonalInformationPage clickOnTheButtonContinues() {
    getDriver().findElement(clickButtonContinue).click();
    return this;
  }

  @Step("Click on the check box my carrier")
  public PersonalInformationPage clickOnTheCheckBoxMyCarrier() {
    getDriver().findElement(clickOnCheckBoxMyCarrier).click();
    return this;
  }

  @Step("Click on continue")
  public PersonalInformationPage clickOnContinue() {
    getDriver().findElement(clickOnButton).click();
    return this;
  }

  @Step("Click on check box pay by check")
  public PersonalInformationPage clickOnCheckBoxPayByCheck() {
    getDriver().findElement(clickCheckBoxPayByCheck).click();
    return this;
  }

  @Step("get total price amount subtotal and shipping prices")
  public BigDecimal getTotalPriceAmountSubtotalAndShippingPrices() {
    String getSubtotalPriceAsString = getDriver().findElement(subtotalPrice)
        .getAttribute("innerText");
    double getSubtotalPriceAsDouble = Double.parseDouble(getSubtotalPriceAsString.substring(1));
    String getShippingPriceAsString = getDriver().findElement(shippingPrice)
        .getAttribute("innerText");
    double getShippingPriceAsDouble = Double.parseDouble(getShippingPriceAsString.substring(1));
    BigDecimal getShippingPrice = new BigDecimal(getShippingPriceAsDouble).setScale(2,
        RoundingMode.HALF_UP);
    BigDecimal getSubtotalPrice = new BigDecimal(getSubtotalPriceAsDouble).setScale(2,
        RoundingMode.HALF_UP);
    return getShippingPrice.add(getSubtotalPrice);
  }

  @Step("Click on check box I Agree")
  public PersonalInformationPage clickOnCheckBoxI_Agree() {
    getDriver().findElement(clickCheckBoxIAgree).click();
    return this;
  }

  @Step("Click on place order button")
  public OrderPage clickOnPlaceOrderButton() {
    getDriver().findElement(clickPlaceOrderButton).click();
    return new OrderPage();
  }
}
