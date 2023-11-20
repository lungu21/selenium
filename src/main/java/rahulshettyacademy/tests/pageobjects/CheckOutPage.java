package rahulshettyacademy.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.tests.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
WebDriver driver ;
   // Actions a = new Actions(driver);
       // a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-group section")));
        //driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
        //driver.findElement(By.cssSelector(".action__submit")).click();
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="[placeholder='Select Country']")
    WebElement country;
    @FindBy(css =".ta-item:nth-of-type(2)")
    WebElement selectCountry;
    @FindBy(css =".action__submit")
    WebElement submit;

    By contry = By.cssSelector("form-group section");


    public  void selectCountry(String countryName)
    {
        Actions a = new Actions(driver);
        a.sendKeys(country,countryName).build().perform();
        waitforElementtoAppear(contry);
        selectCountry.click();


    }
    public ConfirmationPage submitOrder()
    {
        submit.click();
        return new ConfirmationPage(driver);
    }
}
