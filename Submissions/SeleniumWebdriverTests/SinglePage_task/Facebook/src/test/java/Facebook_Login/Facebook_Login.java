package Facebook_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Facebook_Login {
    //import selenium WebDriver
    private WebDriver driver;
    // import the selenium WebDriver by
    @BeforeClass
        // functions before test commence
        public void setUp() throws InterruptedException {
        //class
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // add the chromedriver on which the test will run
        driver = new ChromeDriver();
        // launch a new browser instance
        driver.get("https://www.facebook.com/");
        // input website URL
        Thread.sleep(5000);
        //wait for the page to load
        driver.manage().window().maximize();
        //Maximize the page
        System.out.println(driver.getTitle());
        // Get page title
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
        public void loginTest() throws InterruptedException {
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        //Locate the username field. Use your own Valid username
        driver.findElement(By.id("email")).sendKeys("muyiwadeyemi@gmail.com");
        //Locate the email field. User your own valid Password
        driver.findElement(By.id("pass")).sendKeys("bhaloluismyson17");
        // Click on the login button
        driver.findElement(By.xpath ("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        //Wait to see users logged in page
        Thread.sleep (5000);
        //Test to confirm user Logged in
        if(driver.getCurrentUrl ().contains ("https://www.facebook.com/")) { System.out.println ("PASSED - User has successfully logged in");
        }else{ System.out.println ("FAILED - The user was unable to login");
        }
        Thread.sleep (5000);
        //Waiting to see logged in Page
    }

    @Test
        public void logoutTest() throws InterruptedException {
        //Click on the dropdown button
        driver.findElement(By.cssSelector ("div[aria-label=\"Account\"]")).click ();
        // Wait to ensure the drop-down list is displayed
        Thread.sleep (5000);
        //Click on the logout button
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div")).click();
        //Test to confirm user Logged out
        if(driver.getCurrentUrl ().contains ("https://www.facebook.com/")) {
            System.out.println ("PASSED - User has successfully logged out");
        }else{
            System.out.println ("FAILED - The user is still logged in");
        }
        Thread.sleep (5000);
        //Waiting to see logged out Page
    }
    @AfterTest
    public void tearDown(){
        driver.quit ();
    }
}




