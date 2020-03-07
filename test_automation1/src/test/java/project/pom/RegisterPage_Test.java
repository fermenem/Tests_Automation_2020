package project.pom;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class RegisterPage_Test {

    private WebDriver driver;
    RegisterPage registerPage;

    @Before
    public void SetUp(){
        registerPage = new RegisterPage(driver);
        driver = registerPage.chromeDriverConnection();
        registerPage.visit("http://newtours.demoaut.com/mercurywelcome.php");
    }

    @Test
    public void Test() throws InterruptedException {

        registerPage.RegisterUser();
        assertEquals("Note: Your user name is fermenem.",registerPage.registeredMessage()); // devuelve le texto del 5to elemento de la lista de elementos.

    }



    @After
    public void TearDown(){

        //driver.quit();

    }

}
