// File: UseCase13PalindromeCheckerApp.java

import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
    String getName();
}

// Strategy 1: Two-Pointer
class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    @Override
    public String getName() { return "Two-Pointer Strategy"; }
}

// Strategy 2: Stack
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) stack.push(c);
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
    @Override
    public String getName() { return "Stack Strategy"; }
}

// Strategy 3: Recursive
class RecursiveStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return checkRecursive(normalized, 0, normalized.length() - 1);
    }
    private boolean checkRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkRecursive(str, start + 1, end - 1);
    }
    @Override
    public String getName() { return "Recursive Strategy"; }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        List<PalindromeStrategy> strategies = Arrays.asList(
                new TwoPointerStrategy(),
                new StackStrategy(),
                new RecursiveStrategy()
        );

        System.out.println("\nPerformance Comparison:");
        for (PalindromeStrategy strategy : strategies) {
            long startTime = System.nanoTime();
            boolean result = strategy.isPalindrome(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%s -> Result: %s, Time: %d ns%n",
                    strategy.getName(),
                    result ? "Palindrome" : "Not Palindrome",
                    duration);
        }

        sc.close();
    }
}
