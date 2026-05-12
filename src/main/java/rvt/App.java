package rvt;

public class App {
    public static void main(String[] args) {
        iOweYou mattsiou = new iOweYou();
        mattsiou.setSum("Alice", 50.0);
        mattsiou.setSum("Bob", 20.0);
        System.out.println("I owe Alice: " + mattsiou.howMuchDoIOweTo("Alice"));
        System.out.println("I owe Bob: " + mattsiou.howMuchDoIOweTo("Bob"));
        
        iOweYou lilasiou = new iOweYou();
        lilasiou.setSum("Alice", 1000.0);
        lilasiou.setSum("Bob", 220.0);
        System.out.println("I owe Alice: " + lilasiou.howMuchDoIOweTo("Alice"));
        System.out.println("I owe Bob: " + lilasiou.howMuchDoIOweTo("Bob"));
    
    }
}
