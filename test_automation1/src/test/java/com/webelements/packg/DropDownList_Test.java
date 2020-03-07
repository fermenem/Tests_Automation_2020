package com.webelements.packg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class DropDownList_Test {

    private WebDriver driver;
    DropdownList_Page ddlPage;

    @Before
    public void setUp() throws Exception{

        ddlPage = new DropdownList_Page(driver);
        driver = ddlPage.chromeDriverConnection();
        driver.manage().window().maximize();

    }

    @Test

    public void testing_classic_DDL(){
        ddlPage.visit("");
        ddlPage.SingIn();

        assertEquals(ddlPage.selectDropdownList_Passengers(),"4 ");
        assertEquals(ddlPage.selectDropdownList_departingFrom(),"Paris");

    }

    @Test
    public void testing_react_DDL() throws InterruptedException{
        ddlPage.visit("https://react-bootstrap.github.io/components/dropdowns/");
        ddlPage.selectReactDropdownList();

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }


}
