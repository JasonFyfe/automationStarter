package examplePOM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SauceDemoTest
{
    private WebDriver driver;

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1746, 758));
    }

    @Test
    public void successfulLogin()
    {
        driver.get(SauceDemoLandingPage.URL);
        SauceDemoLandingPage landingPage = new SauceDemoLandingPage(driver);
        landingPage.login("standard_user", "secret_sauce");
        assertEquals(SauceDemoInventoryPage.URL, driver.getCurrentUrl());
    }

    @Test
    public void lockedOutUserLogin()
    {
        driver.get(SauceDemoLandingPage.URL);
        SauceDemoLandingPage landingPage = new SauceDemoLandingPage(driver);
        landingPage.login("locked_out_user", "secret_sauce");
        assertTrue(landingPage.isError());
    }

    @Test
    public void incorrectDetails() {
        driver.get(SauceDemoLandingPage.URL);
        SauceDemoLandingPage landingPage = new SauceDemoLandingPage(driver);
        landingPage.login("guest", "guest");
        assertTrue(landingPage.isError());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
