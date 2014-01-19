package net.snet.crm.api.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.sql.Timestamp;
//import net.snet.crm.api.jsonserializer.CustomBooleanSerializer;

/**
 * Created by admin on 22.12.13.
 */
public class Customer {
    
    private long id;
    private long history_id;
    private String public_id;
    private String name;
    private String supplementary_name;
    private String street;
    private String city;
    private String postal_code;
    private int country;
    private String email;
    private String dic;
    private String contract_no;
    private String connection_spot;
    private Timestamp inserted_on;
    private int frequency;  
    private Timestamp lastly_billed;
    private boolean is_billed_after;
    private boolean deliver_by_email;
    private String deliver_copy_email;
    private boolean deliver_by_mail;
    private boolean is_auto_billing;
    private String info;
    private String contact_name;
    private String phone;
    private boolean is_active;
    private int status;
    private long shire_id;
    private int format;
    private boolean deliver_signed;
    private String symbol;
    private Timestamp updated;
    private String account_no;
    private String bank_no;
    private int variable;
    
    public Customer() {
    }
    
    public Customer(long id, long history_id, String public_id, String name, String supplementary_name, String street, String city, String postal_code,
                    int country, String email, String dic, String contract_no, String connection_spot, Timestamp inserted_on,
                    int frequency, Timestamp lastly_billed, Boolean is_billed_after, Boolean deliver_by_email, String deliver_copy_email,
                    Boolean deliver_by_mail, Boolean is_auto_billing, String info, String contact_name, String phone, Boolean is_active,
                    int status, Long shire_id, int format, Boolean deliver_signed, String symbol, Timestamp updated, String account_no,
                    String bank_no, int variable) {

        this.id = id;
        this.history_id = history_id;
        this.public_id = public_id;
        this.name = name;
        this.supplementary_name = supplementary_name;
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
        this.email = email;
        this.dic = dic;
        this.contract_no = contract_no;
        this.connection_spot = connection_spot;
        this.inserted_on = inserted_on;
        this.frequency = frequency ;
        this.lastly_billed = lastly_billed;
        this.is_billed_after = is_billed_after;
        this.deliver_by_email = deliver_by_email;
        this.deliver_copy_email = deliver_copy_email;
        this.deliver_by_mail = deliver_by_mail;
        this.is_auto_billing = is_auto_billing;
        this.info = info;
        this.contact_name = contact_name;
        this.phone = phone;
        this.is_active = is_active;
        this.status = status;
        this.shire_id = shire_id;
        this.format = format;
        this.deliver_signed = deliver_signed;
        this.symbol = symbol;
        this.updated = updated;
        this.account_no = account_no;    	
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
    
    public long getHistory_id() {
        return history_id;
    }

    public void setHistory_id(long history_id) {
        this.history_id = history_id;
    }
    
    public String getPublic_id() {
        return public_id;
    }

    public void setPublic_id(String public_id) {
        this.public_id = public_id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSupplementary_name() {
        return supplementary_name;
    }

    public void setSupplementary_name(String supplementary_name) {
        this.supplementary_name = supplementary_name;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;
    }
    
    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
    
    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }
    
    public String getContract_no() {
        return contract_no;
    }

    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }
    
    public String getConnection_spot() {
        return connection_spot;
    }

    public void setConnection_spot(String connection_spot) {
        this.connection_spot = connection_spot;
    }
    
    public Timestamp getInserted_on() {
        return inserted_on;
    }

    public void setInserted_on(Timestamp inserted_on) {
        this.inserted_on = inserted_on;
    }
    
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
    public Timestamp getLastly_billed() {
        return lastly_billed;
    }

    public void setLastly_billed(Timestamp lastly_billed) {
        this.lastly_billed = lastly_billed;
    }
    
    //@JsonSerialize(using = CustomBooleanSerializer.class)
    public boolean getIs_billed_after() {
        return is_billed_after;
    }

    public void setIs_billed_after(boolean is_billed_after) {
        this.is_billed_after = is_billed_after;
    }
    
    public boolean getDeliver_by_email() {
        return deliver_by_email;
    }

    public void setDeliver_by_email(boolean deliver_by_email) {
        this.deliver_by_email = deliver_by_email;
    }
    
    public String getDeliver_copy_email() {
        return deliver_copy_email;
    }

    public void setDeliver_copy_email(String deliver_copy_email) {
        this.deliver_copy_email = deliver_copy_email;
    }
    
    public boolean getDeliver_by_mail() {
        return deliver_by_mail;
    }

    public void setDeliver_by_mail(boolean deliver_by_mail) {
        this.deliver_by_mail = deliver_by_mail;
    }
    
    public boolean getIs_auto_billing() {
        return is_auto_billing;
    }

    public void setIs_auto_billing(boolean is_auto_billing) {
        this.is_auto_billing = is_auto_billing;
    }
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }  
    
    public long getShire_id() {
        return shire_id;
    }

    public void setShire_id(long shire_id) {
        this.shire_id = shire_id;
    }
    
    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }  
    
    public boolean getDeliver_signed() {
        return deliver_signed;
    }

    public void setDeliver_signed(boolean deliver_signed) {
        this.deliver_signed = deliver_signed;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
    
    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }
    
    public String getBank_no() {
        return bank_no;
    }

    public void setBank_no(String bank_no) {
        this.bank_no = bank_no;
    }
    
    public int getVariable() {
        return variable;
    }

    public void setVariable(int variable) {
        this.variable = variable;
    }
}
