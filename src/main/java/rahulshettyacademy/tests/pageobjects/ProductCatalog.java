package rahulshettyacademy.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.tests.AbstractComponents.AbstractComponents;

import java.util.List;

public class ProductCatalog extends AbstractComponents {
    WebDriver driver;

    public ProductCatalog (WebDriver driver)
    {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);  //this- current class  driver

    }
    // List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));
    //driver.findElement(By.cssSelector(".ng-animating"))));

    @FindBy(css ="div.mb-3")
    List<WebElement> products;

    @FindBy(css =".ng-animating")
    WebElement spinner;



    By productsBy = By.cssSelector("div.mb-3");
    By addToCard = By.cssSelector(".card-body button:nth-of-type(2)");
    By toastMessage = By.cssSelector("#toast-container");


    public List< WebElement> getProductList()
    {
        waitforElementtoAppear(productsBy);
        return products;
    }


    public WebElement getProductName(String productName)
    {
        WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).
                 getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        return prod;
    }

    public void addProductTocART(String productName) throws InterruptedException {
        // prod.findElement(By.cssSelector(".card-body button:nth-of-type(2)")).click();
        WebElement prod = getProductName(productName);
        prod.findElement(addToCard).click();
        waitforElementtoAppear(toastMessage);
        waitForElementToDisappear(spinner);


    }
    //       driver.findElement(By.cssSelector(".totalRow button")).click();

}
