/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snet.crm.api.dao;

import java.util.List;
import net.snet.crm.api.model.Customer;
import net.snet.crm.api.model.Customers;
import net.snet.crm.api.model.Product;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

/**
 *
 * @author chemik
 */
public interface CustomerDao {

    public Customers storeCustomer(Customers customers);
    public List<Customer> getCustomerById(int id);
    public int getResponseCode();
    
//    @SqlQuery("SELECT id, name FROM customers WHER id = :id")
//    List<Customer> readCustomer(@Bind("id") int id);
//    public List<Customer> getCustomer(); 
//    public void setCustomer(List<Customer> customer);
    
    public Customer findCustomerByPublicId(String publicId);
    public Customer findCustomerByContractNo(String contractNo);

}
