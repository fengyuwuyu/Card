package com.cecep.service.mess;

import java.util.List;
import java.util.Map;

import com.cecep.model.RegionTree;
import com.cecep.model.mess.Region;

public interface RegionServiceI {

	List<Region> select();

	Map<String, Object> datalistXf(Region query);

	Object datalist(Region query);
	
	Map<String, Object> delete(Region record);

	Map<String, Object> save(Region record);

	Map<String, Object> getById(Region record);

	List<RegionTree> selectAll();

	List<Map<String, Object>> acdepType();

	
}
