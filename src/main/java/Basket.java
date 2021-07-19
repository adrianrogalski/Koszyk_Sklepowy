import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<String, Double> items = new HashMap<>();

    public void add(Item item) {
        items.put(item.getName(), item.getPrice());
    }
    public void remove(Item item) {
        items.remove(item.getName());
    }

    @Override
    public String toString() {
        return "Produkty w koszyku: " + items;
    }
}
