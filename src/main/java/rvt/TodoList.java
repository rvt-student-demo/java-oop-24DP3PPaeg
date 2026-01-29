package rvt;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> tasks;

    // Constructor: Initializes the list
    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    // Adds a task to the list
    public void add(String task) {
        this.tasks.add(task);
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