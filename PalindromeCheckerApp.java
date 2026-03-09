// File: UseCase12PalindromeCheckerApp.java

import java.util.*;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Concrete Strategy: Using Stack
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Concrete Strategy: Using Deque (two-pointer approach)
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class
class PalindromeChecker {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.isPalindrome(input);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose strategy: 1 for Stack, 2 for Deque");
        int choice = sc.nextInt();

        PalindromeChecker checker;

        if (choice == 1) {
            checker = new PalindromeChecker(new StackStrategy());
        } else {
            checker = new PalindromeChecker(new DequeStrategy());
        }

        if (checker.checkPalindrome(input)) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }

        sc.close();
    }
}
