package storeTests;

import blocks.SearchResultBearBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.MainPage;
import pages.SearchResultPage;

public class AddingToCartTests extends BaseTest {

  @Test(description = "Adding to cart")
  public void addingToCartTest() {
    MainPage mainPage = new MainPage();
    String expectedResultNewWindowWithTitle = "Product successfully added to your shopping cart";
    String expectedResultPaperType = "Doted";
    String expectedResultQuantity = "5";
    double expectedResultTotalPriceProduct = 77.40;

    List<SearchResultBearBlock> allProductsFromSearchResultPage = mainPage.openMainPage()
        .getHeaderMenuBlock().clickOnSearchOurCatalogButton("Bear")
        .pressButtonEnterOnTheKeyboard()
        .getAllProductsWithSearchResultBearPage();

    SearchResultPage searchResultPage = new SearchResultPage();

    String getNewWindowWithTitleProductSuccessfullyAddedToYourShoppingCart =
        searchResultPage.clickOnProductWithNameFromBear(
                allProductsFromSearchResultPage, "Brown Bear Notebook")
            .clickOnPaperTypeButton()
            .getDotedButton()
            .clickOnQuantityButton()
            .changeQuantityButton("5")
            .clickAddToCardButton()
            .checkNewWindowWithTitle();

    CartPage cartPage = new CartPage();

    String getPaperType = cartPage.checkCorrectPaperTypeField();
    String getQuantity = cartPage.checkQuantityField();
    double totalPriceBrownBearNotebook = cartPage.getPriceProduct();

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(getNewWindowWithTitleProductSuccessfullyAddedToYourShoppingCart)
        .as("Should be new window with a title appears " + expectedResultNewWindowWithTitle)
        .isEqualTo(expectedResultNewWindowWithTitle);

    softAssertions.assertThat(getPaperType)
        .as("The windows are displayed on the left " + expectedResultPaperType)
        .isEqualTo(expectedResultPaperType.trim());

    softAssertions.assertThat(getQuantity)
        .as("The windows are displayed on the left " + expectedResultQuantity)
        .isEqualTo(expectedResultQuantity);

    softAssertions.assertThat(totalPriceBrownBearNotebook)
        .as("The total price 'Brown bear notebook' should be " + expectedResultTotalPriceProduct)
        .isEqualTo(expectedResultTotalPriceProduct);

    softAssertions.assertAll();

  }

}
