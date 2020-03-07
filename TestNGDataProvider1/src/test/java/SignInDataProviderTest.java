import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

public class SignInDataProviderTest extends SignInDataProvider {

    WebDriver driver;
    By signInLocator= By.linkText("Sign in");
    By emailLocator= By.id("email");

    By passwordLocator = By.id("passwd");
    By signInButtonLocator = By.id("SubmitLogin");

    By signOutButtonLocator = By.cssSelector("a.logout");

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

    }

    @Test(dataProvider="authenticationData")

    public void login(String email, String pass) {

        if (driver.findElement(signInLocator).isDisplayed()) {
            driver.findElement(signInLocator).click();

            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));

            driver.findElement(emailLocator).sendKeys(email);
            driver.findElement(passwordLocator).sendKeys(pass);
            driver.findElement(signInButtonLocator).click();

            assertEquals(driver.findElement(signOutButtonLocator).getText(),"Sign out");

            driver.findElement(signOutButtonLocator).click();
        } else{
            System.out.println("Sign in Link no está presente");
        }
    }

    @DataProvider(name = "authenticationData")
    public Object[][] getData(){

        Object[][] matriz = new Object[2][2];// matriz con dos arreglos de dimension 2. Cada arreglo parte de la posicion 0.

        matriz[0][0]="fermenem@hotmail.com";
        matriz[0][1]="123456";
        matriz[1][0]="rfc@cba.gov.ar";
        matriz[1][1]="123521";

        return matriz;
    }



    @AfterMethod
    public void tearDown() {

        //driver.quit();
    }
}