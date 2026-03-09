// File: UseCase10PalindromeCheckerApp.java

public class UseCase10PalindromeCheckerApp {

    // Method to normalize string: remove spaces and convert to lowercase
    public static String normalizeString(String str) {
        // Remove all spaces using regex and convert to lowercase
        return str.replaceAll("\\s+", "").toLowerCase();
    }

    // Method to check palindrome
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Normalize input
        String normalized = normalizeString(input);

        // Check palindrome
        if (isPalindrome(normalized)) {
            System.out.println("The string \"" + input + "\" is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome (ignoring case and spaces).");
        }

        sc.close();
    }
}
