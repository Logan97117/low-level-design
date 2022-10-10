package com.lowleveldesign.projects.atm.concrete;

import com.lowleveldesign.projects.atm.interfaces.BankService;

public class ReadyState extends StateBase {
    public ReadyState(ATM atm) {
        super(atm);
    }

    @Override
    public void authenticate(String userId, Card card, String pin) {
        UserService userService = this.atm.getUserService();
        if(userService.validateUser(userId, card, pin)) {
            User user = userService.getUser(userId);
            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
            BankServiceFactory bankServiceFactory = this.atm.getBankServiceFactory();
            BankService bankService = bankServiceFactory.getBankService(card.getBankType());
            this.atm.setBankService(bankService);
            this.atm.setCurrentUser(user);
            this.atm.setState(new TransactionState(this.atm));
        }
        else {
            this.atm.setState(new ExitState(this.atm, "The pin or your user details you have entered is incorrect. Exiting."));
        }
    }

    @Override
    public int viewBalance() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void withdrawAmount(int amount) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void showExitMessages(String message) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void startOver() {
        throw new UnsupportedOperationException("Method not implemented");
    }
}
