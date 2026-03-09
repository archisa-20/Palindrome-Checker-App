// File: UseCase8PalindromeCheckerApp.java

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListPalindromeChecker {
    private Node head;

    // Convert string to linked list
    public void convertStringToList(String str) {
        head = null;
        Node tail = null;
        for (char ch : str.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    // Check if linked list is palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle using fast and slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverseList(slow);

        // Step 3: Compare halves
        Node firstHalf = head;
        Node tempSecond = secondHalf;
        boolean palindrome = true;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        // Optional: Restore the list (reverse back second half)
        reverseList(secondHalf);

        return palindrome;
    }

    // Helper method to reverse linked list
    private Node reverseList(Node node) {
        Node prev = null;
        Node current = node;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        LinkedListPalindromeChecker checker = new LinkedListPalindromeChecker();
        checker.convertStringToList(input);

        if (checker.isPalindrome()) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }

        sc.close();
    }
}
