package net.snet.crm.api.dao;

import net.snet.crm.api.dao.map.ProductMapper;
import net.snet.crm.api.model.Product;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;

/**
 * Created by admin on 22.12.13.
 */

@RegisterMapper(ProductMapper.class)
public interface ProductDao {
    
    @SqlQuery("SELECT id, name, download, upload, price FROM products")
    List<Product> findAllProducts();

    @SqlQuery("SELECT id, name, download, upload, price FROM products WHERE id = :id")
    List<Product> getProductById(@Bind("id") int id);

}