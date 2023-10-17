import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private String state;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
        this.state = "choosingAction";
    }

    public void processInput(String input) {
        switch (state) {
            case "choosingAction":
                processChoosingAction(input);
                break;
            case "choosingCoffeeType":
                processChoosingCoffeeType(input);
                break;
            case "fillingWater":
                processFillingWater(input);
                break;
            case "fillingMilk":
                processFillingMilk(input);
                break;
            case "fillingCoffeeBeans":
                processFillingCoffeeBeans(input);
                break;
            case "fillingDisposableCups":
                processFillingDisposableCups(input);
                break;
            default:
                break;
        }
    }

    public void processChoosingAction(String input) {
        switch (input) {
            case "buy":
                state = "choosingCoffeeType";
                break;
            case "fill":
                state = "fillingWater";
                System.out.println("Write how many ml of water you want to add:");
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                displayRemaining();
                break;
            case "exit":
                System.exit(0);
            default:
                break;
        }
    }

    public void processChoosingCoffeeType(String input) {
        switch (input) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                state = "choosingAction";
                break;
            default:
                break;
        }
    }

    public void processFillingWater(String input) {
        int addedWater = Integer.parseInt(input);
        water += addedWater;
        state = "fillingMilk";
        System.out.println("Write how many ml of milk you want to add:");
    }

    public void processFillingMilk(String input) {
        int addedMilk = Integer.parseInt(input);
        milk += addedMilk;
        state = "fillingCoffeeBeans";
        System.out.println("Write how many grams of coffee beans you want to add:");
    }

    public void processFillingCoffeeBeans(String input) {
        int addedCoffeeBeans = Integer.parseInt(input);
        coffeeBeans += addedCoffeeBeans;
        state = "fillingDisposableCups";
        System.out.println("Write how many disposable coffee cups you want to add:");
    }

    public void processFillingDisposableCups(String input) {
        int addedDisposableCups = Integer.parseInt(input);
        disposableCups += addedDisposableCups;
        state = "choosingAction";
    }

    public void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            disposableCups--;
            money += cost;
        } else {
            System.out.print("Sorry, not enough ");
            if (water < waterNeeded) {
                System.out.print("water");
            } else if (milk < milkNeeded) {
                System.out.print("milk");
            } else if (coffeeBeans < coffeeBeansNeeded) {
                System.out.print("coffee beans");
            } else {
                System.out.print("disposable cups");
            }
            System.out.println("!");
        }
    }

    public void displayRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            coffeeMachine.processInput(input);
        }
    }
}
