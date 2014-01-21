package net.snet.crm.api.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import net.snet.crm.api.model.Customers;
import net.snet.crm.api.dao.CustomerDao;

@Path("/customers/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerResource.class);

    private final CustomerDao customerDao;

    public CustomerResource(final CustomerDao customerDao) {
      this.customerDao = customerDao;
    }

    @POST
    public Customers receiveCustomer(Customers customers, @Context HttpServletResponse response) {   
        int response_code;

        customerDao.storeCustomer(customers);    
        response_code = customerDao.getResponseCode();
        if (response_code != 200) {
            throw new WebApplicationException(Response.status(response_code).build());
        }   
 
        return customers;
    }
}
