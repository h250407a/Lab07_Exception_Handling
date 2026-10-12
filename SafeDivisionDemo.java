// Handles both non-numeric user input and division by zero using Scanner.
import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivisionDemo {
    public static void safeDivide(Scanner scanner) {
        try {
            System.out.print("Enter numerator (integer): ");
            int num = scanner.nextInt();

            System.out.print("Enter denominator (integer): ");
            int den = scanner.nextInt();

            int result = num / den;
            System.out.println("Result: " + num + " / " + den + " = " + result);

        } catch (InputMismatchException e) {
            System.out.println("Input Error: You must enter valid whole numbers.");
            scanner.nextLine(); // Clear dirty buffer
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: Division by zero is undefined.");
        }
    }

    public static void main(String[] args) {
        // Test with simulated inputs as well as interactive scanner
        System.out.println("--- Testing Safe Division ---");
        String testInput = "20 4\n20 0\nabc\n";
        Scanner simScanner = new Scanner(testInput);

        System.out.println("[Test 1: Valid Division]");
        safeDivide(simScanner);

        System.out.println("\n[Test 2: Division by Zero]");
        safeDivide(simScanner);

        System.out.println("\n[Test 3: Non-numeric Input]");
        safeDivide(simScanner);

        simScanner.close();
    }
}
