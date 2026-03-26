package rvt.utils;

public enum ConsoleColors {
     RESET("\u001B[0m"),
     BLACK("\u001B[30m"),
     RED("\u001B[31m"),
     GREEN("\u001B[32m"),
     YELLOW("\u001B[33m"),
     BLUE("\u001B[34m"),
     PURPLE("\u001B[35m"),
     CYAN("\u001B[36m"),
     WHITE("\u001B[37m"),
     PINK("\u001B[38;5;212m");

     public final String code;
     ConsoleColors(String code) {
         this.code = code;
     }
}
