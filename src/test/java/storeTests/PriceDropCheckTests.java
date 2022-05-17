package storeTests;

import blocks.PricesDropBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PricesDropPage;

public class PriceDropCheckTests extends BaseTest {

  @Test(description = "Check that every product has old and new price"
      + "  and promo price for every product calculates correct")
  public void checkPriceProductsTest() {
    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();

    List<PricesDropBlock> getAllProductWithPricesDropPage = mainPage.openMainPage()
        .clickOnPricesDropLink()
        .getAllProductPricesDrop();

    PricesDropPage pricesDropPage = new PricesDropPage();
    List<PricesDropBlock> priceAdnRegularPriceWithAllProducts = pricesDropPage.getPriceAdnRegularPriceWithAllProducts(
        getAllProductWithPricesDropPage);

    List<PricesDropBlock> allProductWithCorrectPrice = pricesDropPage.getAllProductWithCorrectPrice(
        getAllProductWithPricesDropPage);

    softAssertions.assertThat(priceAdnRegularPriceWithAllProducts)
        .as("All products has old and new price")
        .isEqualTo(getAllProductWithPricesDropPage);

    softAssertions.assertThat(allProductWithCorrectPrice)
        .as("Promo price for every product calculates correct")
        .isEqualTo(getAllProductWithPricesDropPage);

    softAssertions.assertAll();


  }

}
