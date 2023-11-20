package rahulshettyacademy.tests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.tests.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
    WebDriver driver;

     public LandingPage(WebDriver driver)
     {
         super(driver);
         this.driver= driver;
         PageFactory.initElements(driver, this);  //this- current class  driver

     }
    //WebElement userEmail = driver.findElement(By.id("userEmail"));

     //PageFactory
    @FindBy(id ="userEmail")
    WebElement userEmail;

     //driver.findElement(By.id("userPassword")).sendKeys("Vlada123");
    @FindBy(id ="userPassword")
    WebElement userPassword;

    //driver.findElement(By.id("login")).click();
    @FindBy(id ="login")
    WebElement submit;

    @FindBy(css ="[class*=flyInOut")
    WebElement errorMessage;



    public ProductCatalog logginAplication(String email, String password) {

        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submit.click();
        ProductCatalog productCatalog = new ProductCatalog(driver);
        return productCatalog;
    }

    public WebElement getErrorMessage()
    {
        waitforWebElementtoAppear(errorMessage);
        errorMessage.getText();
        return errorMessage;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }



}
