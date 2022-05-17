package storeTests;

import blocks.SearchResultMugBlock;
import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.MainPage;
import pages.OrderPage;
import pages.PersonalInformationPage;
import pages.SearchResultPage;

public class CheckoutEndToEndTests extends BaseTest {

  @Test(description = "Check that the total price is calculated correct")
  public void checkEndToEndTest() {
    MainPage mainPage = new MainPage();
    BigDecimal totalPrice = new BigDecimal("39.62");
    BigDecimal expectedResultTotalPriceMugAndT_Shirt = totalPrice.setScale(2, RoundingMode.CEILING);
    BigDecimal totalAmountSubtotalAndShippingPrices = new BigDecimal("48.02");
    BigDecimal expectedResultAmountShippingAndSubtotalPrice = totalAmountSubtotalAndShippingPrices.setScale(
        2, RoundingMode.CEILING);
    String expectedResultTitleOnOrderPage = "YOUR ORDER IS CONFIRMED";

    List<SearchResultMugBlock> getAllProductsFromSearchMugPage = mainPage.openMainPage()
        .getHeaderMenuBlock().clickOnSearchOurCatalogButton("Mug")
        .pressButtonEnterOnTheKeyboard()
        .getAllProductsWithSearchResultMugPage();

    SearchResultPage searchResultPage = new SearchResultPage();
    BigDecimal getSumProductsMugAndT_Shirt = searchResultPage.clickOnProductWithNameFromMug(
            getAllProductsFromSearchMugPage,
            "Customizable Mug")
        .clickAndEndEnterProductCustomization("Best mug ever")
        .clickOnSaveCustomizationButton()
        .clickOnAddToCartButton()
        .clickOnContinueShoppingButton()
        .getHeaderMenuBlock().clickOnSearchOurCatalogButton("T-Shirt")
        .pressButtonEnterOnTheKeyboard()
        .clickOnHummingbirdPrintedT_ShirtProduct()
        .clickOnBlackColorButton()
        .clickOnAddToCartButton()
        .clickOnProceedToCheckoutButton()
        .getTotalPriceCustomizableMugAndT_Shirt();

    CartPage cartPage = new CartPage();
    Faker faker = new Faker();

    BigDecimal getAmountSubtotalAndShippingPrices = cartPage.clickOnProceedToCheckoutButton()
        .clickOnSocialTitleButton()
        .enterFirstNameAs(faker.name().firstName())
        .enterLastNameAs(faker.name().lastName())
        .enterEmailAddressAs(faker.internet().emailAddress())
        .enterBirthdayAs()
        .clickOnTheCheckBoxReceiveOffersFromOurPartners()
        .clickOnTheCheckBoxCustomerDataPrivacy()
        .clickOnTheCheckBoxSignUpForOurNewsletter()
        .clickOnContinueButton()
        .enterCompanyAs(faker.company().name())
        .enterVATNumber(faker.code().isbn10())
        .enterAddress(faker.address().country())
        .enterAddressCompleted(faker.address().city())
        .enterPostalCode("23600")
        .enterCity(faker.address().city())
        .enterPhone(faker.phoneNumber().cellPhone())
        .clickOnTheButtonContinues()
        .clickOnTheCheckBoxMyCarrier()
        .clickOnContinue()
        .clickOnCheckBoxPayByCheck()
        .getTotalPriceAmountSubtotalAndShippingPrices();

    PersonalInformationPage personalInformationPage = new PersonalInformationPage();
    String checkTitleOnOrderPage = personalInformationPage.clickOnCheckBoxI_Agree()
        .clickOnPlaceOrderButton()
        .checkTitlePageYourOrderIsConfirmed();

    OrderPage orderPage = new OrderPage();
    BigDecimal sumTotalProductsPrice = orderPage.getSumTotalProductsPrice();
    double isTotalPriceWithProducts = orderPage.getTotalPriceWithProducts();

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(getSumProductsMugAndT_Shirt)
        .as("The sum of the two products namely: Customizable mug and T-Shirt should be "
            + expectedResultTotalPriceMugAndT_Shirt)
        .isEqualTo(expectedResultTotalPriceMugAndT_Shirt);

    softAssertions.assertThat(getAmountSubtotalAndShippingPrices)
        .as("Subtotal price plus Shipping price should be equal to Total price, namely: "
            + expectedResultAmountShippingAndSubtotalPrice)
        .isEqualTo(expectedResultAmountShippingAndSubtotalPrice);

    softAssertions.assertThat(checkTitleOnOrderPage)
        .as("Should be the text " + expectedResultTitleOnOrderPage
            + " registered in the upper register")
        .isUpperCase().isEqualTo(expectedResultTitleOnOrderPage);

    softAssertions.assertThat(sumTotalProductsPrice)
        .as("The total amount of two goods must be " + isTotalPriceWithProducts)
        .isEqualTo(isTotalPriceWithProducts);

    softAssertions.assertAll();


  }

}
