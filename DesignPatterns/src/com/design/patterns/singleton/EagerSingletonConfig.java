package com.design.patterns.singleton;

public class EagerSingletonConfig implements Config {

    // private field for the single object
    private static volatile EagerSingletonConfig config = new EagerSingletonConfig();

    public String configString;

    // private constructor
    private EagerSingletonConfig() {
        configString = "Kosár0001";
        //ide egy futó sorszámot is tehetnénk, a config értéke akkor sem változna a kód futása során, mert a példány azonnal létrejön és static;
    }

    // method for accessing the single object
    public static EagerSingletonConfig getInstance() {
        return config;
    }

    @Override
    public void print() {
        System.out.println(configString);
    }
}
