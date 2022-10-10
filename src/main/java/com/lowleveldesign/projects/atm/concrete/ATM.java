package com.lowleveldesign.projects.atm.concrete;

import com.lowleveldesign.projects.atm.interfaces.BankService;
import com.lowleveldesign.projects.atm.interfaces.State;

public class ATM {
    private State currentState;
    private static ATM instance;
    private UserService userService;
    private BankService bankService;
    private BankServiceFactory bankServiceFactory;
    private User currentUser;
    private ATM() {
        //init user service, current state
        this.userService = new UserService();
        this.bankServiceFactory = new BankServiceFactory();
        this.currentState = new ReadyState(this);
    }

    public static ATM getInstance() {
        if(ATM.instance == null) {
            synchronized(ATM.class) {
                ATM.instance = new ATM();
            }
        }
        return ATM.instance;
    }
    public UserService getUserService() {
        return this.userService;
    }
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }
    public BankService getBankService() {
        return this.bankService;
    }
    public BankServiceFactory getBankServiceFactory() {
        return this.bankServiceFactory;
    }
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    public User getCurrentUser() {
        return this.currentUser;
    }
    public void setState(State newState) {
        this.currentState = newState;
    }
    public void authenticate(String userId, Card card, String pinInfo) {
        this.currentState.authenticate(userId, card, pinInfo);
    }
    public void viewBalance() {
        this.currentState.viewBalance();
    }
    public void withDrawAmount(int amount) {
        this.currentState.withdrawAmount(amount);
    }
    public void startOver() {
        this.currentState.startOver();
    }
}
