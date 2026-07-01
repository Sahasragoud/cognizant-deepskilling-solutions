package com.inventoryManagement.system;

import java.util.HashMap;

public class Inventory {

    private HashMap<Integer, Product> products = new HashMap<>();

    // Add Product
    public void addProduct(Product product) {

        if (products.containsKey(product.getProductId())) {
            System.out.println("Product ID already exists.");
            return;
        }

        products.put(product.getProductId(), product);
        System.out.println("Product added successfully.");
    }

    // Update Product
    public void updateProduct(int productId, String name, int quantity, double price) {

        Product product = products.get(productId);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        product.setProductName(name);
        product.setQuantity(quantity);
        product.setPrice(price);

        System.out.println("Product updated successfully.");
    }

    // Delete Product
    public void deleteProduct(int productId) {

        if (products.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Search Product
    public Product getProduct(int productId) {

        Product product = products.get(productId);

        if (product == null) {
            System.out.println("Product not found.");
        }

        return product;
    }

    // Display Inventory
    public void displayProducts() {

        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}