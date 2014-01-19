package net.snet.crm.api.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import net.snet.crm.api.model.Customer;
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
  
//  @POST
//  public CustomerDao receiveCustomer(List<Customer> customers) {
////  @POST
////  public CustomerDao receiveCustomer(CustomerDao customerDao) {
////      int hh = customers.size();
////    customerDao.storeCustomer(customers.get(0));
//      
//    return customerDao;  
////     String hhg; 
////     hhg = "sdfsd";
//    }
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

  
//  @POST
//   public Customer createPerson(Person person) {
//        return peopleDAO.create(person);
//    }
//  @GET
//  @Timed(name="get-requests")
//  public Map<String, Object> status(@QueryParam("name") Optional<String> name) {
//    LOGGER.debug("[{}] status called with '{}' name param", counter.incrementAndGet(), name.or(defaultName));
//    Map<String, Object> status = new HashMap<String, Object>();
//    status.put("name", name.or(defaultName));
//    status.put("timestamp", new DateTime());
//    return status;
//  }


}
