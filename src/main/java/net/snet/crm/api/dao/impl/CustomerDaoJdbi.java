/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.snet.crm.api.dao.impl;

import java.util.List;
import net.snet.crm.api.dao.CustomerDao;
import net.snet.crm.api.model.Customer;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

/**
 *
 * @author chemik
 */
public class CustomerDaoJdbi implements CustomerDao {
    
    private List<Customer> customer;
    private final DBI jdbi;
    
    
    public CustomerDaoJdbi(DBI jdbi) {
        this.jdbi = jdbi;
    }
    
    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
    
    @Override
    public Customer storeCustomer(Customer customer) {
        Handle handle = jdbi.open();
        handle.begin();
        handle.execute("INSERT INTO customers (id, name) VALUES (?, ?)", customer.getId(), customer.getName());
        handle.commit();
        handle.close();
        return customer;
    }

    @Override
    public Customer findCustomerByPublicId(String publicId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findCustomerByContractNo(String contractNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
