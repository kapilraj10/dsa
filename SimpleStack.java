import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleStack {
    private int[] stack;
    private int top;

    public SimpleStack(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println(" Stack is full!");
        } else {
            stack[++top] = value;
            System.out.println(" Pushed: " + value);
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("⚠️ Stack is empty!");
        } else {
            System.out.println("✅ Popped: " + stack[top--]);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("⚠️ Stack is empty!");
        } else {
            System.out.println("📦 Stack elements (top to bottom):");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        while (true) {
            System.out.print("Enter stack size: ");
            try {
                size = scanner.nextInt();
                if (size > 0) break;
                System.out.println("Please enter a positive number.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); 
            }
        }

        SimpleStack myStack = new SimpleStack(size);

        while (true) {
            System.out.println("\n📋 MENU");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter value to push: ");
                        int val = scanner.nextInt();
                        myStack.push(val);
                        break;
                    case 2:
                        myStack.pop();
                        break;
                    case 3:
                        myStack.display();
                        break;
                    case 4:
                        System.out.println(" Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println(" Invalid choice! Please choose between 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please enter a number.");
                scanner.next(); 
            }
        }
    }
}
