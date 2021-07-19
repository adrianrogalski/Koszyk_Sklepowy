public class ShopApp {
    public static void main(String[] args) {
        Item carrot = new Item("carrot", 3.21);
        Item apple = new Item("apple", 2.51);
        Basket basket = new Basket();
        basket.add(carrot);
        basket.add(apple);
        System.out.println(basket);
        basket.remove(carrot);
        System.out.println(basket);
    }
}
