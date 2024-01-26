import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PriceItem<Integer>> {
    private Map<T, Integer> shoppingBag;

    // No-argument constructor
    public ShoppingBag() {
        this.shoppingBag = new HashMap<>();
    }

    // Method to add an item to the shopping bag
    public void addItem(T item) {
        if (shoppingBag.containsKey(item)) {
            // If item already exists, increment its quantity by 1
            int currentQuantity = shoppingBag.get(item);
            shoppingBag.put(item, currentQuantity + 1);
        } else {
            // If item does not exist, map item to a value of 1
            shoppingBag.put(item, 1);
        }
    }
    public int getTotalPrice() {
        int grandTotal = 0;
        for (T item : shoppingBag.keySet()) {
            int itemPrice = item.getPrice();
            int quantity = shoppingBag.get(item);
            int totalPriceForItem = itemPrice * quantity;
            grandTotal += totalPriceForItem;
        }

        return grandTotal;
    }
}
