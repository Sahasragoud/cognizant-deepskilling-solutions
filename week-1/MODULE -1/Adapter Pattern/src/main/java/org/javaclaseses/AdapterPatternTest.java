package org.javaclaseses;

public class AdapterPatternTest {

    public static void main(String[] args) {

        PaymentProcessor payPal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        payPal.processPayment(2500);

        stripe.processPayment(4500);
    }
}
