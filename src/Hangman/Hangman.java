import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("HANGMAN");

        String[] words = {"python", "java", "javascript", "kotlin"};
        int randomIndex = random.nextInt(words.length);
        String wordToGuess = words[randomIndex];

        int lives = 8; // Кількість життів
        StringBuilder wordInProgress = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            wordInProgress.append("-");
        }

        while (lives > 0) {
            System.out.println(wordInProgress);
            System.out.println("Input a letter: >");
            String inputLetter = scanner.nextLine();

            if (wordToGuess.contains(inputLetter)) {
                // Буква зустрічається в слові
                if (wordInProgress.toString().contains(inputLetter)) {
                    // Гравець вже намагався вгадати цю букву
                    System.out.println("No improvements");
                    lives--;
                } else {
                    // Відкрити букву у слові
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (wordToGuess.charAt(i) == inputLetter.charAt(0)) {
                            wordInProgress.setCharAt(i, inputLetter.charAt(0));
                        }
                    }
                }
            } else {
                // Буква не зустрічається в слові
                System.out.println("That letter doesn't appear in the word");
                lives--;
            }

            if (!wordInProgress.toString().contains("-")) {
                // Гравець вгадав всі літери
                System.out.println(wordInProgress);
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                break;
            }
        }

        if (lives == 0) {
            // Гравець витратив всі життя
            System.out.println("You lost!");
        }

        scanner.close();
    }
}
