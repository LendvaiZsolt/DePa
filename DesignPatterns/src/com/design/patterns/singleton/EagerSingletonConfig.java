package com.design.patterns.singleton;

public class EagerSingletonConfig implements Config {

    // private field for the single object
    private static volatile EagerSingletonConfig config = new EagerSingletonConfig();

    public String configString;

    // private constructor
    private EagerSingletonConfig() {
        configString = "This is the config";
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
