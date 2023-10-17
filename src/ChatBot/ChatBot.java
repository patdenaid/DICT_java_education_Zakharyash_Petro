public class ChatBot {
    public static void main(String[] args) {
        String botName = "ChatBot"; // Встановіть ім'я бота за вашим вибором
        int currentYear = java.time.Year.now().getValue(); // Отримуємо поточний рік

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + currentYear + ".");
    }
}
