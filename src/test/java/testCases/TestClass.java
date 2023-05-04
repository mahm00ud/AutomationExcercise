package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.time.Duration;

public class TestClass {

    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    SearchResultsPage searchResultsPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;

    SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();

        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 0)
    public void verifyProductIsAddedToCart(){
        homePage.clickOnProducts();
        productsPage.searchProduct("Tshirt");
        searchResultsPage.viewProductWithIndex(0);

        String productName = productDetailsPage.getProductName();

        productDetailsPage.addToCart();
        softAssert.assertTrue(productDetailsPage.isSuccessAddToCartMsgDisplayed());

        productDetailsPage.viewCart();
        softAssert.assertEquals(cartPage.getProductNameInCart(), productName);

        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void verifyCheckoutSuccessfully(){
        homePage.clickOnLoginBtn();
        loginPage.login("Testuser11@test.com","Testuser11@test.com");
        homePage.clickOnProducts();
        productsPage.searchProduct("Tshirt");
        searchResultsPage.viewProductWithIndex(0);
        productDetailsPage.addToCart();
        productDetailsPage.viewCart();
        cartPage.clickCheckOut();
        checkoutPage.clickOnPlaceOrder();
        paymentPage.payOrder("Test","15151511","311","12","2025");

        softAssert.assertEquals(paymentPage.getConfirmationMsgForPay(),"Congratulations! Your order has been confirmed!");

        softAssert.assertAll();
    }


}
