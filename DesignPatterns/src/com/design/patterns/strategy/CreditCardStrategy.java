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
            System.out.println("a kifizetés " + paymentAmount + " euro teljesült hitelkártyával.");
            return true;
        }
        return false;
    }

    private boolean isValidCreditCard(String name, String cardNumber, String cvv, String dateOfExpiry) {
        System.out.println("Hitelkártya datok érvényesítése folyamatban...");
        Random r = new Random();
        if (r.nextInt(10) % 2 == 0) {
            System.out.println("A kártya adatok érvényesek");
            return true;
        }
        System.out.println("Érvénytelen kártya.");
        return false;
    }

}
