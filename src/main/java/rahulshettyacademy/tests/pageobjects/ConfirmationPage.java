package rahulshettyacademy.tests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.tests.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {

    WebDriver driver;
    //String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
    //       Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    public ConfirmationPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css =".hero-primary")
    WebElement confirmMessage;

    public String getMessage()
    {
    String message = confirmMessage.getText();
    return message;
    }
}
