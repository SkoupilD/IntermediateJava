import java.util.ArrayList;
import java.util.List;
public class FoodMenu{
    private List<Food> menu;
    public FoodMenu(){
        this.menu.add(new Food("Taco", "Very good meal!", 15));
        this.menu.add(new Food("Burrito", "Very tasty meal!", 14));
        this.menu.add(new Food("Quesadilla", "Deliciosoo!", 15));
    }

    public Food getFood(int index) {
        try {
            int adjustedIndex = index - 1;
            return menu.get(adjustedIndex);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Invalid index. Please choose a valid item number.");
            return null;
        }
    }
    public Food getLowestCostFood(){
        Food cheapestFood = menu.get(0);
        for (int i = 1; i < menu.size(); i++){
            if (menu.get(i).getPrice() < cheapestFood.getPrice()){
                cheapestFood = menu.get(i);
            }
        }
        return cheapestFood;
    }

    @Override
    public String toString() {
        StringBuilder menuString = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            Food food = menu.get(i);
            int index = i + 1;
            menuString.append(index).append(". ")
                    .append(food.getName()).append(": ")
                    .append(food.getDescription()).append("    Cost: $")
                    .append(food.getPrice()).append("\n");
        }
        return menuString.toString();
    }
}