package com.lowleveldesign.projects.vendingmachine;

public class SelectProduct extends State{
    public SelectProduct(VendingMachine vendingMachine) {
        super(vendingMachine);
        int newId = RandomIdGenerator.generateRandomId();
        this.vendingMachine.setTransactionId(newId);
    }

    @Override
    public void addCash(int amount) {
        TransactionManager transactionManager = this.vendingMachine.getTransactionManager();
        int transactionId = this.vendingMachine.getTransactionId();

        if(amount > 0)
            transactionManager.acceptAmount(transactionId, amount);
    }

    @Override
    public void requestProduct(String productCode) {
        int transactionId = this.vendingMachine.getTransactionId();
        ProductManager productManager = this.vendingMachine.getProductManager();
        TransactionManager transactionManager = this.vendingMachine.getTransactionManager();
        if(productManager.checkProductAvailable(productCode)) {
            int actualCost = productManager.getCost(productCode);
            int amountSubmitted = transactionManager.checkAmountSubmitted(transactionId);

            if(amountSubmitted >= actualCost) {
                System.out.println("Checking out the product");
                int change = transactionManager.returnChange(transactionId, actualCost);
                productManager.getProduct(productCode);
                System.out.println("Change returned: " + change);
                //transition to new SelectProduct state

                this.vendingMachine.setVendingMachineState(new SelectProduct(this.vendingMachine));
            }
            else {
                System.out.println("Amount not sufficient, please add more money to the vending machine");
            }
        }
        else System.out.println("This product is not available");
    }

    @Override
    public void cancelCurrentPurchase() {
        TransactionManager transactionManager = this.vendingMachine.getTransactionManager();
        int transactionId = this.vendingMachine.getTransactionId();
        transactionManager.refundAmount(transactionId);
        System.out.println("Amount refunded");

        //transition to new SelectProduct state
        this.vendingMachine.setVendingMachineState(new SelectProduct(this.vendingMachine));
    }
}
