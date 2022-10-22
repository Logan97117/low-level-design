package com.lowleveldesign.projects.vendingmachine;

public class Product {
    private String productId;
    private String productName;
    private int productCost;

    public Product(String productId, String productName, int productCost) {
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCost() {
        return productCost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productCost=" + productCost +
                '}';
    }
}
