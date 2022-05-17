package storeTests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckCategoriesTests extends BaseTest {

  @Test(description = "Check that when hover a category a sub category appears")
  public void checkIfSubcategoriesAppear() {
    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();
    int expectedResultSubCategory = 1;
    int clothesSubMenu = mainPage.openMainPage()
        .getHeaderMenuBlock().hoverOnClothesButton()
        .getClothesSubMenu();

    int accessoriesSubMenu = mainPage.getHeaderMenuBlock().hoverOnAccessoriesButton()
        .getAccessoriesSubMenu();

    int artSubMenu = mainPage.getHeaderMenuBlock().hoverOnArtButton()
        .getArtSubMenu();

    softAssertions.assertThat(clothesSubMenu)
        .as("Hover over the clothes category should be " + expectedResultSubCategory
            + " sub category")
        .isEqualTo(expectedResultSubCategory);

    softAssertions.assertThat(accessoriesSubMenu)
        .as("Hover over the accessories category should be " + expectedResultSubCategory
            + " sub category")
        .isEqualTo(expectedResultSubCategory);

    softAssertions.assertThat(artSubMenu)
        .as("Hover over the accessories category should be " + expectedResultSubCategory
            + " sub category")
        .isEqualTo(expectedResultSubCategory);

    softAssertions.assertAll();


  }

}
