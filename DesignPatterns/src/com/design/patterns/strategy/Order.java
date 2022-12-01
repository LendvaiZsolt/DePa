package com.design.patterns.strategy;

public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    public void addCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }

    public boolean pay(PaymentStrategy paymentMethod) {
        if (isClosed()) {
            return paymentMethod.pay(totalCost);
        }
        return false;
    }
}
