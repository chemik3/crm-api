/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snet.crm.api.dao;

import java.util.List;
import net.snet.crm.api.model.Customer;

/**
 *
 * @author chemik
 */
public interface CustomerDao {

    public Customer storeCustomer(Customer customer);
    public List<Customer> getCustomer(); 
    public void setCustomer(List<Customer> customer);
    
    public Customer findCustomerByPublicId(String publicId);
    public Customer findCustomerByContractNo(String contractNo);

}
