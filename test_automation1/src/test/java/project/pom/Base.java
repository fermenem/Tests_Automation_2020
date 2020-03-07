package project.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.List;

//Clase Base utilizada para redefinir de cierto modo al framework. Esta diseñada para desacoplar todos aquellos cambios que se presenten en el framework de manera tal
// de que no impacten en los "TESTS".

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {

        this.driver = driver;

    }

    public WebDriver chromeDriverConnection(){
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void Click(By locator){
        driver.findElement(locator).click();
    }

    public void Click(WebElement element){
        element.click();
    }

    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed(); //True
        }
        catch ( org.openqa.selenium.NoSuchContextException e)
        {
            return false;
        }
    }

    public void visit(String url){
        driver.get(url);
    }


}
