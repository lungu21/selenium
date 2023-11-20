package rahulshettyacademy.tests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.tests.AbstractComponents.AbstractComponents;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;

    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css=".cartSection h3")
    List <WebElement> cartProducts;

    @FindBy (css=".totalRow button")
   WebElement checkputEle;

    public boolean VerifyProductDisplay(String productName)
    {
        Boolean match =  cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }
    public CheckOutPage gotoCheckout()
    {
        checkputEle.click();

        return new CheckOutPage(driver);

    }


    // List<WebElement> CartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
   // Boolean match =   CartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
     //   Assert.assertTrue(match);
       // driver.findElement(By.cssSelector(".totalRow button")).click();

}
