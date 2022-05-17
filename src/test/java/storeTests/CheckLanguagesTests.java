package storeTests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

//
public class CheckLanguagesTests extends BaseTest {

  @Test(description = "Check how many languages on the page and whether they are among them 'Українська'")
  public void checkTheTotalNumberOfLanguagesOnThePage() {
    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();
    int expectedResultOnPageShouldBeLanguage = 44;

    int checkHowManyLanguageAreListedOnPage = mainPage.openMainPage()
        .clickOnTheLanguageButton()
        .checkTheNumberOfLanguagesInTheList();

    softAssertions.assertThat(checkHowManyLanguageAreListedOnPage)
        .as("In the top menu, the drop-dawn button 'language' should be in the amount "
            + expectedResultOnPageShouldBeLanguage)
        .isEqualTo(expectedResultOnPageShouldBeLanguage);

    boolean checkInUkrainianIsPresentAmongAllLanguage = mainPage.checkThatUkrainianIsOnTheListOfLanguages();

    softAssertions.assertThat(checkInUkrainianIsPresentAmongAllLanguage)
        .as("From the drop-dawn list of languages should be present 'Українська'")
        .isTrue();

    softAssertions.assertAll();

  }


}
