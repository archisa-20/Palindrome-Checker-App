import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        // ================= UC1: Application Entry and Welcome Message =================
        Scanner sc = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully");

        System.out.println("================= UC2: Hardcoded Palindrome Validation =================");
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
        System.out.println("================= UC3: Reversed String Based palindrome Check =================");
        System.out.print("Enter word: ");
        String input = sc.nextLine();
        String reverse3 = "";

        for (int i = input.length() - 1; i >= 0; i--)
            reverse3 += input.charAt(i);
        if (word.equals(reverse3)) {
            System.out.println(input + " is Palindrome");
        } else {
            System.out.println(input + " is NOT Palindrome");
        }

        System.out.println("================= UC4 : Character Array Based Validation =================");
        System.out.print("Enter word: ");
        String word4 = sc.nextLine();

        char[] arr = word4.toCharArray();
        boolean palindrome = true;

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                palindrome = false;
                break;
            }
        }
        System.out.println(palindrome ? "Palindrome" : "Not Palindrome");

        System.out.println("================= UC5 : Stack Based Validation =================");

        System.out.print("Enter word: ");
        String word5 = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for (char c : word5.toCharArray())
            stack.push(c);

        String reverse5 = "";
        while (!stack.isEmpty())
            reverse5 += stack.pop();

        System.out.println(word5.equalsIgnoreCase(reverse5) ? "Palindrome" : "Not Palindrome");

        System.out.println("================= UC6 : Queue+Stack fairness Check =================");

        System.out.print("Enter word: ");
        String word6 = sc.nextLine();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stk = new Stack<>();

        for (char c : word.toCharArray()) {
            queue.add(c);
            stk.push(c);
        }

        boolean palindrome1 = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stk.pop())) {
                palindrome1 = false;
                break;
            }
        }

        System.out.println(palindrome1 ? "Palindrome" : "Not Palindrome");

        System.out.println("================= UC7 : Deque Based Palindrome Checker =================");

        System.out.print("Enter word: ");
        String word7 = sc.nextLine();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word7.toCharArray())
            deque.add(c);

        boolean palindrome7 = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                palindrome7 = false;
                break;
            }
        }

        System.out.println(palindrome7 ? "Palindrome" : "Not Palindrome");

    }
}
