import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class ProductDaoImpl implements ProductDao<Product,Integer>{

    private static final String NAME = "NAME";
    private static final String ID = "ID";
    private static final String COUNT = "COUNT";

    @Override
    public List<Product> listProducts(String sortKey,List<Product> products) {
        switch(sortKey){
            case NAME: {
                Collections.sort(products, Comparator.comparing(Product::getName));
                return products;
            }
            case ID: {
                Collections.sort(products, Comparator.comparing(Product::getId));
                return products;
            }
            case COUNT:{
                Collections.sort(products, Comparator.comparing(Product::getCount));
                return products;
            }
            default: return products;
        }
    }
}
