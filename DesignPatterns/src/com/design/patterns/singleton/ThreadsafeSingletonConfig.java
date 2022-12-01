package com.design.patterns.singleton;

public class ThreadsafeSingletonConfig implements Config {

    private static volatile ThreadsafeSingletonConfig config;

    public String configString;

    private ThreadsafeSingletonConfig() {
        if (config != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static ThreadsafeSingletonConfig getInstance() {
        // double check locking pattern
        if (config == null) {
            synchronized (ThreadsafeSingletonConfig.class) {
                if (config == null) {
                    config = new ThreadsafeSingletonConfig();
                }
            }
        }
        return config;
    }

    @Override
    public void print() {
        System.out.println(configString);

    }
}