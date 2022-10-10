package com.lowleveldesign.projects.atm.interfaces;

public interface BankService {
    public int showBalance(String userId);
    public boolean requestAmount(String userId, int amount);
}
