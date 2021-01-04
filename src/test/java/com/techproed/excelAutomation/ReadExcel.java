package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        String path = "./src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);

        System.out.println(cell);
        String hucre = cell.toString();
        System.out.println(hucre);
    }

    @Test
    public void readExcel2() throws IOException {
        String path = "./src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        workbook.getSheetAt(0).getRow(0).getCell(1);


        System.out.println(workbook.getSheetAt(0).getRow(0).getCell(1));
       String birinciSatırikinciHucre=workbook.getSheetAt(0).getRow(0).getCell(1).toString();
        System.out.println(birinciSatırikinciHucre);

        String ikincisatırdorduncuhucre=workbook.getSheetAt(0).getRow(1).getCell(3).toString().toLowerCase(Locale.ROOT);
        Assert.assertEquals(ikincisatırdorduncuhucre,"kabil");

        System.out.println(workbook.getSheetAt(0).getLastRowNum());

    }
}