package rahulshettyacademy.tests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.tests.pageobjects.CartPage;
import rahulshettyacademy.tests.pageobjects.CheckOutPage;
import rahulshettyacademy.tests.pageobjects.ConfirmationPage;
import rahulshettyacademy.tests.pageobjects.ProductCatalog;

import java.io.IOException;
import java.util.List;

public class StandAloneTest extends BaseTest {
       // WebDriverManager.chromedriver().setup(); //se adauga chromedriver automat
       @Test
       public void submitOrder() throws IOException, InterruptedException {


           String productName = "ZARA COAT 3";
           ProductCatalog productCatalog = landingPage.logginAplication("vlada.lungu@gmail.com", "Vlada123");
           List<WebElement> products = productCatalog.getProductList();
           productCatalog.addProductTocART(productName);
           CartPage cartPage = productCatalog.goToCartPage();

           boolean match = cartPage.VerifyProductDisplay(productName);
           Assert.assertTrue(match);
           CheckOutPage checkOutPage = cartPage.gotoCheckout();
           checkOutPage.selectCountry("india");
           ConfirmationPage confirmationPage = checkOutPage.submitOrder();

           Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmationPage.getMessage());


       }
    }


