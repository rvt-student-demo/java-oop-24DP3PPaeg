package rvt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    private ArrayList<String> tasks;
    private final String filePath ="data/todo.csv";

    // Constructor: Initializes the list
    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void loadFromFile(){
        try (Scanner reader = new Scanner(new File(filePath))){
            // Simple student-friendly loader:
            // 1) skip header line
            // 2) read each CSV line, split on first comma, use the second column as the task
            if (reader.hasNextLine()) {
                reader.nextLine(); // skip header
            }
            while (reader.hasNextLine()){
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",", 2);
                String task = parts.length > 1 ? parts[1].trim() : parts[0].trim();
                tasks.add(task);
            }
        } catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        } 
    }


    

    // Adds a task to the list
    public void add(String task) {
        this.tasks.add(task);
        // append the new task to the CSV so file and in-memory list stay in sync
        try (FileWriter fw = new FileWriter(filePath, true)) {
            int nextId = getLastId() + 1;
            // ensure we start on a new line
            fw.write(System.lineSeparator() + nextId + "," + task);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Prints tasks with their index + 1
    public void print() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
        System.out.println("");
    }

    // Removes a task based on the number shown in print()
    public void remove(int number) {
        if (number > 0 && number <= tasks.size()) {
            tasks.remove(number - 1);
        }
    }
    // Return the last id present in the CSV file (0 if none)
    public int getLastId() {
        int lastId = 0;
        try (Scanner reader = new Scanner(new File(filePath))) {
            // skip header
            if (reader.hasNextLine()) reader.nextLine();
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",", 2);
                try {
                    int id = Integer.parseInt(parts[0].trim());
                    lastId = id; // keep the last valid id
                } catch (NumberFormatException e) {
                    // ignore lines with no numeric id
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lastId;
    }
    // Pievienot updateFile() metodi
    // kura atjauno/pārraksta .csv failu ar jauniem datiem
    // izmantojos esošo tasks ArrayList masīvu
    public void updateFile() {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            // Write header
            writer.println("id,task");
            // Write tasks with their ids
            for (int i = 0; i < tasks.size(); i++) {
                int id = i + 1; // id starts from 1
                writer.println(id + "," + tasks.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    /*
    Izmantojot RegEx - pārbaudīt lai aktivitāte saturētu tikai burtus, ciparus un atstarpes
    Aktivitātes garums - min, 3 simbolu (.length() metode)
    */
   public boolean checkEventString(String value) {
        // Simple, easy-to-read validation:
        // 1) treat null as empty
        // 2) trim surrounding whitespace
        // 3) require at least 3 characters
        // 4) allow only letters, digits and spaces
        if (value == null) {
            value = "";
        }

        // remove leading/trailing spaces
        value = value.trim();

        // too short -> invalid
        if (value.length() < 3) {
            System.out.println("Event is not valid"); // print not valid
            return false;
        }

        // check each character is a letter, digit or space
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (!(Character.isLetterOrDigit(c) || Character.isSpaceChar(c))) {
                System.out.println("Event is not valid (" + i+ ")"); // print not valid
                return false;
            }
        }

        // all checks passed
        System.out.println("Event is valid"); // print valid
        return true;
    }
}

