import java.math.BigDecimal;

public class Item {
    private String name;
    private Double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = Double.valueOf(price);
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
