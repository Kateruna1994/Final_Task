package storeTests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class SubscribeWithInvalidEmailTests extends BaseTest {


  @Test(description = "Check the required text near the email window")
  public void checkTheRequiredTextNearTheEmailWindow() {
    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();
    String expectedResultTextAtTheBottomOfThePage = "Get our latest news and special sales";
    String expectedResultTextInTheEmailField = "You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.";
    String textGetOurLatestNewsAndSpecialSalesNearTheEmailField = mainPage.openMainPage()
        .checkThatTextNearTheEmailFieldEqualsGetOurLatestNewsAndSpecialSales();

    softAssertions.assertThat(textGetOurLatestNewsAndSpecialSalesNearTheEmailField)
        .as("At the bottom of the page is the text next to the email field should be " +
            expectedResultTextAtTheBottomOfThePage)
        .isEqualTo(expectedResultTextAtTheBottomOfThePage);

    String isTheRequiredTextAtTheBottomOfThePageBelowTheEmailField =
        mainPage.checkThatTextUnderEmailFieldContains();

    softAssertions.assertThat(isTheRequiredTextAtTheBottomOfThePageBelowTheEmailField)
        .as("At the bottom of the page, the text in the email field contains " +
            expectedResultTextInTheEmailField)
        .isEqualTo(expectedResultTextInTheEmailField);

    String getTextFromButton = mainPage.checkTheSubmitButton();

    softAssertions.assertThat(getTextFromButton)
        .as("Characters on the button " + getTextFromButton + " Written in uppercase")
        .isUpperCase();

    softAssertions.assertAll();
  }
}


