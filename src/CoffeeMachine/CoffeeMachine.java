import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAvailable = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAvailable = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeansAvailable = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        int waterRequired = cupsNeeded * 200;
        int milkRequired = cupsNeeded * 50;
        int coffeeBeansRequired = cupsNeeded * 15;

        int cupsAvailable = Math.min(waterAvailable / 200, Math.min(milkAvailable / 50, coffeeBeansAvailable / 15));

        if (cupsAvailable == cupsNeeded) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsAvailable > cupsNeeded) {
            int extraCups = cupsAvailable - cupsNeeded;
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        } else {
            System.out.println("No, I can make only " + cupsAvailable + " cups of coffee");
        }

        scanner.close();
    }
}
