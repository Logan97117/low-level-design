package com.lowleveldesign.projects.atm.concrete;

import com.lowleveldesign.projects.atm.interfaces.BankService;

public class TransactionState extends StateBase{
    public TransactionState(ATM atm) {
        super(atm);
    }

    @Override
    public void authenticate(String userId, Card card, String pin) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public int viewBalance() {
        User currentUser = this.atm.getCurrentUser();
        BankService bankService = this.atm.getBankService();
        int currBalance = bankService.showBalance(currentUser.getUserId());
        System.out.println("Current balance: " + bankService.showBalance(currentUser.getUserId()));
        this.atm.setBankService(null);
        this.atm.setCurrentUser(null);
        this.atm.setState(new ExitState(this.atm, "Thank you !"));
        return currBalance;
    }

    @Override
    public void withdrawAmount(int amount) {
        User currentUser = this.atm.getCurrentUser();
        BankService bankService = this.atm.getBankService();
        bankService.requestAmount(currentUser.getUserId(), amount);
        this.atm.setBankService(null);
        this.atm.setCurrentUser(null);
        this.atm.setState(new ExitState(this.atm, "Thank you !"));
    }

    @Override
    public void showExitMessages(String message) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void startOver() {
        throw new UnsupportedOperationException("Operation not supported");
    }
}
