package com.SortingCustomer.order;

public class OrderSorter {

    // ==================== BUBBLE SORT ====================
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap adjacent orders
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: Stop if no swaps occurred during a pass
            if (!swapped) break;
        }
    }

    // ==================== QUICK SORT ====================
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);  // Sort left partition
            quickSort(orders, pivotIndex + 1, high); // Sort right partition
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice(); // Choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap orders[i + 1] with the pivot (orders[high])
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // ==================== MAIN DEMO ====================
    public static void main(String[] args) {
        Order[] ordersForBubble = {
                new Order(101, "Alice", 250.50),
                new Order(102, "Bob", 89.99),
                new Order(103, "Charlie", 499.00),
                new Order(104, "Diana", 120.00),
                new Order(105, "Ethan", 310.75)
        };

        // Clone array for Quick Sort comparison
        Order[] ordersForQuick = ordersForBubble.clone();

        // 1. Bubble Sort
        System.out.println("--- Bubble Sort Result ---");
        bubbleSort(ordersForBubble);
        for (Order o : ordersForBubble) {
            System.out.println(o);
        }

        // 2. Quick Sort
        System.out.println("\n--- Quick Sort Result ---");
        quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        for (Order o : ordersForQuick) {
            System.out.println(o);
        }
    }
}