package com.techproed.smokeTest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {
    @Test
    public void positiveLoginTest(){
        //       http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");

        //      login butonuna bas
        driver.findElement(By.linkText("Log in")).click();

        //test data username: manager ,
        WebElement usernameTextBox = driver.findElement(By.id("UserName"));
        usernameTextBox.sendKeys("manager");

        //test data password : Manager2!
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("Manager2!"+ Keys.ENTER);

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        WebElement adduser=driver.findElement(By.xpath("//*[text()='Add User '] "));
        Assert.assertTrue(adduser.isDisplayed());
    }
}


