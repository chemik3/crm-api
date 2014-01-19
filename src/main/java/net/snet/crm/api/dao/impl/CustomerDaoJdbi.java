/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.snet.crm.api.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.snet.crm.api.dao.CustomerDao;
import net.snet.crm.api.model.Customer;
import net.snet.crm.api.model.Customers;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.IntegerMapper;
import static sun.misc.Signal.handle;
import net.snet.crm.api.dao.map.CustomerMapper;
/**
 *
 * @author chemik
 */
public class CustomerDaoJdbi implements CustomerDao {
    
    private List<Customer> customer;
    private final DBI jdbi;
    private int responseCode; 
    
    
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
    public int getResponseCode() {
        return responseCode;
    }
      
    @Override
    public Customers storeCustomer(Customers customers) {   
        Handle handle = null;
//        List<Customer> customers_db = new ArrayList<Customer>(); 
        
        //Only one customer per request is acceptable + check obligatory fields
        if (customers.size() != 1 || customers.checkField() == false) {
            responseCode = 400;
            return customers;
        }          
        
        try {
            handle = jdbi.open();
            handle.begin();
            
            //Check if customer already exist
//            List<Map<String, Object>> rs = handle.select("SELECT public_id FROM customers WHERE public_id = ? or contract_no = ?",
//                                              customers.getCustomers().get(0).getPublic_id(), 
//                                              customers.getCustomers().get(0).getContract_no());
            
             List<Customer> customer_db = handle.createQuery("SELECT * FROM customers WHERE public_id = :public_id or contract_no = :contract_no")
                                                .bind("public_id", customers.getCustomers().get(0).getPublic_id())
                                                .bind("contract_no", customers.getCustomers().get(0).getContract_no())
                                                .map(new CustomerMapper()).list();
             
            if (customer_db != null) {
                responseCode = 409;
                customers.setCustomers(customer_db);
                return customers;
            }
            
            //Get max id
            int max_id = handle.createQuery("SELECT MAX(id) FROM customers").map(IntegerMapper.FIRST).first();
            max_id++;
            
            handle.createStatement("INSERT INTO customers (id, history_id, public_id, name, street, city, postal_code, country, email, dic, contract_no, inserted_on, contact_name, phone, info)" 
                                 + " VALUES (:id, :history_id, :public_id, :name, :street, :city, :postal_code, :country, :email, :dic, :contract_no, :inserted_on, :contact_name, :phone, :info)")
                  .bind("id", max_id)
                  .bind("history_id", customers.getCustomers().get(0).getHistory_id())
                  .bind("public_id", customers.getCustomers().get(0).getPublic_id())
                  .bind("name", customers.getCustomers().get(0).getName())
                  .bind("street", customers.getCustomers().get(0).getStreet())
                  .bind("city", customers.getCustomers().get(0).getCity())  
                  .bind("postal_code", customers.getCustomers().get(0).getPostal_code())  
                  .bind("country", customers.getCustomers().get(0).getCountry())  
                  .bind("email", customers.getCustomers().get(0).getEmail())  
                  .bind("dic", customers.getCustomers().get(0).getDic())    
                  .bind("contract_no", customers.getCustomers().get(0).getContract_no())    
                  .bind("inserted_on", new Timestamp(System.currentTimeMillis()))
                  .bind("contact_name", customers.getCustomers().get(0).getContact_name())    
                  .bind("phone", customers.getCustomers().get(0).getPhone())   
                  .bind("info", customers.getCustomers().get(0).getInfo())
                  .execute();  

            handle.commit();
            responseCode = 201;
            return customers;
                  
        } finally {
            if (handle != null) { 
                handle.close();
            }    
        }    
    }
    
    @Override
    public List<Customer> getCustomerById(int id) {
                        
        Handle handle = null;
        List<Customer> customers = new ArrayList<Customer>(); 
        
        try {
            handle = jdbi.open();
            handle.begin();
                                        
            Customer customer_l = handle.createQuery("SELECT * FROM customers WHERE id = :id")
                                        .bind("id", id)
                                        .map(new CustomerMapper()).first();
            if (customer_l == null) {
                responseCode = 409;
            } else {
                responseCode = 200;
            }
            customers.add(customer_l);
            
            return customers;
            
        } finally {
            if (handle != null) { 
                handle.close();
            }    
        }            
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
