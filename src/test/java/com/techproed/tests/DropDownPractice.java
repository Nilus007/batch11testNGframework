package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownPractice {
    /*
    1. “http://zero.webappsecurity.com/” Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password.” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. “amount” kutusuna bir sayi girin
    10. “US Dollars” in secilmedigini test edin
    11. “Selected currency” butonunu secin
    12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini control edin.
     */
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testAd(){
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();
        WebElement loginBox=driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username");

        WebElement passwordBox=driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");

        driver.findElement(By.name("submit")).click();

        driver.findElement(By.linkText("Pay Bills")).click();

        driver.findElement(By.xpath("//li[@class='ui-state-default ui-corner-top'][2]")).click();

        WebElement dropDown=driver.findElement(By.id("pc_currency"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");

        WebElement amountBox=driver.findElement(By.id("pc_amount"));
        amountBox.sendKeys("50");

        // 10. “US Dollars” in secilmedigini test edin
        String dropdownSeciliOpsiyon=select.getFirstSelectedOption().toString();
        Assert.assertFalse(dropdownSeciliOpsiyon.equals("US Dollars"));

        //WebElement radioButton=driver.findElement(By.id("pc_inDollars_false"));
        //radioButton.click();
       // Assert.assertFalse(radioButton.isSelected());

        // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        // 12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        WebElement finalText=driver.findElement(By.id("alert_content"));
        System.out.println(finalText.getText());

        Assert.assertEquals(finalText,"Foreign currency cash was successfully purchased.");
    }
    @AfterClass
    public void tearDown () {
        driver.close();
    }
}




