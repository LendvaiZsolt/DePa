package com.design.patterns.strategy;

import java.util.Random;

public class PaypalStrategy implements PaymentStrategy {

    private String email;
    private String password;

    public PaypalStrategy(String email, String pwd) {
        this.email = email;
        this.password = pwd;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (isAuthenticated()) {
            System.out.println("Payment of " + paymentAmount + " euro is completed by PayPal");
            return true;
        }
        return false;
    }

    private boolean isAuthenticated() {
        String response = sendAuthenticationRequest(this.email, this.password);
        System.out.println("Checking authentication response...");
        if (response.equals("true")) {
            System.out.println("Authenticated");
            return true;
        }
        System.out.println("Failed authentication");
        return false;
    }

    private String sendAuthenticationRequest(String email, String password) {
        System.out.println("Sending authentication request...");
        Random r = new Random();
        if (r.nextInt(10) % 2 == 0) {
            return "true";
        }
        return "false";
    }

}
