package storeTests;

import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationWithValidDataTests extends BaseTest {

  @Test(description = "Check name appear near cart button")
  public void checkNameAppearNearCartButton() {
    MainPage mainPage = new MainPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String password = faker.internet().password();
    String expectedResultTextNearCartButton = firstName + " " + lastName;

    String checkRegisterAccount = mainPage.openMainPage()
        .clickOnSingInButton()
        .clickOnLinkNoAccount()
        .clickOnCheckBoxSocialTitle()
        .enterFirstName(firstName)
        .enterLastName(lastName)
        .enterEmail(faker.internet().emailAddress())
        .enterPassword(password)
        .enterBirthday()
        .clickOnReceiveOffersFromOurPartnersCheckBox()
        .clickOnCustomerDataPrivacyCheckBox()
        .clickOnSignUpForOurNewsletter()
        .clickOnTheSaveButton()
        .getNameNearCartButton();

    Assertions.assertThat(checkRegisterAccount)
        .as("Near cart button should be text " + expectedResultTextNearCartButton)
        .isEqualTo(expectedResultTextNearCartButton);

  }
}
