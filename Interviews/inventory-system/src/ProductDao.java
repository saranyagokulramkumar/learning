import java.util.List;
import java.util.Optional;

public interface ProductDao<P, ID>{
    Optional<P> getProduct(ID id);
    List<P> listProducts(String sortKey,List<Product> products);
    boolean addProduct(P p);
    boolean removeProduct(ID id);
}
