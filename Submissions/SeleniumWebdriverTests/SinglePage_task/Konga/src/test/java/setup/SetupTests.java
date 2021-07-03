package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SubCategoryPage;

public class SetupTests {
    //instantiate chrome webdriver
    private WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SubCategoryPage subCategoryPage;
    protected CheckoutPage checkoutPage;
    @BeforeTest
    public void setup()
    {
        //add chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //launch a new browser instance
        driver = new ChromeDriver();
        //maximize chrome browser window
        driver.manage().window().maximize();
        //navigate to konga url
        driver.get("https://www.konga.com/account/login?return_url=/");
        //go to login page to enter login details
        loginPage = new LoginPage(driver);
    }
    @AfterTest
    public void closeBrowser()
    {
        //exit browser after test
        driver.quit();
    }
}
