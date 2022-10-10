package com.lowleveldesign.projects.atm.concrete;

public class ExitState extends StateBase{
    public ExitState(ATM atm, String message) {
        super(atm);
        this.showExitMessages(message);
    }

    @Override
    public void authenticate(String userId, Card card, String pin) {
        throw new UnsupportedOperationException("Method not implemented");
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
        System.out.println(message);
    }

    @Override
    public void startOver() {
        //Transition to ready state
        System.out.println("Moving to authentication section again");
        this.atm.setState(new ReadyState(this.atm));
    }
}
