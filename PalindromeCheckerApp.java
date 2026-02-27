import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        // ================= UC1: Application Entry and Welcome Message =================
        Scanner sc = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully");

        // ================= UC2: Hardcoded Palindrome Validation =================
        String word = "madam";
        String reverse = "";
        System.out.println("Input Text: madam");

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        if (word.equals(reverse)) {
            System.out.println(word + " is Palindrome");
        } else {
            System.out.println(word + " is NOT Palindrome");
        }
        // ================= UC3: Reversed String Based palindrome Check =================
        System.out.print("Enter word: ");
        String input = sc.nextLine();
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--)
            reversed += input.charAt(i);
        if (word.equals(reversed)) {
            System.out.println(input + " is Palindrome");
        } else {
            System.out.println(input + " is NOT Palindrome");
        }
    }
}
