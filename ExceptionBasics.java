// Demonstrates try, catch, finally, catch block ordering, and multi-catch syntax.
public class ExceptionBasics {
    static int divide(int a, int b) {
        return a / b; // ArithmeticException if b == 0
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30};
        String text = null;

        try {
            System.out.println("10 / 2 = " + divide(10, 2));
            System.out.println("10 / 0 = " + divide(10, 0)); // Throws here
            System.out.println("never printed");
        } catch (ArithmeticException e) {
            System.out.println("Math problem: " + e.getMessage());
        } finally {
            System.out.println("finally always runs");
        }

        // Specific exceptions first, most general last
        try {
            System.out.println(data[5]);
            System.out.println(text.length());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad index: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null reference");
        } catch (Exception e) {
            System.out.println("Something else: " + e);
        }

        // Multi-catch when error handling is identical
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Invalid number input");
        }
    }
}
