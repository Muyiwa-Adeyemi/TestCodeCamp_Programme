package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    public LoginPage(WebDriver driver) {this.driver = driver;}
    private WebDriver driver;
    public void enterUsername(String email)
    {
        //Wait for page to load
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //Input name in field
        driver.findElement(By.id("username")).sendKeys(email);
    }
    public void enterPassword(String pwd)
    {
        //Input password in field
        driver.findElement(By.id("password")).sendKeys(pwd);
    }
    public HomePage clickLoginBtn()
    {
        //Go to homepage
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/div/div/div[1]/form/div[3]/button")).click();
        return new HomePage(driver);
    }
}
