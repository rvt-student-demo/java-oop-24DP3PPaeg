package rvt;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.loadFromFile();
        list.print();

        System.out.println("last id = " + list.getLastId() + "\n");
        list.add("Read 10 min a day");
        list.remove(2);
        list.updateFile();
        list.print();

        // Prompt the user for an event description and validate it
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an event description: ");
        String event = scanner.nextLine();
        // `checkEventString` will print whether it's valid or not and return boolean
        boolean valid = list.checkEventString(event);
        // Optionally show the boolean result as well
        System.out.println("Valid returned: " + valid);
        scanner.close();
    }
}

