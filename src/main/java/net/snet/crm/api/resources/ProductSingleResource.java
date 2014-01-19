package net.snet.crm.api.resources;

import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.metrics.annotation.Timed;
import net.snet.crm.api.dao.ProductDao;
import net.snet.crm.api.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.PathParam;

/**
 * Created by admin on 22.12.13.
 */
@Path("/products/{productId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductSingleResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegionResource.class);

	private final ProductDao productDao;

	public ProductSingleResource(ProductDao productDao) {
		this.productDao = productDao;
	}
                
	@GET
	@Timed(name="get-requests")
	public Map<String, Object> returnProduct(@PathParam("productId") LongParam productId) {
            int response_code;
            
            final HashMap<String, Object> products = new HashMap<>();
            final List<Product> product = productDao.getProductById(productId.get().intValue());
            products.put("products", product);            
            return products;
	}
                 
}