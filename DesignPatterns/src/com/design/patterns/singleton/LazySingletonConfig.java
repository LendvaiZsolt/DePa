package com.design.patterns.singleton;

public class LazySingletonConfig implements Config {

    private static volatile LazySingletonConfig config;

    public String configString;

    private LazySingletonConfig() {
        configString = "This is the config";
    }

    public static LazySingletonConfig getInstance() {
        // creating the instance only when it is first accessed
        if (config == null) {
            config = new LazySingletonConfig();
        }
        return config;
    }

    @Override
    public void print() {
        System.out.println(configString);
    }

}
