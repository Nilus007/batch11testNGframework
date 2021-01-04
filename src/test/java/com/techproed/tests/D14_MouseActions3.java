package com.techproed.tests;

import com.techproed.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class D14_MouseActions3 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");

        WebElement bekleGor = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bekleGor).perform();

        WebElement list = driver.findElement(By.linkText("Create a List"));
        actions.click(list).perform();

        WebElement listYaziElementi = driver.findElement(By.linkText("Your Lists"));
        Assert.assertEquals(listYaziElementi.getText(), "Your Lists");
        Thread.sleep(5000);
    }

}