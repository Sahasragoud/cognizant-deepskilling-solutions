package org.javaclaseses;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LibraryManagement {

    // Linear Search Implementation
    public static Book linearSearchByTitle(List<Book> books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book; // Found
            }
        }
        return null; // Not found
    }

    // Binary Search Implementation (Assumes list is pre-sorted by Title)
    public static Book binarySearchByTitle(List<Book> books, String targetTitle) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return books.get(mid); // Found
            } else if (comparison < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book(102, "To Kill a Mockingbird", "Harper Lee"),
                new Book(103, "1984", "George Orwell"),
                new Book(104, "Moby Dick", "Herman Melville"),
                new Book(105, "Pride and Prejudice", "Jane Austen")
        );

        String searchTitle = "1984";

        // 1. Linear Search Test (Unsorted)
        System.out.println("--- Linear Search ---");
        Book resultLinear = linearSearchByTitle(books, searchTitle);
        System.out.println("Result: " + (resultLinear != null ? resultLinear : "Book not found"));

        // 2. Binary Search Test (Requires sorting first)
        Collections.sort(books); // Sorts by title using compareTo
        System.out.println("\n--- Binary Search (Sorted List) ---");
        Book resultBinary = binarySearchByTitle(books, searchTitle);
        System.out.println("Result: " + (resultBinary != null ? resultBinary : "Book not found"));
    }
}
