package org.javaclaseses;

public class StrategyPatternTest {

    public static void main(String[] args) {

        PaymentContext context =
                new PaymentContext(new CreditCardPayment());

        context.makePayment(2500);

        context.setPaymentStrategy(new PayPalPayment());

        context.makePayment(4500);
    }
}
