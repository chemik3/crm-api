package net.snet.crm.api.dao;

import net.snet.crm.api.dao.map.RegionMapper;
import net.snet.crm.api.model.Region;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by admin on 22.12.13.
 */

@RegisterMapper(RegionMapper.class)
public interface RegionDao {
	@SqlQuery("SELECT id, name FROM regions")
	List<Region> findAllRegions();
}
