package org.javaclaseses;

public class ProxyPatternTest {

    public static void main(String[] args) {

        Image image = new ProxyImage("nature.jpg");

        System.out.println("First Call:");
        image.display();

        System.out.println();

        System.out.println("Second Call:");
        image.display();
    }
}