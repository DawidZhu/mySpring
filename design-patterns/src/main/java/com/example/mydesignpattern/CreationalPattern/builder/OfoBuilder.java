package com.example.mydesignpattern.CreationalPattern.builder;

/**
 * 具体的建造者 builder
 * implementation classes
 */
public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("OfoFrame");
    }

    @Override
    public void buildSeat() {
    bike.setSeat("Ofo seat");
    }

    @Override
    public Bike creatBike() {
        return bike;
    }
}
