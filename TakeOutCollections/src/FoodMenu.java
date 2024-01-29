import java.util.List;

public class FoodMenu {
    private List<Food> menu;

    public FoodMenu(List<Food> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        StringBuilder menuString = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            menuString.append((i + 1) + ". " + menu.get(i).toString() + "\n");
        }
        return menuString.toString();
    }

    public Food getFood(int index) {
        if (index >= 1 && index <= menu.size()) {
            return menu.get(index - 1);
        } else {
            return null;
        }
    }

    public Food getLowestCostFood() {
        Food lowestCostFood = menu.get(0);
        for (Food food : menu) {
            if (food.getPrice() < lowestCostFood.getPrice()) {
                lowestCostFood = food;
            }
        }
        return lowestCostFood;
    }
}