import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    buyCoffee(scanner, water, milk, coffeeBeans, disposableCups, money);
                    break;
                case "fill":
                    fillMachine(scanner, water, milk, coffeeBeans, disposableCups);
                    break;
                case "take":
                    takeMoney(money);
                    break;
                case "remaining":
                    displayRemaining(water, milk, coffeeBeans, disposableCups, money);
                    break;
                case "exit":
                    return;
                default:
                    break;
            }
        }
    }

    public static void buyCoffee(Scanner scanner, int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();
        switch (choice) {
            case "1":
                makeCoffee(water, 250, coffeeBeans, 16, 4, disposableCups, money);
                break;
            case "2":
                makeCoffee(water, 350, milk, 75, 7, disposableCups, money);
                break;
            case "3":
                makeCoffee(water, 200, milk, 100, 6, disposableCups, money);
                break;
            case "back":
                break;
            default:
                break;
        }
    }

    public static void fillMachine(Scanner scanner, int water, int milk, int coffeeBeans, int disposableCups) {
        System.out.println("Write how many ml of water you want to add:");
        int addedWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addedMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addedCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        int addedDisposableCups = scanner.nextInt();

        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        disposableCups += addedDisposableCups;
    }

    public static void takeMoney(int money) {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void makeCoffee(int water, int waterNeeded, int coffeeBeans, int coffeeBeansNeeded, int cost, int disposableCups, int money) {
        if (water >= waterNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            disposableCups--;
            money += cost;
        } else {
            System.out.print("Sorry, not enough ");
            if (water < waterNeeded) {
                System.out.print("water");
            } else if (coffeeBeans < coffeeBeansNeeded) {
                System.out.print("coffee beans");
            } else {
                System.out.print("disposable cups");
            }
            System.out.println("!");
        }
    }

    public static void displayRemaining(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
