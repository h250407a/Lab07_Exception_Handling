// Traps ArrayIndexOutOfBoundsException and reports the invalid index request.
public class ArrayBoundsHandlingDemo {
    public static void printElement(int[] array, int index) {
        try {
            System.out.printf("Element at index %d: %d%n", index, array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.printf("Caught exception: Index %d is out of bounds for array of length %d.%n", index, array.length);
        }
    }

    public static void main(String[] args) {
        int[] scores = {95, 87, 72, 64, 88};

        System.out.println("--- Array Access Testing ---");
        printElement(scores, 0);  // Valid first index
        printElement(scores, 3);  // Valid middle index
        printElement(scores, 5);  // Off-by-one boundary error
        printElement(scores, -1); // Negative index error
    }
}
