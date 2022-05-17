package storeTests;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;

public class RegistrationWithInvalidDataTests extends BaseTest {

  @Test(description = "Check that 'First name' highlighted in red and pop-up with text 'Invalid date'")
  public void checkPop_upWithText() {
    MainPage mainPage = new MainPage();
    Faker faker = new Faker();
    String expectedResultHighlightedFirstName = "rgba(255, 76, 76, 1)";
    String expectedResultTextUnderFieldFirstName = "Invalid name";

    String checkFirstNameHighlightedInRed = mainPage.openMainPage()
        .clickOnSingInButton()
        .clickOnLinkNoAccount()
        .clickOnCheckBoxSocialTitle()
        .enterFirstName("James8")
        .enterLastName(faker.name().lastName())
        .enterEmail(faker.internet().emailAddress())
        .enterPassword(faker.internet().password())
        .enterBirthday()
        .clickOnReceiveOffersFromOurPartnersCheckBox()
        .clickOnCustomerDataPrivacyCheckBox()
        .clickOnSignUpForOurNewsletter()
        .clickSaveButtonAndCheckForError()
        .checkThatTheFrameOfTheFirstNameFieldIsRed();

    RegistrationPage registrationPage = new RegistrationPage();
    String getTextUnderField = registrationPage.getTextUnderFieldFirstName();

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(checkFirstNameHighlightedInRed)
        .as("First name should be highlighted in " + expectedResultHighlightedFirstName)
        .isEqualTo(expectedResultHighlightedFirstName);

    softAssertions.assertThat(getTextUnderField)
        .as("Under field 'First name' should be text " + expectedResultTextUnderFieldFirstName)
        .isEqualTo(expectedResultTextUnderFieldFirstName);

    softAssertions.assertAll();

  }

}
