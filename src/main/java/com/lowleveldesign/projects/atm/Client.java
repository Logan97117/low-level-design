package com.lowleveldesign.projects.atm;

import com.lowleveldesign.projects.atm.concrete.ATM;
import com.lowleveldesign.projects.atm.concrete.BankType;
import com.lowleveldesign.projects.atm.concrete.Card;

public class Client {
    public static void main(String args[])throws Exception {
        //Card instances
        //For ID - 123
        Card cardA = new Card("65465464", "654", BankType.A);

        //For ID - 456
        Card cardB = new Card("546546467", "254", BankType.A);

        //ATM instance
        ATM atm = ATM.getInstance();

        //Check balance for ID-123
        atm.authenticate("123",cardA, "4128");
        atm.viewBalance();

        //Withdraw 100 from ID - 456 and check the balance again
        atm.startOver();
        atm.authenticate("456", cardB, "4120");
        atm.withDrawAmount(100);

        atm.startOver();
        atm.authenticate("456", cardB, "4120");
        atm.viewBalance();
    }
}
