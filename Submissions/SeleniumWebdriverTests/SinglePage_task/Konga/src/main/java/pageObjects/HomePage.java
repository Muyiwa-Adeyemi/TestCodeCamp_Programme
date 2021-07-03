package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public HomePage(WebDriver driver) {this.driver = driver;}
    private WebDriver driver;
    //initialize all variables
    private By categoryElement = By.className("ef511_2c5_i");
    private By subCategory = By.xpath(".//a[contains(text(),'Macbooks')]");
    //categories are numbered, where 0 = All Categories and 7 = Wines
    int categoryNumber = 1;
    public SubCategoryPage clickCategoryAndSub() throws InterruptedException
    {
        //start a hover action
        Actions ac = new Actions(driver);
        //create a web element
        WebElement selectCategory = driver.findElements(categoryElement).get(categoryNumber);
        //hover on Computers and Accessories
        ac.moveToElement(selectCategory).perform();
        Thread.sleep(5000);
        //create a web element
        WebDriverWait wait = new WebDriverWait(driver, 200);
        //wait till macbook shows in the dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(subCategory));
        //click on macbooks
        driver.findElement(subCategory).click();
        Thread.sleep(10000);
        //go to subcategory page
        return new SubCategoryPage(driver);
    }
}
