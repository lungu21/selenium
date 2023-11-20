package rahulshettyacademy.tests.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.tests.pageobjects.CartPage;

import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;
    public AbstractComponents(WebDriver driver)
    {
     this.driver = driver;
     PageFactory.initElements(driver, this);
    }

    @FindBy(css ="[routerlink='/dashboard/cart']")
    WebElement cartHeader;


    //        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")))

    public void waitforElementtoAppear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitforWebElementtoAppear(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        Thread.sleep(2000);

    }
    public CartPage goToCartPage()
    {
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }


}




