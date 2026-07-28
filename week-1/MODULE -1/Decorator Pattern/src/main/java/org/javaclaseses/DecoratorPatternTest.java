package org.javaclaseses;

public class DecoratorPatternTest {

    public static void main(String[] args) {

        // Email only
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Welcome!");

        System.out.println();

        // Email + SMS
        Notifier emailSmsNotifier =
                new SMSNotifierDecorator(new EmailNotifier());
        emailSmsNotifier.send("Your OTP is 123456");

        System.out.println();

        // Email + SMS + Slack
        Notifier multiChannelNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        multiChannelNotifier.send("Server is running successfully.");
    }
}