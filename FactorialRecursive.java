import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorialRecursive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Factorial Calculator (Recursive) ===");
        System.out.print("Enter a positive integer: ");
        int n = getValidInput(scanner);
        long result = factorial(n);
        System.out.println("The factorial of " + n + " is: " + result);
        scanner.close();
    }

    private static int getValidInput(Scanner scanner) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= 1) {
                    return input;
                } else {
                    System.out.print("Please enter a positive integer (>=1): ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a positive integer: ");
                scanner.next();
            }
        }
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1L;
        } else {
            return n * factorial(n - 1);
        }
    }
}
