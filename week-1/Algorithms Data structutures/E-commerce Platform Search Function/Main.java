package com.ecommerce.search;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Product[] products = {

                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Keyboard", "Electronics"),
                new Product(110, "Shoes", "Fashion"),
                new Product(103, "Mouse", "Electronics"),
                new Product(108, "Watch", "Accessories")

        };

        SearchService search = new SearchService();

        // Linear Search
        System.out.println("Linear Search:");

        Product linearResult = search.linearSearch(products, 103);

        if (linearResult != null)
            System.out.println(linearResult);
        else
            System.out.println("Product not found");

        // Sort before Binary Search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("\nBinary Search:");

        Product binaryResult = search.binarySearch(products, 103);

        if (binaryResult != null)
            System.out.println(binaryResult);
        else
            System.out.println("Product not found");
    }
}