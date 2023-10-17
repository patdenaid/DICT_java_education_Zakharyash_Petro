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
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        int userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");
    }
}
