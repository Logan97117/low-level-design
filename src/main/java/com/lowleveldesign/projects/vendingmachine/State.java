package com.lowleveldesign.projects.vendingmachine;

public abstract class State {
    protected VendingMachine vendingMachine;
    public State(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void showProducts() {
        ProductManager productManager = this.vendingMachine.getProductManager();
        productManager.showAllProducts();
    }

    public abstract void addCash(int amount);
    public abstract void requestProduct(String productCode);
    public abstract void cancelCurrentPurchase();
}
