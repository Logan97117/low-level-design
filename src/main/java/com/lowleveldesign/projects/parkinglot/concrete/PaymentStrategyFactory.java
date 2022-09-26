package com.lowleveldesign.projects.parkinglot.concrete;

import com.lowleveldesign.projects.parkinglot.enums.PaymentStrategyType;
import com.lowleveldesign.projects.parkinglot.interfaces.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyFactory {
    private Map<PaymentStrategyType, PaymentStrategy> paymentStrategyCache;
    public PaymentStrategyFactory() {
        this.paymentStrategyCache = new HashMap<>();
        this.paymentStrategyCache.put(PaymentStrategyType.CREDIT_CARD, new CreditCardPayment());
        this.paymentStrategyCache.put(PaymentStrategyType.PAYPAL, new PaypalPayment());
    }

    public void addNewPaymentStrategy(PaymentStrategyType paymentStrategyType, PaymentStrategy paymentStrategy) {
        this.paymentStrategyCache.put(paymentStrategyType, paymentStrategy);
    }

    public PaymentStrategy getPaymentStrategy(PaymentStrategyType paymentStrategyType) {
        return this.paymentStrategyCache.get(paymentStrategyType);
    }
}
