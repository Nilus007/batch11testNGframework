package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example extends TestBase {
    @Test
    public void testAmazon() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        WebElement beklegor = driver.findElement(By.id("nav-link-accountList"));

        actions.moveToElement(beklegor).perform();
        Thread.sleep(5000);
        WebElement Clist=driver.findElement(By.linkText("Create a List"));
        actions.click(Clist).perform();
        WebElement listyazielementi=driver.findElement(By.linkText("Your Lists"));
        Assert.assertEquals(listyazielementi.getText(),"Your Lists");
    }
}
