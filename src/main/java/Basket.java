import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class Basket {
    private Map<String, Integer> productsNumber = new HashMap<>();
    private Map<String, Double> productsPrices = new HashMap<>();

    public void add(Product product, int numberOfProductsPrim) {
        // Dodaje produkt to tablicy z cenami i tablicy z jego iloscia
        Integer numberOfProducts = Integer.valueOf(numberOfProductsPrim);
        // Zaktualizuj liczbe produktu jezeli juz istnieje
        if (productsNumber.containsKey(product.getName())) {
            productsNumber.put(product.getName(), productsNumber.get(product.getName()) + numberOfProducts);
        }
        else {
            productsNumber.put(product.getName(), numberOfProducts);
            productsPrices.put(product.getName(), product.getPrice());
        }
    }

    public void remove(Product product, int numberOfProductsPrim) {
        // Jezeli liczba produktu jest wieksza od zera po usunięciu cześci z nich aktualizuje tablice z jego liczbą
        // Jeżeli liczba produktu jest mniejsza lub rowna zero usuwa produkt z obu tablic
        Integer numberOfProducts = Integer.valueOf(numberOfProductsPrim);

        // Zaktualizuj liczbe produktu jezeli juz istnieje
        if (productsNumber.containsKey(product.getName())) {
            if (isReadyToDelete(product, numberOfProducts)) {
                return;
            }
            productsNumber.put(product.getName(), productsNumber.get(product.getName()) - numberOfProducts);
        }
    }

    public String overallPrice() {
        BigDecimal summary = new BigDecimal(0);
        for (String productName : productsNumber.keySet()) {
            BigDecimal numberOfProducts = new BigDecimal(productsNumber.get(productName));
            BigDecimal priceOfProducts = new BigDecimal(productsPrices.get(productName));
            summary = summary.add(priceOfProducts.multiply(numberOfProducts));
        }
        return "Suma: " + summary.setScale(2, RoundingMode.HALF_UP);
    }

    private boolean isReadyToDelete(Product product, Integer numberOfProducts) {
        boolean deleteProduct = (productsNumber.get(product.getName()) - numberOfProducts) <= Integer.valueOf(0);
        if (deleteProduct) {
            productsNumber.remove(product.getName());
            productsPrices.remove(product.getName());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Produkty w koszyku: " + productsNumber;
    }
}
