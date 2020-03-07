package project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;
import java.util.List;

public class RegisterPage extends Base{


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By link_byname = By.linkText("REGISTER");
    By registerPage_locator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
    By usernameID_locator= By.id("email");
    By passwordName_locator = By.name("password");
    By confirmPass_locator = By.cssSelector("input[name='confirmPassword']");
    By btnRegister_locator = By.name("register");
    By registeredMessage = By.tagName("font");


    public void RegisterUser() throws InterruptedException {
        Click(link_byname);
        Thread.sleep(2000);
        if (isDisplayed(registerPage_locator)){
            type("fermenem",usernameID_locator);
            type("123456",passwordName_locator);
            type("123456",confirmPass_locator);

            Click(btnRegister_locator);
        }
        else
        {
            System.out.println("Register page was not found");
        }

    }

    public String registeredMessage(){
        List<WebElement> fonts = findElements(registeredMessage);
        return getText(fonts.get(5));
    }

}
