package examplePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCartPage
{
    public final static String URL = "https://www.saucedemo.com/cart.html";

    private WebDriver driver;

    public SauceDemoCartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
