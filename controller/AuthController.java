package controller;
import model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthController {
    private Scanner sc = new Scanner(System.in);
    private User currentUser = null;
    private List<User> users = new ArrayList<>();
    public void showAuthMenu() {
        System.out.println("\n1. Register\n2. Login\n3. Exit");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> registerUser();
            case 2 -> loginUser();
            case 3 -> {
                System.out.println("Exiting application...");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice, try again.");
        }
    }

    private void registerUser() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        users.add(new User(name, email, password));
        System.out.println("Registration successful! Please login.");
    }

    private void loginUser() {
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful! Welcome, " + user.getName());
                return;
            }
        }
        System.out.println("Invalid email or password.");
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
