import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        String botName = "ChatBot"; // Встановіть ім'я бота за вашим вибором
        int birthYear = java.time.Year.now().getValue(); // Отримуємо поточний рік

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        System.out.println("What a great name you have, " + userName + "!");
    }
}
