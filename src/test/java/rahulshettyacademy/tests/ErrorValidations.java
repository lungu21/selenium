package rahulshettyacademy.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.tests.pageobjects.ProductCatalog;

public class ErrorValidations extends BaseTest {

    @Test
    public void submitOrder()
    {
        String productName= "ZARA COAT";
        ProductCatalog productCatalog = landingPage.logginAplication("soimu.vadim@gmail.com", "Iamki000");
      WebElement actualmMssage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.",actualmMssage);
    }



}
