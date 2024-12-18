package com.smartInventory.service;
import com.smartInventory.Model.Product;
import java.util.*;

// here in the inventory we will manage the products
// Actions that will be performed in this
// Add a product
// Update a product
// Remove a product
// Check for Stock Shortage

public class Inventory {

    private HashMap<String, Product> products;

    // Contructor
    public Inventory(){
        products = new HashMap<>();
    }


    /*
    Add Products to the inventory
     */

    public boolean addProduct(Product product){
        if (products.containsKey(product.getProductId())){
            return false;
        }
        products.put(product.getProductId(), product);
        return true;
    }

    /*
    Remove Product from Inventory
     */

    public boolean removeProduct(String productId){
        if (!products.containsKey(productId)){
            return false;
        }
        products.remove(productId);
        return true;
    }

    public HashMap<String, Product> getAllProducts() {
        return products;
    }

    // Get all the products below threshold

    public HashMap<String, Product> getProductsBelowThreshold() {
        // Creating a map which will store the products that are low on stock
        HashMap<String ,Product> lowOnStockProducts = new HashMap<>();

        for(Map.Entry<String, Product> entry: products.entrySet()){
            Product product = entry.getValue();

            if(product.isBelowThreshold()){
                lowOnStockProducts.put(entry.getKey(), product);
            }
        }

        return lowOnStockProducts;
    }

}
