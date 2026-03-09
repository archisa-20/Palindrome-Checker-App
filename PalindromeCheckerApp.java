// File: UseCase11PalindromeCheckerApp.java

// PalindromeChecker class encapsulates the palindrome logic
class PalindromeChecker {
    // Public method to expose palindrome checking
    public boolean checkPalindrome(String input) {
        // Normalize: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Use the PalindromeChecker service class
        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(input)) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }

        sc.close();
    }
}
