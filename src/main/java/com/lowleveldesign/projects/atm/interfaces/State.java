package com.lowleveldesign.projects.atm.interfaces;

import com.lowleveldesign.projects.atm.concrete.Card;
import com.lowleveldesign.projects.atm.concrete.User;

public interface State {
    public void authenticate(String userId, Card card, String pin);
    public int viewBalance();
    public void withdrawAmount(int amount);
    public void showExitMessages(String message);
    public void startOver();
}
