import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final Map<String, Integer> productsNumber = new HashMap<>();

    public void add(Product product, int numberOfProductsPrim) {
        // Dodaje produkt to tablicy z cenami i tablicy z jego iloscia
        Integer numberOfProducts = Integer.valueOf(numberOfProductsPrim);
        // Zaktualizuj liczbe produktu jezeli juz istnieje
        if (productsNumber.containsKey(product.getName())) {
            productsNumber.put(product.getName(), productsNumber.get(product.getName()) + numberOfProducts);
        }
        else {
            productsNumber.put(product.getName(), numberOfProducts);
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

    private boolean isReadyToDelete(Product product, Integer numberOfProducts) {
        boolean deleteProduct = (productsNumber.get(product.getName()) - numberOfProducts) <= Integer.valueOf(0);
        if (deleteProduct) {
            productsNumber.remove(product.getName());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Produkty w koszyku: " + productsNumber;
    }
}
