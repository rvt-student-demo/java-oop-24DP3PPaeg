package rvt;

public class App {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.loadFromFile();
        list.print();

        System.out.println("last id = " + list.getLastId() + "\n");
        list.add("Read 10 min a day");
        list.print();
        System.out.println("last id = " + list.getLastId());


    }
}
