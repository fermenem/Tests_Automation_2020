package project.pom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;





public class SignIn_Test {

    WebDriver driver;
    SignInPage signInPage;

    @Before
    public void SetUp(){
        signInPage = new SignInPage(driver);
        driver = signInPage.chromeDriverConnection();
        signInPage.visit("http://newtours.demoaut.com/mercurywelcome.php");
    }


    @Test

    public void Test() throws InterruptedException {

        signInPage.SingIn();
        Thread.sleep(2000);
        assertTrue(signInPage.isHomePageDisplayed());
    }

    @After
    public void TearDown(){
        //driver.quit();
    }

}
