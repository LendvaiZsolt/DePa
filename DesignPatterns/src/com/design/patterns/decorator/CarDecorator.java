package com.design.patterns.decorator;

public class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c) {
        car = c;
    }

    @Override
    public void assemble(String serialNumber) {
        car.assemble(serialNumber);
    }

    @Override
    public void honk() {
        car.honk();
    }

}
