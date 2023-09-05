package com.example.mydesignpattern.StructuralPattern.Adapter;

public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        return "Read from SD Card: hello";
    }

    @Override
    public void writeSD(String str) {
    System.out.println("Write to SD : "+str);
    }
}
