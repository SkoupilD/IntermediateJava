import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String customerName = input.next();

        System.out.print("Enter the amount of money you have: ");
        int money;

        try {
            money = input.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }

        Customer customer = new Customer(customerName, money);
        FoodMenu menu = new FoodMenu(List.of(
                new Food("Enjoy Tacos", "Yummy steak tacos", 15),
                new Food("Enjoy Dumplings", "Delicious steamed dumplings", 10),
                new Food("Ramen", "Hot pork ramen", 12)
        ));

        TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, menu);
        takeOutSimulator.startTakeOutSimulator();
    }
}