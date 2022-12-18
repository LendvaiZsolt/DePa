package com.design.patterns.decorator;

public class SimpleCar implements Car {

    private String serialNumber;

    @Override
    public void assemble(String serialNumber) {
        this.serialNumber = serialNumber;
        System.out.println("Egyszerű matchbox kisautó összeszerelve! Gyári száma: " + this.serialNumber);
    }

    @Override
    public void honk() {
        System.out.println("Egyszerű duda");
    }

}
