/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.snet.crm.api.jsonserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 *
 * @author chemik
 */
//public class CustomBooleanSerializer extends JsonSerializer<boolean> {  

//    //@Override
//    public void serialize(boolean value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
//        String tmp;
//        
//        if (value == true) {
//            tmp = "t";
//        } else {
//            tmp = "f";
//        }
//            
//        jgen.writeString(tmp);        
//    }    
//
//    @Override
//    public void serialize(<any> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
