package rvt;

import java.util.HashMap;

public class iOweYou {
    HashMap<String, Double> debts = new HashMap<>();
    public void setSum(String name, double amount) {
        debts.put(name, amount);
    }
    public double howMuchDoIOweTo(String toWhom) {
        return debts.get(toWhom);
    }

}
