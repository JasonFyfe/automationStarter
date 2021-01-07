package examplePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SauceDemoInventoryPage
{
    public final static String URL = "https://www.saucedemo.com/inventory.html";

    private WebDriver driver;

    public SauceDemoInventoryPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "btn_action")
    private WebElement loginButton;

    @FindBys({@FindBy(className = "login-box"), @FindBy(css = "*")})
    private List<WebElement> inventoryElements;

    public boolean addAllToCart()
    {
        for (WebElement element : inventoryElements)
        {
            if (element.getAttribute("data-test") != null && element.getAttribute("data-test").equals("error")){
                return true;
            }
        }
        return false;
    }
}
