package storeTests;

import blocks.PopularProductsBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckPopularProductsTests extends BaseTest {

  @Test(description = "Check if the products have name, price, price more than '0.00'")
  public void checkProducts() {
    MainPage mainPage = new MainPage();
    int expectedResultHowManyPopularProductsShouldBe = 8;
    SoftAssertions softAssertions = new SoftAssertions();
    List<PopularProductsBlock> products = mainPage.openMainPage()
        .getAllPopularProduct();

    softAssertions.assertThat(products)
        .as("Popular products we expect to be: " + expectedResultHowManyPopularProductsShouldBe
            + " and received: " + products.size())
        .hasSize(expectedResultHowManyPopularProductsShouldBe);

    List<String> actualResultNamesPopularProducts = mainPage.getNamePopularProducts(products);

    softAssertions.assertThat(actualResultNamesPopularProducts)
        .as("Popular products should have a name for each product "
            + expectedResultHowManyPopularProductsShouldBe + " and received: "
            + actualResultNamesPopularProducts.size())
        .hasSize(expectedResultHowManyPopularProductsShouldBe);

    List<String> actualResultPricesPopularProducts = mainPage.getPricePopularProducts(products);

    softAssertions.assertThat(actualResultPricesPopularProducts)
        .as("Popular products should have a price for each product "
            + expectedResultHowManyPopularProductsShouldBe + " and received "
            + actualResultPricesPopularProducts.size())
        .hasSize(expectedResultHowManyPopularProductsShouldBe);

    boolean isProductsWithPriceThatAreMoreZero = mainPage.getPriceProductsThatAreMoreZero(products);

    softAssertions.assertThat(isProductsWithPriceThatAreMoreZero)
        .as("All price bigger 0.00")
        .isTrue();

    softAssertions.assertAll();
  }

}
