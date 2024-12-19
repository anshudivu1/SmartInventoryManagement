package com.smartInventory.ui;
import java.util.*;
import com.smartInventory.Model.Product;
import com.smartInventory.service.Inventory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Smart Inventory management System Initialized");
        Scanner in = new Scanner(System.in);

        Inventory inventory = new Inventory();

        while (true) {

            System.out.println("Smart Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Remove Product");
            System.out.println("4. Check products low on scope");
            System.out.println("5. Exit");

            System.out.println("Enter Your Choice");
            int choice = in.nextInt();
            in.nextLine();


            switch (choice) {
                case 1:
                    // Case 1 is created to perform number 1 action
                    System.out.println("Enter product ID ");
                    String Id = in.nextLine();
                    System.out.println("Enter product name ");
                    String name = in.nextLine();
                    System.out.println("Enter Product Quanity ");
                    int quantity = in.nextInt();
                    System.out.println("Enter Product Threshold ");
                    int threshold = in.nextInt();
                    in.nextLine();

                    Product newProduct = new Product(Id, name, quantity, threshold);
                    if(inventory.addProduct(newProduct)){
                        System.out.println("Product Added Successfully");
                    }else {
                        System.out.println("Product Already Exists");
                    }

                    break;

                case 2:
                    System.out.println("/n All Products");
                    inventory.getAllProducts().forEach((id, product) -> System.out.println(product));
                    break;

                case 3:
                    System.out.println("Enter Id of product to remove");
                    String removeId = in.nextLine();
                    if (inventory.removeProduct(removeId)){
                        System.out.println("Product removed successfully");
                    }else {
                        System.out.println("Product Id not found");
                    }
                    break;

                case 4:
                    System.out.println("Products below threshold");
                    inventory.getProductsBelowThreshold().forEach((id, product)-> System.out.println(id + " " + product.getName()));
                    break;


                case 5:
                    System.out.println("Exiting.....");
                    in.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");

            }

        }

    }
}