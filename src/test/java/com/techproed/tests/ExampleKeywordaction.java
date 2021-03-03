package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ExampleKeywordaction extends TestBase {
    @Test
    public void test() {
        driver.get("https://www.facebook.com/");

        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("email"));

        actions.click(username)
                .sendKeys("mehmet")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
