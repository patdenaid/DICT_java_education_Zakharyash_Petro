import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("HANGMAN");

        // Список слів для вибору
        String[] words = {"python", "java", "javascript", "kotlin"};

        // Випадковим чином вибираємо слово зі списку
        int randomIndex = random.nextInt(words.length);
        String wordToGuess = words[randomIndex];

        int attemptsLeft = 8; // Кількість залишених спроб

        // Створюємо рядок з дефісами, який представляє відкриті та закриті літери
        StringBuilder wordInProgress = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            wordInProgress.append("-");
        }

        while (attemptsLeft > 0) {
            System.out.println(wordInProgress);
            System.out.println("Input a letter: >");
            String inputLetter = scanner.nextLine();

            if (wordToGuess.contains(inputLetter)) {
                // Якщо буква зустрічається в слові
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == inputLetter.charAt(0)) {
                        wordInProgress.setCharAt(i, inputLetter.charAt(0));
                    }
                }
            } else {
                // Якщо буква не зустрічається в слові
                System.out.println("That letter doesn't appear in the word");
                attemptsLeft--;
            }

            if (wordInProgress.toString().equals(wordToGuess)) {
                // Гравець вгадав всі літери
                System.out.println(wordInProgress);
                System.out.println("You survived!");
                break;
            }
        }

        if (!wordInProgress.toString().equals(wordToGuess)) {
            // Гравець не вгадав слово
            System.out.println("Thanks for playing!");
            System.out.println("We'll see how well you did in the next stage");
        }

        scanner.close();
    }
}
