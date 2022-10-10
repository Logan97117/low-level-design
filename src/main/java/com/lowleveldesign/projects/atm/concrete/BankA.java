package com.lowleveldesign.projects.atm.concrete;

import com.lowleveldesign.projects.atm.interfaces.BankService;

import java.util.HashMap;
import java.util.Map;

public class BankA implements BankService {
    private Map<String,Integer> balances;
    public BankA() {
        this.balances = new HashMap<>();
        this.initBank();
    }

    private void initBank() {
        //Db client connection
        //we will use in memory DB
        this.balances.put("123", 1000);
        this.balances.put("456", 6544);
        this.balances.put("789", 8465);
    }

    @Override
    public int showBalance(String userId) {
        return this.balances.get(userId);
    }

    @Override
    public boolean requestAmount(String userId, int amount) {
        if(this.balances.get(userId) < amount) {
            System.out.println("Transaction cannot be completed as you have insufficient balance");
            return false;
        }

        System.out.println("Transaction successfull !");
        this.balances.put(userId, this.balances.get(userId) - amount);
        return true;
    }
}
