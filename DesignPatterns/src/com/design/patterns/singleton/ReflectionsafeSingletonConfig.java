package com.design.patterns.singleton;

public class ReflectionsafeSingletonConfig implements Config {

    private static volatile ReflectionsafeSingletonConfig config;

    public String configString;

    private ReflectionsafeSingletonConfig() {

        // prevent creating a new instance with reflection api
        if (config != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static ReflectionsafeSingletonConfig getInstance() {
        if (config == null) {
            config = new ReflectionsafeSingletonConfig();
        }
        return config;
    }

    @Override
    public void print() {
        System.out.println(configString);

    }

}
