public class PalindromeCheckerApp {
    public static void main(String[] args){

    // ================= UC1: Application Entry and Welcome Message =================

        System.out.println("======================================");
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully");

    // ================= UC2: Hardcoded Palindrome Validation =================
        String word = "madam";
        String reversed="";
        System.out.println("Input Text: madam");

        for (int i = word.length() - 1; i >= 0; i--){
            reversed += word.charAt(i);
        }
        if (word.equals(reversed)) {
            System.out.println(word + " is Palindrome");
        }else {
            System.out.println(word + " is NOT Palindrome");
        }
    }
}
