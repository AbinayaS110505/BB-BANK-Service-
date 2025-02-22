package view;
import controller.UserController;
import model.User;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserController userController = new UserController();
        User loggedInUser = null;

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    userController.registerUser();
                    break;
                case 2:
                    loggedInUser = userController.loginUser();
                    if (loggedInUser != null) {
                        userController.userDashboard(loggedInUser);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
