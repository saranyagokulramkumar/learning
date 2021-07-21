import java.util.*;

public class InventorySystem extends ProductDaoImpl{
    private Map<Integer, Product> products;

    public InventorySystem(){
        products = new HashMap<>();
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        if(products.containsKey(id)) return Optional.of(products.get(id));
        return Optional.empty();
    }

    public List<Product> listProducts(String sortKey) {
        return super.listProducts(sortKey.toUpperCase(), new ArrayList<>(this.products.values()));
    }

    @Override
    public boolean addProduct(Product p) {
        products.put(p.getId(),p);
        return true;
    }

    @Override
    public boolean removeProduct(Integer id) {
        if(products.remove(id) == null) return false;
        return true;
    }

    @Override
    public String toString() {
        return "InventorySystem{" +
                "products=" + products +
                '}';
    }
}
