/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.snet.crm.api.resources;

import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.metrics.annotation.Timed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.snet.crm.api.dao.RegionDao;
import net.snet.crm.api.model.Region;

/**
 *
 * @author chemik
 */

@Path("/regions/{regionId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegionSingleResource {
    
    private final RegionDao regionDao;

    public RegionSingleResource(RegionDao regionDao) {
            this.regionDao = regionDao;
    }

    @GET
    @Timed(name="get-requests")
    public Map<String, Object> returnRegion(@PathParam("regionId") LongParam regionId, @Context HttpServletResponse response) {

        final HashMap<String, Object> regions = new HashMap<>();
        final List<Region> region = regionDao.getRegionById(regionId.get().intValue());
        
        if (region.isEmpty()) {
            throw new WebApplicationException(Response.status(404).build());
        }
        
        regions.put("regions", region);            
        return regions;
    }    
    
    @DELETE
    @Timed(name="get-requests")
    public void deleteRegion(@PathParam("regionId") LongParam regionId) {

        int retCode = regionDao.geleteRegionById(regionId.get().intValue());
        
        if (retCode == 0) {
            throw new WebApplicationException(Response.status(404).build());
        }           
    }    
}
