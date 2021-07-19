public class ShopApp {
    public static void main(String[] args) {
        Product carrot = new Product("carrot", 3.21);
        Product apple = new Product("apple", 2.51);
        Basket basket = new Basket();
        basket.add(carrot,3);
        basket.add(apple,10);
        System.out.println();
        System.out.println(basket);
        basket.add(carrot,3);
        basket.remove(apple,2);
        System.out.println(basket);
        basket.remove(apple, 10);
        System.out.println(basket);

    }
}
