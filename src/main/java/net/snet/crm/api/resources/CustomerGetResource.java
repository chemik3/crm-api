/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snet.crm.api.resources;

import com.yammer.dropwizard.jersey.params.LongParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.snet.crm.api.dao.CustomerDao;
import net.snet.crm.api.model.Customer;

/**
 *
 * @author chemik
 */
@Path("/customers/{customerId}")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerGetResource {

	private final CustomerDao customerDao;

	public CustomerGetResource(final CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@GET
	public Map<String, Object> returnCustomer(@PathParam("customerId") LongParam personId) {
		final HashMap<String, Object> customers = new HashMap<>();
		final List<Customer> customerList = customerDao.getCustomerById(personId.get().intValue());
		customers.put("customers", customerList);
		return customers;
	}
}
