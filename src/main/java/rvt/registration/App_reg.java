package rvt.registration;
import java.util.Scanner;

public class App_reg {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the student registration system!");
            System.out.println("Please select an option:");
            System.out.println("1. Register a new student");
            System.out.println("2. Exit");
            System.out.println("3. View registered students");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Student_reg.register();
                    break;
                case "2":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
