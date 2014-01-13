package net.snet.crm.api.resources;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import static java.util.Collections.list;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.management.Notification;
import javax.validation.Valid;
import net.snet.crm.api.model.Customer;
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
  public CustomerDao receiveCustomer(List<Customer> customers) {
//  @POST
//  public CustomerDao receiveCustomer(CustomerDao customerDao) {
//      int hh = customers.size();
//    customerDao.storeCustomer(customers.get(0));
      
    return customerDao;  
//     String hhg; 
//     hhg = "sdfsd";
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
