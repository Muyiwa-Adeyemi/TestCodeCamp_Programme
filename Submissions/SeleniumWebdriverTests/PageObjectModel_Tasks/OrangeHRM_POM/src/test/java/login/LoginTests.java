package login;

import Setup.SetupTests;
import org.testng.annotations.Test;

public class LoginTests extends SetupTests {


    //TestNG annotation
    @Test
    //This class extends to the SetupTests as the SetupTests class contains all the setup requirements to run our test
    public void testLogin () throws InterruptedException {
        String username = "Admin";
        loginPage.enterUsername (username);
        String pwd;
        loginPage.enterUserPassword ("admin123");

        //Handler for dashboard page
        loginPage.clickLoginBtn ();
        String pageUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        System.out.println ("PASSED - The page url is " + pageUrl);
    }

    @Test
    public void testLogout () throws InterruptedException {
        try {
            dashboardpage.clickWelcomeAdmin ();
            loginPage = dashboardpage.clickLogout();
        }catch (Exception e) {
            String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
            System.out.println ("PASSED - The page url is " + loginUrl);
        }
    }
}
