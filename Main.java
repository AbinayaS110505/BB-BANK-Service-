package Main;
import controller.UserController;
import model.User;
import java.util.*;
public class Main {
    private static HashMap<String, User> users = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserController userController = new UserController();
        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
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
                    break;
                case 2:
                    System.out.print("Enter email: ");
                    String loginEmail = sc.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = sc.nextLine();

                    User user = users.get(loginEmail);
                    if (user != null && user.getPassword().equals(loginPassword)) {
                        System.out.println("Login successful! Welcome, " + user.getName());
                        userController.userDashboard(user);
                    } else {
                        System.out.println("In  valid credentials! Try again.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
