import java.util.HashMap;
import java.util.Scanner;

public class FibonacciRecursive {
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Fibonacci Series Generator (Recursive) ===");
        System.out.print("Enter the number of terms (positive number): ");
        int terms = getValidInput(scanner);

        System.out.println("\nFibonacci Series of " + terms + " terms:");
        for (int i = 0; i < terms; i++) {
            System.out.print(fibonacci(i));
            if (i < terms - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n\nThank you for using the Fibonacci Generator!");
        scanner.close();
    }

    private static int getValidInput(Scanner scanner) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input > 0) {
                    return input;
                }
                System.out.print("Please enter a positive number: ");
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a positive number: ");
                scanner.next(); 
            }
        }
    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        return result;
    }
}
