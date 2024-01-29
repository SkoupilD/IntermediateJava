import java.util.Scanner;

public class TakeOutSimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator(Customer customer, FoodMenu menu) {
        this.customer = customer;
        this.menu = menu;
        this.input = new Scanner(System.in);
    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) {
        while (true) {
            try {
                System.out.println(userInputPrompt);
                int userIntInput = input.nextInt();
                return intUserInputRetriever.produceOutputOnIntUserInput(userIntInput);
            } catch (IllegalArgumentException e) {
                input.next();
                System.out.println("Input needs to be an int type. Try Again!");
            }
        }
    }

    public boolean shouldSimulate() {
        String userPrompt = "Enter 1 to CONTINUE simulation or 0 to EXIT program: ";
        IntUserInputRetriever<Boolean> userInputRetriever = (selection) -> {
            if (selection == 1) {
                Food lowCostFood = menu.getLowestCostFood();
                return customer.getMoney() >= lowCostFood.getPrice();
            } else if (selection == 0) {
                return false;
            } else {
                throw new IllegalArgumentException("Invalid selection. Enter 1 to continue or 0 to exit.");
            }
        };
        return getOutputOnIntInput(userPrompt, userInputRetriever);
    }

    public Food getMenuSelection() {
        String userPrompt = "Choose a menu item!: \n" + menu.toString();
        IntUserInputRetriever<Food> intFoodSelection = (selection) -> {
            Food selectedFood = menu.getFood(selection);
            if (selectedFood != null) {
                return selectedFood;
            } else {
                throw new IllegalArgumentException("Invalid menu selection. Please choose a valid menu item.");
            }
        };
        return getOutputOnIntInput(userPrompt, intFoodSelection);
    }

    public boolean isStillOrderingFood() {
        String userPrompt = "Enter 1 to CONTINUE shopping or 0 to CHECKOUT: ";
        IntUserInputRetriever<Boolean> userInputRetriever = (selection) -> {
            if (selection == 1) {
                return true;
            } else if (selection == 0) {
                return false;
            } else {
                throw new IllegalArgumentException("Invalid selection. Enter 1 to continue or 0 to checkout.");
            }
        };
        return getOutputOnIntInput(userPrompt, userInputRetriever);
    }

    public void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
        System.out.println("Processing payment...");
        int remainingMoney = customer.getMoney() - shoppingBag.getTotalPrice();
        customer.setMoney(remainingMoney);
        System.out.println("Your remaining money: $" + remainingMoney);
        System.out.println("Thank you and enjoy your food!");
    }

    public void takeOutPrompt() {
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        int customerMoneyLeft = customer.getMoney();

        while (true) {
            System.out.printf("You have $%d left to spend%n%n", customerMoneyLeft);
            System.out.println("Today's Menu Options!\n" + menu.toString());

            Food selectedFood = getMenuSelection();

            if (customerMoneyLeft >= selectedFood.getPrice()) {
                customerMoneyLeft -= selectedFood.getPrice();
                shoppingBag.addItem(selectedFood);
                System.out.println("Item added to your bag!\n");
            } else {
                System.out.println("Oops! Looks like you don't have enough for that. Choose another item or checkout.\n");
            }

            if (!isStillOrderingFood()) {
                checkoutCustomer(shoppingBag);
                break;
            }
        }
    }

    public void startTakeOutSimulator() {
        System.out.println("Hello, welcome to my restaurant!\n");
        System.out.printf("Welcome %s!%n%n", customer.getName());

        while (shouldSimulate()) {
            takeOutPrompt();
        }
    }
}