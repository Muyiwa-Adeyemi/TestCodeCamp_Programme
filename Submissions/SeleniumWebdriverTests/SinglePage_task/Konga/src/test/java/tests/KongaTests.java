package tests;

import org.testng.annotations.Test;
import pageObjects.CheckoutPage;
import pageObjects.SubCategoryPage;
import setup.SetupTests;

public class KongaTests extends SetupTests {
    @Test
    public void KongaTest() throws InterruptedException
    {
        try
        {
            //enter username
            loginPage.enterUsername("muyiwadeyemi@gmail.com");
            //enter password
            loginPage.enterPassword("Dummypass17");
            //click on log in button
            homePage = loginPage.clickLoginBtn();
            Thread.sleep(5000);
            //navigate to subcategory page
            SubCategoryPage subCategoryPage = homePage.clickCategoryAndSub();
            //click on add to cart button
            subCategoryPage.clickAddToCart();
            //click on my cart button
            subCategoryPage.clickMyCart();
            //navigate to checkout page
            CheckoutPage checkoutPage = subCategoryPage.clickCheckout();
            //click on pickup location
            checkoutPage.clickPickUpLocation();
            //click on choose pickup location
            checkoutPage.clickChooseLocation();
            //click on use this location
            checkoutPage.clickConfirmLocation();
            //click on pay now button
            checkoutPage.clickPayNow();
            //click to continue to preferred payment method
            checkoutPage.clickContinueToPayment();
            //click on card
            checkoutPage.clickPaymentType();
            //enter card details
            checkoutPage.enterCardDetails("4117365950919091", "11/22", "322");
            //click on pay now
            checkoutPage.clickFinalPayNow();
            //print error message
            System.out.println(checkoutPage.invalidMessage());
            //close modal
            checkoutPage.closeModal();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
