package rvt;

import java.util.Scanner;

public class chapter_100_ex_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("āčēģīķļšūž" );

        while (true) {
            System.out.print("Enter the numerator: ");
            String input = scan.next();

            // 1. Exit check using charAt
            if (input.length() > 0 && input.toLowerCase().charAt(0) == 'q') {
                break;
            }

            try {
                // 2. Try to parse the numerator
                int numerator = Integer.parseInt(input);

                System.out.print("Enter the divisor:   ");
                String divInput = scan.next();
                int divisor = Integer.parseInt(divInput);

                // 3. Check for division by zero
                if (divisor == 0) {
                    System.out.println("You can't divide " + numerator + " by 0");
                } else {
                    int result = numerator / divisor;
                    System.out.println(numerator + " / " + divisor + " is " + result);
                }

            } catch (NumberFormatException e) {
                // 4. Handle "glarch" or other non-numeric strings
                System.out.println("You entered bad data.");
                System.out.println("Please try again.");
            }

            System.out.println(); // Print a blank line to match sample output spacing
        }

        scan.close();
    }
}