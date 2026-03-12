package rvt.registration;

import java.util.regex.Pattern;

public class Student_reg {
    public String vards;
    public String uzvards;
    public String epasts;
    public String personasKods;
    
    public Student_reg(String vards, String uzvards, String epasts, String personasKods) {
        validateFirstName(vards);
        validateLastName(uzvards);
        validateEmail(epasts);
        validatePersonalCode(personasKods);
        
        this.vards = vards;
        this.uzvards = uzvards;
        this.epasts = epasts;
        this.personasKods = personasKods;
    }
    
    public void validateFirstName(String vards) {
        Pattern namePattern = Pattern.compile("^[A-Za-z ]+$");
        if (!namePattern.matcher(vards).matches()) {
            throw new IllegalArgumentException("Invalid first name format");
        }
    }
    
    public void validateLastName(String uzvards) {
        Pattern namePattern = Pattern.compile("^[A-Za-z ]+$");
        if (!namePattern.matcher(uzvards).matches()) {
            throw new IllegalArgumentException("Invalid last name format");
        }
    }
    
    private void validateEmail(String epasts) {
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        if (!emailPattern.matcher(epasts).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
    
    public void validatePersonalCode(String personasKods) {
        Pattern codePattern = Pattern.compile("^\\d{6}-\\d{5}$");
        if (!codePattern.matcher(personasKods).matches()) {
            throw new IllegalArgumentException("Invalid personal code format");
        }
    }
}
