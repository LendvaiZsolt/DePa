package com.design.patterns.decorator;

public class OffRoadCar extends CarDecorator {

    public OffRoadCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(String serialNumber) {
        super.assemble(serialNumber);
        System.out.println("Offroad felfüggesztéssel adjuk a SUV autót.");
    }

    @Override
    public void honk() {
        super.honk();
        System.out.println("Villogó első fényszórók.");
    }

}
