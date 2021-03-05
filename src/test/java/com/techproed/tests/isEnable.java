package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class isEnable extends TestBase {
    @Test
    public void isEnableTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement enablebutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
        enablebutton.click();

        WebElement mesagetext = driver.findElement(By.id("message"));
        Assert.assertTrue(mesagetext.getText().contains("It's enabled!"));
    }
}
