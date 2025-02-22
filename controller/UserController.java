package controller;
import model.User;
import java.util.*;
public class UserController {
    private HashMap<String, User> users = new HashMap<>();
    public void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        if (users.containsKey(email)) {
            System.out.println("Email already registered! Try logging in.");
        } else {
            User newUser = new User(name, email, password);
            users.put(email, newUser);
            System.out.println("Registration successful! Please login.");
        }
    }
    public User loginUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        if (users.containsKey(email) && users.get(email).getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + users.get(email).getName());
            return users.get(email);
        } else {
            System.out.println("Invalid email or password! Try again.");
            return null;
        }
    }
    public void userDashboard(User user) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. View Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Manage Subscription");
            System.out.println("4. View History");
            System.out.println("5. Give Feedback");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    user.viewProfile();
                    break;
                case 2:
                    user.changePassword();
                    break;
                case 3:
                    user.manageSubscription();
                    break;
                case 4:
                    user.viewHistory();
                    break;
                case 5:
                    user.giveFeedback();
                    break;
                case 6:
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
