package rvt.registration;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Student_reg {
    public String vards;
    public String uzvards;
    public String epasts;
    public String personasKods;
    public String dateAndTime;

    private final String filePath ="data/students.csv";
    private ArrayList<Student_reg> students = new ArrayList<>();


    public Student_reg(String vards, String uzvards, String epasts, String personasKods, String dateAndTime) {
        // validateFirstName(vards);
        // validateLastName(uzvards);
        // validateEmail(epasts);
        // validatePersonalCode(personasKods);

        this.vards = vards;
        this.uzvards = uzvards;
        this.epasts = epasts;
        this.personasKods = personasKods;
        this.dateAndTime = dateAndTime;
    }
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your first name:");
        String vards = scanner.nextLine();
        try {
            // 2. Izsaucam metodi
            Student_reg.validateFirstName(vards);

        } catch (IllegalArgumentException e) {
            // 3. Noķeram kļūdu, ja regex neatbilst
            System.out.println("Error: Your first name is not valid");
            return;
        }

        System.out.println("Input your last name:");
        String uzvards = scanner.nextLine();
        try {
            // 2. Izsaucam metodi
            Student_reg.validateLastName(uzvards);

        } catch (IllegalArgumentException e) {
            // 3. Noķeram kļūdu, ja regex neatbilst
            System.out.println("Error: Your last name is not valid");
            return;
        }

        System.out.println("Input your email:");
        String epasts = scanner.nextLine();
        try {
            // 2. Izsaucam metodi
            Student_reg.validateEmail(epasts);

        } catch (IllegalArgumentException e) {
            // 3. Noķeram kļūdu, ja regex neatbilst
            System.out.println("Error: Your email is not valid");
            return;
        }

        System.out.println("Input your personal code (format: 123456-12345):");
        String personasKods = scanner.nextLine();
        try {
            // 2. Izsaucam metodi
            Student_reg.validatePersonalCode(personasKods);

        } catch (IllegalArgumentException e) {
            // 3. Noķeram kļūdu, ja regex neatbilst
            System.out.println("Error: Your personal code is not valid");
            return;
        }

        Student_reg jauns_student = new Student_reg(vards, uzvards, epasts, personasKods, LocalDateTime.now().toString());
        System.out.println();
        System.out.println("Student registered successfully!");
        System.out.println("Name: " + jauns_student.vards);
        System.out.println("Last Name: " + jauns_student.uzvards);
        System.out.println("Email: " + jauns_student.epasts);
        System.out.println("Personal Code: " + jauns_student.personasKods);
        Student_reg.formatDateAndTime();

        jauns_student.add(vards, uzvards, epasts, personasKods, LocalDateTime.now().toString());
        scanner.close();
    }

    public static void validateFirstName(String vards) {
        Pattern namePattern = Pattern.compile("^[a-zA-Zā-žĀ-Ž ]+$");
        if (!namePattern.matcher(vards).matches()) {
            throw new IllegalArgumentException("Nederīgs vārda formāts");
        }
    }

    public static void validateLastName(String uzvards) {
        Pattern namePattern = Pattern.compile("^[a-zA-Zā-žĀ-Ž ]+$");
        if (!namePattern.matcher(uzvards).matches()) {
            throw new IllegalArgumentException("Nederīgs uzvārda formāts");
        }
    }

    public static void validateEmail(String epasts) {
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        if (!emailPattern.matcher(epasts).matches()) {
            throw new IllegalArgumentException("Nederīgs e-pasta formāts");
        }
    }

    public static void validatePersonalCode(String personasKods) {
        Pattern codePattern = Pattern.compile("^\\d{6}-\\d{5}$");
        if (!codePattern.matcher(personasKods).matches()) {
            throw new IllegalArgumentException("Nederīgs personas koda formāts");
        }
    }

    public static void formatDateAndTime() {
        LocalDateTime tagad = LocalDateTime.now();
        DateTimeFormatter formats = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Registered at: " + tagad.format(formats));
    }


    public void add(String vards, String uzvards, String epasts, String personasKods, String dateAndTime) {
    // 1. Izveidojam objektu (pārliecinies, ka konstruktors atbalsta visus 5 parametrus)
    Student_reg jaunais = new Student_reg(vards, uzvards, epasts, personasKods, dateAndTime);
    
    // 2. Pievienojam objektu sarakstam
    this.students.add(jaunais); 

    // 3. Failā rakstām teksta formātu (tas paliek kā bija)
    try (FileWriter fw = new FileWriter(filePath, true)) {
        fw.write(System.lineSeparator() + vards + "," + uzvards + "," + epasts + "," + personasKods + "," + dateAndTime);
    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

        }