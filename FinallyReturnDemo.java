// Verifies JVM specification rule that finally blocks always execute before returning from try.
public class FinallyReturnDemo {
    public static int testReturnInTry() {
        try {
            System.out.println("1. Inside try block: preparing to return 100");
            return 100;
        } finally {
            System.out.println("2. Inside finally block: cleanup executes before method exits!");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Starting testReturnInTry() ---");
        int value = testReturnInTry();
        System.out.println("3. Returned value in main: " + value);

        System.out.println("\nLanguage Specification Explanation:");
        System.out.println("Under the Java Virtual Machine Specification, when a 'return' statement is encountered");
        System.out.println("in a try block, the return expression is evaluated, but actual method exit is suspended");
        System.out.println("until the finally block has completely executed. Only after finally completes is the value returned.");
    }
}
