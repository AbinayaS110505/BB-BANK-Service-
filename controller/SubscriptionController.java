package controller;
import model.User;
import model.Subscription;
import java.util.Scanner;

public class SubscriptionController {
    private Scanner sc = new Scanner(System.in);

    public void manageSubscription(User user) {
        System.out.println("1. Activate Subscription\n2. Renew Subscription\n3. Cancel Subscription");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> activateSubscription(user);
            case 2 -> renewSubscription(user);
            case 3 -> cancelSubscription(user);
            default -> System.out.println("Invalid option");
        }
    }

    private void activateSubscription(User user) {
        System.out.println("Choose Plan: 1. Basic ($10)  2. Premium ($20)");
        int planChoice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter payment amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if ((planChoice == 1 && amount >= 10) || (planChoice == 2 && amount >= 20)) {
            user.setSubscription(new Subscription(planChoice == 1 ? "Basic Plan" : "Premium Plan"));
            user.addHistory("Activated " + user.getSubscription().getPlan() + " with payment of $" + amount);
            System.out.println("Subscription activated: " + user.getSubscription().getPlan());
        } else {
            System.out.println("Insufficient amount. Subscription not activated.");
        }
    }

    private void renewSubscription(User user) {
        if (user.getSubscription() != null) {
            user.getSubscription().renew();
            user.addHistory("Subscription renewed: " + user.getSubscription().getPlan());
        } else {
            System.out.println("No active subscription to renew.");
        }
    }

    private void cancelSubscription(User user) {
        if (user.getSubscription() != null) {
            user.setSubscription(null);
            user.addHistory("Subscription canceled");
            System.out.println("Subscription canceled.");
        } else {
            System.out.println("No active subscription to cancel.");
        }
    }
}
