package com.lowleveldesign.projects.vendingmachine;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args)throws Exception {
        List<String> codes = Arrays.asList("A", "B", "C");
        List<Product> products = Arrays.asList(new Product("A", "First product", 20), new Product("B", "Second product", 50),  new Product("C", "Third product", 85));
        List<Integer> counts = Arrays.asList(2,1,3);

        VendingMachine vendingMachine = new VendingMachine(codes, products, counts);
        vendingMachine.addCash(10);
        vendingMachine.requestProduct("A");
        vendingMachine.addCash(10);
        vendingMachine.requestProduct("A");

        vendingMachine.addCash(85);
        vendingMachine.requestProduct("C");
    }
}
