import java.util.Optional;

public class Main {
    public static void main(String[] args){
        InventorySystem inventorySystem = new InventorySystem();

        System.out.println(inventorySystem.listProducts("id"));

        inventorySystem.addProduct(new Product(7, "shorts", 5));
        inventorySystem.addProduct(new Product(3, "shirts", 3));

        System.out.println(inventorySystem.listProducts("name"));

        Optional<Product> a = inventorySystem.getProduct(7);
        System.out.println(a);

        a.get().setName("slippers");
        a.get().setCount(10);

        inventorySystem.removeProduct(3);
        inventorySystem.addProduct(new Product(2, "suits", 2));

        System.out.println(inventorySystem.listProducts("id"));
    }
}
