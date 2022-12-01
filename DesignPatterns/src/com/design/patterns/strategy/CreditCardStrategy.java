package com.design.patterns.strategy;

import java.util.Random;

public class CreditCardStrategy implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String name, String ccNum, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (isValidCreditCard(this.name, this.cardNumber, this.cvv, this.dateOfExpiry)) {
            System.out.println("Payment of " + paymentAmount + " euro is completed by credit card");
            return true;
        }
        return false;
    }

    private boolean isValidCreditCard(String name, String cardNumber, String cvv, String dateOfExpiry) {
        System.out.println("Validating credit card details...");
        Random r = new Random();
        if (r.nextInt(10) % 2 == 0) {
            System.out.println("Card details are valid");
            return true;
        }
        System.out.println("Card details are invalid");
        return false;
    }

}
