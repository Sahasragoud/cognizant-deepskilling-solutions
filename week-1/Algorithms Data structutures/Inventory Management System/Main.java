package com.inventoryManagement.system;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(101, "Laptop", 10, 65000));
        inventory.addProduct(new Product(102, "Mouse", 50, 599));
        inventory.addProduct(new Product(103, "Keyboard", 20, 1499));

        System.out.println();

        inventory.displayProducts();

        System.out.println();

        inventory.updateProduct(102, "Wireless Mouse", 45, 799);

        System.out.println();

        System.out.println(inventory.getProduct(102));

        System.out.println();

        inventory.deleteProduct(101);

        System.out.println();

        inventory.displayProducts();
    }
}