package com.webelements.packg;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import project.pom.Base;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

public class DropdownList_Page extends Base {

    // Pagina de DemoTours automation.
    By dropdownList_Passengers = By.name("passCount");
    By dropdownList_DepartingFrom = By.name("fromPort"); // Se hace 2do click sobre el elemento y voy a "Inspeccionar".

    By user_locator = By.name("userName");
    By pass_locator = By.name("password");
    By loginBtn_locator = By.name("login");
    By homePage_locator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

    //
    By dropdownListButton = By.id("dropdown-basic");
    By options2 = By.cssSelector("div[aria-labelledby='dropdown-basic']>a[href='#/action-2'");


    public DropdownList_Page(WebDriver driver) {
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


    //Camino largo
    public String selectDropdownList_Passengers(){
        WebElement dropdownList = findElement(dropdownList_Passengers);

        List<WebElement> options = dropdownList.findElements(By.tagName("option"));

        for (int i = 0; i < options.size() ; i++) {

            if (getText(options.get(i)).equals("4 ")){

                Click(options.get(i));
            }

        }

        String selectedOption = "";
        for (int i = 0; i <options.size() ; i++) {

            if(options.get(i).isSelected()){
                selectedOption = getText(options.get(i));
            }
        }
    return selectedOption;
    }


    public String selectDropdownList_departingFrom(){

        Select selectList = new Select(findElement(dropdownList_DepartingFrom));
        selectList.selectByVisibleText("Paris"); // lugar de donde queremos comenzar
        return getText(selectList.getFirstSelectedOption());
    }


    public void selectReactDropdownList() throws InterruptedException { //lo que voy a comparar en Test van a ser las URL
        Click(dropdownListButton);
        Thread.sleep(3000);
        Click(options2);
    }
}
