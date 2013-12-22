package net.snet.crm.api.resources;

import com.yammer.metrics.annotation.Timed;
import net.snet.crm.api.dao.RegionDao;
import net.snet.crm.api.model.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 22.12.13.
 */
@Path("/regions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegionResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegionResource.class);

	private final RegionDao regionDao;

	public RegionResource(RegionDao regionDao) {
		this.regionDao = regionDao;
	}

	@GET
	@Timed(name="get-requests")
	public Map<String, Object> findAllRegions() {
		final HashMap<String, Object> regions = new HashMap<>();
		final List<Region> allRegions = regionDao.findAllRegions();
		regions.put("regions", allRegions);
		return regions;
	}
}
