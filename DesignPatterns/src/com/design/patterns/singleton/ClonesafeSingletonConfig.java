package com.design.patterns.singleton;

import java.io.Serializable;

public class ClonesafeSingletonConfig implements Config, Serializable {

    private static volatile ClonesafeSingletonConfig config;

    public String configString;

    private ClonesafeSingletonConfig() {
        if (config != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static ClonesafeSingletonConfig getInstance() {
        // double check locking pattern
        if (config == null) {
            synchronized (ClonesafeSingletonConfig.class) {
                if (config == null) {
                    config = new ClonesafeSingletonConfig();
                }
            }
        }
        return config;
    }

    @Override
    public void print() {
        System.out.println(configString);

    }

    protected ClonesafeSingletonConfig readResolve() {
        return getInstance();
    }
}
