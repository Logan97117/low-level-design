package com.lowleveldesign.projects.vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class TransactionManager {
    private Map<Integer,Integer> map;
    public TransactionManager() {
        this.map = new HashMap<>();
    }

    public void acceptAmount(int transactionId, int amount) {
        this.map.put(transactionId, this.map.getOrDefault(transactionId,0) + amount);
    }

    public int returnChange(int transactionId, int actualAmount) {
        int amountSubmitted = this.map.get(transactionId);
        this.map.put(transactionId, actualAmount);
        return amountSubmitted - actualAmount;
    }

    public int refundAmount(int transactionId) {
        int amount = this.map.get(transactionId);
        this.map.remove(transactionId);
        return amount;
    }

    public int checkAmountSubmitted(int transactionId) {
        return this.map.getOrDefault(transactionId,0);
    }
}
