import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {
            "утёс", "образ", "картина", "список", "ювелир"
    };
    private static final int MAX_TRIES = 5;

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Random random = new Random();

        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        List<Character> guessedLetters = new ArrayList<>();
        int triesLeft = MAX_TRIES;
        System.out.println("Игра 'Виселица'");

        while (triesLeft > 0) {
            System.out.println("Слово: " + getCurrentProgress(wordToGuess, guessedLetters));
            System.out.println("Осталось жизней: " + triesLeft);
            System.out.print("Введите букву: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("Вы уже угадали эту букву.");
                continue;
            }

            guessedLetters.add(guess);

            if (!wordToGuess.contains(String.valueOf(guess))) {
                triesLeft--;
                System.out.println("Неправильно. Буквы нет в слове.");
            } else {
                System.out.println("Правильно! Буква есть в слове.");
            }

            if (isWordGuessed(wordToGuess, guessedLetters)) {
                System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
                break;
            }
        }

        if (triesLeft == 0) {
            System.out.println("Вы проиграли. Загаданное слово: " + wordToGuess);
        }

        scanner.close();
    }

    private static String getCurrentProgress(String word, List<Character> guessedLetters) {
        StringBuilder progress = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                progress.append(letter);
            } else {
                progress.append("*");
            }
            progress.append(" ");
        }
        return progress.toString().trim();
    }

    private static boolean isWordGuessed(String word, List<Character> guessedLetters) {
        for (char letter : word.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }
}