package com.smartInventory.Model;
// Here I am defining the Product class that shows or describes  my product
// This is the definition of the Product that we will manage in the Inventory
public class Product {

    private String productId;
    private String name;
    private int quantity;
    private int threshold; // This is the minimum quantity before a stock is triggered

    public Product(String productId, String name, int quantity, int threshold){
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public boolean isBelowThreshold(){
        return quantity < threshold;
    }


    @Override
    public String toString(){
        return "Product ID:" + productId +
                ", Product Name:" + name +
                ", Product Quantity:" + quantity
                + ", Threshold" + threshold;
    }

}
