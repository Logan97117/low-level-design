package com.lowleveldesign.projects.atm.concrete;

public class Card {
    private String cardNumber;
    private String ccv;
    private BankType bankType;

    public Card(String cardNumber, String ccv, BankType bankType) {
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.bankType = bankType;
    }

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
}
