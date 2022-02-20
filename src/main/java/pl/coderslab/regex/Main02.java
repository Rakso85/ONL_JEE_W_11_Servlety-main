package pl.coderslab.regex;

import java.util.List;

public class Main02 {

    public static void main(String[] args) {
        List<String> badPasswords = List.of("","abc","ABCDEFGHIJK", "abcdefghijk", "AAbcdefghijk", "abcdefghiJK");
        List<String> goodPassword = List.of("aBcDeFgHiJk", "123a456A789");

        System.out.println("--- BAD PASSWORDS ---");
        for (String pass : badPasswords) {
            System.out.println("verifyPassword(" + pass + ") = " + verifyPassword(pass));
        }

        System.out.println("--- GOOD PASSWORDS ---");
        for (String pass : goodPassword) {
            System.out.println("verifyPassword(" + pass + ") = " + verifyPassword(pass));
        }
    }

    public static boolean verifyPassword(String text) {
        if (!text.matches(".{10,15}")) return false;
        if (!text.matches(".*[a-z].*")) return false;
        if (!text.matches(".*[A-Z].*")) return false;
        if (text.matches(".*([a-z]{2,}|[A-Z]{2,}).*")) return false;
        return true;
    }
}
