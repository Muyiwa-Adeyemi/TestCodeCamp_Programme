package user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserDedamTests {
   private WebDriver driver;   //import the selenium WebDriver by
    @BeforeClass   //functions before test commence
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        System.out.println (driver.getTitle ());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest() throws InterruptedException {
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
//Locate the username field. Use your own Valid username
        driver.findElement(By.id("username")).sendKeys("Muyiwa_Adeyemi");
                //Locate the email field. User your own valid Password
                driver.findElement(By.id("password")).sendKeys("kosiwahala25");
// Click on the login button
        driver.findElement(By.xpath ("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        //Wait to see users logged in page
        Thread.sleep (5000);
        //Test to confirm user Logged in
        if(driver.getCurrentUrl ().contains ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")) {
            System.out.println ("PASSED - User has successfully logged in");
        }else{
            System.out.println ("FAILED - The user was unable to login");
        }
        Thread.sleep (5000);
//Waiting to see logged in Page
    }
    @Test
    public void logoutTest() throws InterruptedException {
        driver.findElement (By.xpath ("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click ();	//Click on the arrow button that has the logout menu on the list
        Thread.sleep (5000);						// Wait to ensure the drop-down list is displayed
        driver.findElement (By.linkText ("Log Out")).click ();              	//Click on the logout button
        //Test to confirm user Logged out
        if(driver.getCurrentUrl ().contains ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login")) {
            System.out.println ("PASSED - User has successfully logged out");
        }else{
            System.out.println ("FAILED - The user is still logged in");
        }
        Thread.sleep (5000);                                                                                  //Waiting to see logged out Page
    }
    @AfterTest
    public void tearDown() {
        driver.quit ();
    }
}





