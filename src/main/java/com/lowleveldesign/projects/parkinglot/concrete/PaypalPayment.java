package com.lowleveldesign.projects.parkinglot.concrete;


import com.lowleveldesign.projects.parkinglot.interfaces.PaymentStrategy;

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        //Actual code for processing payment through PayPal
        System.out.println("Payment process through paypal for amount: " + amount);
    }
}
