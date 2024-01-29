import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PriceItem<Integer>> {
    private Map<T, Integer> shoppingBag;

    public ShoppingBag() {
        this.shoppingBag = new HashMap<>();
    }

    public void addItem(T item) {
        shoppingBag.put(item, shoppingBag.getOrDefault(item, 0) + 1);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<T, Integer> entry : shoppingBag.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }
}