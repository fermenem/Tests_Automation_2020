package project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage  extends Base{
    By user_locator = By.name("userName");
    By pass_locator = By.name("password");
    By loginBtn_locator = By.name("login");
    By homePage_locator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }


    public void SingIn(){
        if (isDisplayed(user_locator)){
            type("fermenem",user_locator);
            type("123456",pass_locator);
            Click(loginBtn_locator);
        } else{
            System.out.println("This Page was not found correctly");
        }
    }

    public boolean isHomePageDisplayed(){

        return isDisplayed(homePage_locator);
    }
}
