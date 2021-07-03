package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage {
    public SubCategoryPage(WebDriver driver) {this.driver = driver;}
    private WebDriver driver;
    //initialize all variables
    private By addToCart = By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/section/section/section/ul/li[2]/div/div/div[2]/form/div[4]/button");
    private By myCart = By.xpath("//section[@id='app-content-wrapper']/div[2]/nav/div[2]/div/div/a[2]/span");
    private By checkout = By.xpath("//section[@id='app-content-wrapper']/div[3]/section/section/aside/div[3]/div/div[2]/button");
    public void clickAddToCart() throws InterruptedException
    {
        //click to add a macbook to cart
        driver.findElement(addToCart).click();
        Thread.sleep(5000);
    }
    public void clickMyCart() throws InterruptedException
    {
        //click on my cart button
        driver.findElement(myCart).click();
        Thread.sleep(5000);
    }
    public CheckoutPage clickCheckout() throws InterruptedException
    {
        //click on checkout button
        driver.findElement(checkout).click();
        return new CheckoutPage(driver);
    }
}
