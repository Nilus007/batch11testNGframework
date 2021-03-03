package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ExampleKeyboard extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.click(aramakutusu)
        .sendKeys("Samsung")
        .keyDown(Keys.SHIFT)
        .sendKeys("a")
        .keyUp(Keys.SHIFT)
        .sendKeys("71")
        .sendKeys(Keys.ENTER)
                .perform();

    }

}
