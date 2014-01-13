package net.snet.crm.api.model;

/**
 * Created by admin on 22.12.13.
 */
public class Customer {
    
    private long id;
    private String name;

    public Customer() {
    }

    public Customer(String name) {
            this.name = name;
    }
    
    public long getId() {
            return id;
    }

    public void setId(long id) {
            this.id = id;
    }
        
    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }
    
            
}
