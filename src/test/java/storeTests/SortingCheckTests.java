package storeTests;

import blocks.AllProductsBlock;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.MainPage;

public class SortingCheckTests extends BaseTest {

  @Test(description = "Check sorting products")
  public void checkSortingProductsTest() {
    MainPage mainPage = new MainPage();

    List<String> productsNameBeforeSortingWith_A_to_Z = mainPage.openMainPage()
        .clickOnAllProductsButton()
        .clickOnTheSortByButton()
        .clickSortByName_A_To_Z_Field()
        .getNameBeforeSortingWith_A_To_Z();

    SoftAssertions softAssertions = new SoftAssertions();

    AllProductPage allProductPage = new AllProductPage();
    List<String> productsNameAfterSorting = allProductPage.getNameAfterSortingWith_A_To_Z();

    softAssertions.assertThat(productsNameBeforeSortingWith_A_to_Z.equals(productsNameAfterSorting))
        .as("Sorting products name " + productsNameBeforeSortingWith_A_to_Z
            + " should be equals all products name after sorting " + productsNameAfterSorting)
        .isTrue();

    List<String> productsNameBeforeSortingWith_Z_to_A = allProductPage.clickOnTheSortByButton()
        .clickSortByName_Z_To_A_Field()
        .getNameBeforeSortingWith_Z_To_A();

    List<String> productsNameAfterSortingWith_Z_to_A = allProductPage.getNameAfterSortingWith_Z_To_A();

    softAssertions.assertThat(
            productsNameBeforeSortingWith_Z_to_A.equals(productsNameAfterSortingWith_Z_to_A))
        .as("Sorting products name " + productsNameBeforeSortingWith_Z_to_A
            + " should be equals all products name after sorting "
            + productsNameAfterSortingWith_Z_to_A)
        .isTrue();

    List<Double> productsPriceBeforeSortingLowToHigh = allProductPage.clickOnTheSortByButton()
        .clickSortByPrice_Low_To_High()
        .getPriceBeforeSortingLowToHigh();

    List<Double> productsPriceAfterSortingLowToHigh = allProductPage.getPriceAfterSortingLowToHigh();

    softAssertions.assertThat(
            productsPriceBeforeSortingLowToHigh.equals(productsPriceAfterSortingLowToHigh))
        .as("Sorting products price " + productsPriceBeforeSortingLowToHigh
            + " should be equals all products price after sorting "
            + productsPriceAfterSortingLowToHigh)
        .isTrue();

    List<Double> productsPriceBeforeSortingHigh = allProductPage.clickOnTheSortByButton()
        .clickSortByPrice_High_To_Low()
        .getPriceBeforeSortingHighToLow();

    List<Double> productsPriceAfterSortingHighToLow = allProductPage.getPriceAfterSortingHighToLow();

    softAssertions.assertThat(
            productsPriceBeforeSortingHigh.equals(productsPriceAfterSortingHighToLow))
        .as("Sorting products price " + productsPriceBeforeSortingHigh
            + " should be equals all products price after sorting "
            + productsPriceBeforeSortingHigh)
        .isTrue();

    softAssertions.assertAll();

  }
}
