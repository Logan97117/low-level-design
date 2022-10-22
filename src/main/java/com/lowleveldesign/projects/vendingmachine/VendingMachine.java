package com.lowleveldesign.projects.vendingmachine;

import java.util.List;

public class VendingMachine {
    private ProductManager productManager;
    private TransactionManager transactionManager;
    private State vendingMachineState;
    private int transactionId;
    public VendingMachine(List<String> codes, List<Product> products, List<Integer> counts) {
        this.transactionManager = new TransactionManager();
        this.productManager = new ProductManager(codes, products, counts);
        this.vendingMachineState = new SelectProduct(this);
    }

    public void addCash(int amount) {
        this.vendingMachineState.addCash(amount);
    }

    public void requestProduct(String code) {
        this.vendingMachineState.requestProduct(code);
    }

    public void cancelPurchase() {
        this.vendingMachineState.cancelCurrentPurchase();
    }

    public ProductManager getProductManager() {
        return this.productManager;
    }

    public TransactionManager getTransactionManager() {
        return this.transactionManager;
    }

    public void setVendingMachineState(State state) {
        this.vendingMachineState = state;
    }

    public void setTransactionId(int id) {
        this.transactionId = id;
    }

    public int getTransactionId() {
        return this.transactionId;
    }
}
