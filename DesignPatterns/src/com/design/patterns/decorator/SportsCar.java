package com.design.patterns.decorator;

public class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(String serialNumber) {
        super.assemble(serialNumber);
        System.out.println("Adding sport motor");
    }

    @Override
    public void honk() {
        System.out.println("Sport cars do not honk!");
    }

}
