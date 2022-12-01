package com.design.patterns.singleton;

import java.io.Serializable;

public class SerializationsafeSingletonConfig implements Config, Serializable {

    private static volatile SerializationsafeSingletonConfig config;

    public String configString;

    private SerializationsafeSingletonConfig() {
        if (config != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SerializationsafeSingletonConfig getInstance() {
        // double check locking pattern
        if (config == null) {
            synchronized (SerializationsafeSingletonConfig.class) {
                if (config == null) {
                    config = new SerializationsafeSingletonConfig();
                }
            }
        }
        return config;
    }

    @Override
    public void print() {
        System.out.println(configString);

    }

    protected SerializationsafeSingletonConfig readResolve() {
        return getInstance();
    }
}
