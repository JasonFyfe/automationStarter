package examplePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SauceDemoLandingPage
{
    public final static String URL = "https://www.saucedemo.com/";

    private WebDriver driver;

    public SauceDemoLandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "btn_action")
    private WebElement loginButton;

    @FindBys({@FindBy(className = "login-box"), @FindBy(tagName = "form"), @FindBy(css = "*")})
    private List<WebElement> loginFormElements;

    public void login(String username, String password)
    {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isError()
    {
        for (WebElement element : loginFormElements)
        {
            if (element.getAttribute("data-test") != null && element.getAttribute("data-test").equals("error")){
                return true;
            }
        }
        return false;
    }
}
