package com.example.mydesignpattern.StructuralPattern.Adapter;

/**
 * 电脑类，读取SDCard
 */
public class Computer {

    public String readSD(SDCard sdCard){

        return sdCard.readSD();
    }
}
