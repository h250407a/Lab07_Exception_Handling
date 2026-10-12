// Creates and handles custom checked InvalidAgeException for biological range checking.
// Custom checked exception extending Exception
class InvalidAgeException extends Exception {
    private final int invalidAge;

    public InvalidAgeException(String message, int invalidAge) {
        super(message);
        this.invalidAge = invalidAge;
    }

    public int getInvalidAge() {
        return invalidAge;
    }
}

public class AgeValidationDemo {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException(
                "Age must be between 0 and 120 inclusive. Provided age: " + age, age
            );
        }
        System.out.println("Age verified valid: " + age);
    }

    public static void main(String[] args) {
        int[] testAges = {20, 0, 120, -5, 145};

        System.out.println("--- Age Validation Tests ---");
        for (int age : testAges) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Validation Failure: " + e.getMessage());
            }
        }
    }
}
