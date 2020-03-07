package waits;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class GoogleSearchTest {


    private WebDriver driver;

    By LinkLocator = By.cssSelector("a[href='https://es.slideshare.net/micaelgallego/introduccin-a-las-pruebas-software']");

    @Before
    public void SetUp() throws Exception{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

    }

    @Test
    public void Test(){

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys(" Introduccion a las pruebas de software");

        searchBox.submit();

        //implicit wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //assertEquals("Introduccion a las pruebas de software - Buscar con Google",driver.getTitle());


        //explicit wait
        //WebDriverWait ewait = new WebDriverWait(driver,10);
        //ewait.until(ExpectedConditions.titleContains("Introduccion"));
        //assertEquals("Introduccion a las pruebas de software - Buscar con Google",driver.getTitle());

                         // --------- |     |   --------
        //Fluent Wait se utilizan en llamadas asincronas. Es una clase que hereda de Wait.

        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(10,TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement link = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(LinkLocator);
            }
        });

        assertTrue(driver.findElement(LinkLocator).isDisplayed());

     }

    @After
    public void TearDown(){
        //driver.quit();
    }
}
