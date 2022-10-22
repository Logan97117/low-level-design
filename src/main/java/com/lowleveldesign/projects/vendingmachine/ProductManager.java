package com.lowleveldesign.projects.vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {
    private Map<String,Integer> productCounts;
    private Map<String,Product> products;

    public ProductManager(List<String> codes, List<Product> products, List<Integer> counts) {
        this.productCounts = new HashMap<>();
        this.products = new HashMap<>();

        for(int i = 0; i<codes.size(); i++) {
            this.productCounts.put(codes.get(i), counts.get(i));
            this.products.put(codes.get(i), products.get(i));
        }
    }

    public boolean checkProductAvailable(String code) {
        return this.products.containsKey(code) && this.productCounts.get(code) > 0;
    }

    public void getProduct(String code) {
        this.productCounts.put(code, this.productCounts.get(code) - 1);
    }

    public void showAllProducts() {
        for(String key: this.products.keySet()) {
            System.out.println(key);
            System.out.println(this.products.get(key).toString());
            System.out.println("In stock: " + this.productCounts.get(key));
        }
    }

    public int getCost(String code) {
        return this.products.get(code).getProductCost();
    }
}
