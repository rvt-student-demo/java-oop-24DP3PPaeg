package rvt;

public class Student extends Person {
    private int credits;
    public Student(String name, String address, int credits){
        super(name, address);
        this.credits = credits;
    }

    public int credits(){
        return this.credits;
    }
    public int study(){
        return credits ++;
    }
    public String toString(){
        return super.toString() + "\n " + "Study credits"+ credits;
    }
}
