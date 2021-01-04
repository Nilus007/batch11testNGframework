package com.techproed.tests;

import com.techproed.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D15_UploadFile extends TestBase {
   /*
1.Tests packagenin altina bir class oluşturun : D14_UploadFile
2.https://the-internet.herokuapp.com/upload adresine gidelim
3.chooseFile butonuna basalim
4. Yuklemek istediginiz dosyayi secelim.
5. Upload butonuna basalim.
6. “File Uploaded!” textinin goruntulendigini test edelim.
    */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        // dosya sec butonunu locate edin ve masaustundeki FLOWER.jpg dosyasinin yolunu olusturun
        WebElement dosyaSecButonu = driver.findElement(By.id("file-upload"));

        String homePath = System.getProperty("user.home");
        String filePath = homePath + "\\Desktop\\FLOWER.jpg";

        dosyaSecButonu.sendKeys(filePath);

        WebElement upLoadButonu = driver.findElement(By.id("file-submit"));
        upLoadButonu.click();

        Thread.sleep(5000);

        WebElement sonucYaziElementi = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(sonucYaziElementi.getText(), "File Uploaded!");
    }
}
