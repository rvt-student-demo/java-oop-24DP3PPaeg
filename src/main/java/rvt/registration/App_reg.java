package rvt.registration;

import java.util.Scanner;

public class App_reg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ievadi savu vārdu:");
        String vards = scanner.nextLine();

        System.out.println("Ievadi savu uzvārdu:");
        String uzvards = scanner.nextLine();

        System.out.println("Ievadi savu e-pastu:");
        String epasts = scanner.nextLine();

        System.out.println("Ievadi personas kodu (formāts: 123456-12345):");
        String personasKods = scanner.nextLine();

        System.out.println("Ievadi datumu un laiku:");
        String dateAndTime = scanner.nextLine();

        try {
            Student_reg student = new Student_reg(vards, uzvards, epasts, personasKods, dateAndTime);
            System.out.println("Skolēns piereģistrēts veiksmīgi!");
            System.out.println("Vārds: " + student.vards);
            System.out.println("Uzvārds: " + student.uzvards);
            System.out.println("E-pasts: " + student.epasts);
            System.out.println("Personas kods: " + student.personasKods);
            System.out.println("Datums un laiks: " + student.dateAndTime);
        } catch (Exception e) {
            System.out.println("Registration failed: " + e.getMessage());
        }

        scanner.close();
    }
}
