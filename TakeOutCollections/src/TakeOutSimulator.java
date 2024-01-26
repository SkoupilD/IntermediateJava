import java.util.InputMismatchException;
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
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Input needs to be an integer. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private boolean shouldSimulate() {
        String userPrompt = "Enter 1 to CONTINUE simulation or 0 to EXIT program: ";

        // Create an implementation of IntUserInputRetreiver using lambda function
        IntUserInputRetriever<Boolean> userInputRetriever = (selection) -> {
            if (selection == 1) {
                // Check if the customer has enough money to buy the lowest cost food item
                Food lowestCostFood = menu.getLowestCostFood();
                return customer.getMoney() >= lowestCostFood.getPrice();
            } else if (selection == 0) {
                return false; // Exit simulation
            } else {
                throw new IllegalArgumentException("Invalid selection. Enter 1 to continue or 0 to exit.");
            }
        };
        // Call getOutputOnIntUserInput and pass in userPrompt and the implementation of IntUserInputRetriever
        return getOutputOnIntInput(userPrompt, userInputRetriever);
    }

    // Method to retrieve a user menu selection
    private Food getMenuSelection() {
        String userPrompt = "Today's Menu Options!\n" + menu.toString() + "\nChoose a menu item!: ";

        // Create an implementation of IntUserInputRetreiver using lambda function
        IntUserInputRetriever<Food> userInputRetriever = (selection) -> {
            Food selectedFood = menu.getFood(selection);
            if (selectedFood != null) {
                return selectedFood;
            } else {
                throw new IllegalArgumentException("Invalid menu selection. Please choose a valid menu item.");
            }
        };

        // Call getOutputOnIntUserInput and pass in userPrompt and the implementation of IntUserInputRetriever
        return getOutputOnIntInput(userPrompt, userInputRetriever);
    }


}