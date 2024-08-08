import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passwordLength = 0;

        while (passwordLength < 8 || passwordLength > 15) {
            System.out.print("Enter the desired password length (8-15): ");
            if (scanner.hasNextInt()) {
                passwordLength = scanner.nextInt();
                if (passwordLength < 8 || passwordLength > 15) {
                    System.out.println("Please enter a length between 8 and 15.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 8 and 15.");
                scanner.next(); // Clear the invalid input
            }
        }

        String password = generatePassword(passwordLength);
        System.out.println("Generated Password: " + password);
        scanner.close();
    }

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(index));
        }
        return new String(password);
    }
}