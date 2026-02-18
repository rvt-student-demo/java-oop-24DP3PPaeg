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
}

// TodoList list = new TodoList();
// list.add("read the course material");
// list.add("watch the latest fool us");
// list.add("take it easy");
// list.print();
// list.remove(2);
// list.print();
// list.add("buy raisins");
// list.print();
// list.remove(1);
// list.remove(1);
// list.print();