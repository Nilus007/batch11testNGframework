package com.techproed.tests;

import org.testng.annotations.Test;

import java.awt.*;

public class Example01 {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        String anapath=System.getProperty("user.home");

        String masaUstu=anapath + " \\Desktop";

        System.out.println("desktop yolu: "+ masaUstu);
    }
}
