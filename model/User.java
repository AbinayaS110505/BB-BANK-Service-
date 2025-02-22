package model;
import java.util.*;
public class User {
    private String name, email, password;
    private Subscription subscription;
    private List<String> history = new ArrayList<>();
    private List<String> feedbackList = new ArrayList<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Subscription getSubscription() { return subscription; }
    public void setSubscription(Subscription subscription) { this.subscription = subscription; }

    public void viewProfile() {
        System.out.println("Name: " + name + " | Email: " + email);
        System.out.println("Subscription: " + (subscription == null ? "None" : subscription.getPlan()));
    }

    public void changePassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter old password: ");
        String oldPass = sc.nextLine();
        if (oldPass.equals(password)) {
            System.out.print("Enter new password: ");
            password = sc.nextLine();
            addHistory("Password changed");
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("Incorrect password!");
        }
    }

    public void manageSubscription() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to manage your subscription? (yes/no)");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Choose an option:");
            System.out.println("1. Activate Subscription");
            System.out.println("2. Renew Subscription");
            System.out.println("3. Cancel Subscription");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    if (subscription == null) {
                        System.out.println("Choose Plan: 1. Basic ($10)  2. Premium ($20)");
                        int planChoice = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter payment amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        if ((planChoice == 1 && amount >= 10) || (planChoice == 2 && amount >= 20)) {
                            subscription = new Subscription(planChoice == 1 ? "Basic Plan" : "Premium Plan");
                            addHistory("Activated " + subscription.getPlan() + " with payment of $" + amount);
                            System.out.println("Subscription activated: " + subscription.getPlan());
                        } else {
                            System.out.println("Insufficient amount. Subscription not activated.");
                        }
                    } else {
                        System.out.println("You already have an active subscription.");
                    }
                    break;
                case 2:
                    if (subscription != null) {
                        subscription.renew();
                        addHistory("Subscription renewed: " + subscription.getPlan());
                    } else {
                        System.out.println("No active subscription to renew.");
                    }
                    break;
                case 3:
                    if (subscription != null) {
                        subscription = null;
                        addHistory("Subscription canceled");
                        System.out.println("Subscription canceled.");
                    } else {
                        System.out.println("No active subscription to cancel.");
                    }
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } else {
            System.out.println("Subscription management skipped.");
        }
    }

    public void viewHistory() {
        System.out.println("User Activity History:");
        if (history.isEmpty()) {
            System.out.println("No activity recorded.");
        } else {
            for (String record : history) {
                System.out.println("- " + record);
            }
        }
    }

    public void giveFeedback() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your feedback: ");
        String feedback = sc.nextLine();
        feedbackList.add(feedback);
        System.out.println("Thank you for your feedback!");
        addHistory("Feedback given: " + feedback);
    }

    public void addHistory(String event) {
        history.add(event);
    }
}
