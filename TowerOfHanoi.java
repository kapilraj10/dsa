import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TowerOfHanoi {
    private static int moveCount = 0;
    private static int delayMs = 1000; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Tower of Hanoi Solver ===");
        System.out.print("Enter the number of disks: ");
        int numDisks = scanner.nextInt();
        
        while (numDisks <= 0) {
            System.out.println("Please enter a positive number of disks.");
            System.out.print("Enter the number of disks: ");
            numDisks = scanner.nextInt();
        }
        
        System.out.println("\nDo you want to adjust the visualization speed?");
        System.out.println("1. Slow (2 seconds between moves)");
        System.out.println("2. Normal (1 second between moves)");
        System.out.println("3. Fast (0.5 seconds between moves)");
        System.out.print("Enter your choice (1-3): ");
        
        int speedChoice = scanner.nextInt();
        switch (speedChoice) {
            case 1: delayMs = 2000; break;
            case 2: delayMs = 1000; break;
            case 3: delayMs = 500; break;
            default: System.out.println("Invalid choice. Using normal speed.");
        }

        System.out.println("\nSolving Tower of Hanoi with " + numDisks + " disks...");
        System.out.println("Source: A, Auxiliary: B, Destination: C\n");
        
        moveCount = 0;
        solveTowerOfHanoi(numDisks, 'A', 'B', 'C');
        
        System.out.println("\nPuzzle solved in " + moveCount + " moves!");
        scanner.close();
    }

    private static void solveTowerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            displayMove(n, source, destination);
            return;
        }
        
        solveTowerOfHanoi(n - 1, source, destination, auxiliary);
        displayMove(n, source, destination);
        solveTowerOfHanoi(n - 1, auxiliary, source, destination);
    }

    private static void displayMove(int disk, char from, char to) {
        moveCount++;
        System.out.printf("Move %d: Move disk %d from %c to %c%n", moveCount, disk, from, to);
        
        try {
            TimeUnit.MILLISECONDS.sleep(delayMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}