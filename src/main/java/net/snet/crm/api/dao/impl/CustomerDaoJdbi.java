/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.snet.crm.api.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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
        String sql;
        
        //Only one customer per request is acceptable + check obligatory fields
        if (customers.size() != 1 || customers.checkField() == false) {
            responseCode = 400;
            return customers;
        }          
        
        try {
            handle = jdbi.open();
            handle.begin();
            
            List<Customer> customer_db = handle.createQuery("SELECT * FROM customers WHERE public_id = :public_id or contract_no = :contract_no")
                                               .bind("public_id", customers.getCustomers().get(0).getPublic_id())
                                               .bind("contract_no", customers.getCustomers().get(0).getContract_no())
                                               .map(new CustomerMapper()).list();
             
            if (!customer_db.isEmpty()) {
                responseCode = 409;
                customers.setCustomers(customer_db);
                return customers;
            }
            
            //Get max id
            int max_id = handle.createQuery("SELECT MAX(id) FROM customers").map(IntegerMapper.FIRST).first();
            max_id++;
            
            sql = "INSERT INTO customers (id, history_id, public_id, name, street, city, postal_code, country, email, dic, contract_no,"
                + " connection_spot, inserted_on, frequency, lastly_billed, is_billed_after, deliver_by_email, deliver_copy_email,"
                + " deliver_by_mail, is_auto_billing, info, contact_name, phone, is_active, status, shire_id, format, deliver_signed, symbol,"
                + " account_no, bank_no, variable)" 
                + " VALUES (:id, :history_id, :public_id, :name, :street, :city, :postal_code, :country, :email, :dic, :contract_no,"
                + " :connection_spot, :inserted_on, :frequency, :lastly_billed, :is_billed_after, :deliver_by_email, :deliver_copy_email,"
                + " :deliver_by_mail, :is_auto_billing, :info, :contact_name, :phone, :is_active, :status, :shire_id, :format, :deliver_signed, :symbol,"
                + " :account_no, :bank_no, :variable)";
            
            handle.createStatement(sql)
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
                  .bind("connection_spot", customers.getCustomers().get(0).getConnection_spot())   
                  .bind("inserted_on", new Timestamp(System.currentTimeMillis()))
                  .bind("frequency", customers.getCustomers().get(0).getFrequency())  
                  .bind("lastly_billed", customers.getCustomers().get(0).getLastly_billed())
                  .bind("is_billed_after", customers.getCustomers().get(0).getIs_billed_after())
                  .bind("deliver_by_email", customers.getCustomers().get(0).getDeliver_by_email())  
                  .bind("deliver_copy_email", customers.getCustomers().get(0).getDeliver_copy_email())   
                  .bind("deliver_by_mail", customers.getCustomers().get(0).getDeliver_by_mail())    
                  .bind("is_auto_billing", customers.getCustomers().get(0).getIs_auto_billing())   
                  .bind("info", customers.getCustomers().get(0).getInfo())     
                  .bind("contact_name", customers.getCustomers().get(0).getContact_name())    
                  .bind("phone", customers.getCustomers().get(0).getPhone())   
                  .bind("is_active", customers.getCustomers().get(0).getIs_active())
                  .bind("status", customers.getCustomers().get(0).getStatus()) 
                  .bind("shire_id", customers.getCustomers().get(0).getShire_id()) 
                  .bind("format", customers.getCustomers().get(0).getFormat())  
                  .bind("deliver_signed", customers.getCustomers().get(0).getDeliver_signed())  
                  .bind("symbol", customers.getCustomers().get(0).getSymbol())
                  .bind("account_no", customers.getCustomers().get(0).getAccount_no())  
                  .bind("bank_no", customers.getCustomers().get(0).getBank_no())  
                  .bind("variable", customers.getCustomers().get(0).getVariable())    
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
