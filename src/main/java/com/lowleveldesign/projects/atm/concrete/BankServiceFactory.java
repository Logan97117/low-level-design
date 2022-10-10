package com.lowleveldesign.projects.atm.concrete;

import com.lowleveldesign.projects.atm.interfaces.BankService;

import java.util.HashMap;
import java.util.Map;

public class BankServiceFactory {
    private Map<BankType, BankService> banksCache;
    public BankServiceFactory() {
        this.banksCache = new HashMap<>();
        this.banksCache.put(BankType.A, new BankA());
    }
    public BankService getBankService(BankType bankType) {
        return this.banksCache.get(bankType);
    }
}
