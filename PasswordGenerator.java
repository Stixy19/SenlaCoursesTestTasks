
import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

    private static final SecureRandom random = new SecureRandom();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите желаемую длину пароля (от 8 до 12 символов): ");
        int length = scanner.nextInt();

        if (length < 8 || length > 12) {
            System.out.println("Ошибка: длина пароля должна быть от 8 до 12 символов.");
            return;
        }

        String password = generatePassword(length);
        System.out.println("Сгенерированный пароль: " + password);

        scanner.close();
    }

    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        StringBuilder shuffled = new StringBuilder(input.length());
        char[] characters = input.toCharArray();

        for (int i = characters.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = characters[index];
            characters[index] = characters[i];
            characters[i] = temp;
        }

        for (char c : characters) {
            shuffled.append(c);
        }

        return shuffled.toString();
    }
}
