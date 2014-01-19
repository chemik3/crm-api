package net.snet.crm.api.model;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chemik
 */
public class Customers {
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    
    public boolean checkField() {
        //Check obligatory fields
        if ( customers.get(0).getName().isEmpty() || customers.get(0).getPublic_id().isEmpty() || customers.get(0).getStreet().isEmpty() ||
             customers.get(0).getCity().isEmpty() || customers.get(0).getPostal_code().isEmpty() || customers.get(0).getCountry() == 0 ||
             customers.get(0).getEmail().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
     
    public int size() {
        return customers.size();           
    }
}

