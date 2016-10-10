package com.cecep.dao.mess;

import java.util.List;
import java.util.Map;

import com.cecep.model.RegionTree;
import com.cecep.model.mess.Region;

public interface RegionMapper {

	List<Region> select();
	
	List<Region> datalistXf(Region query);
	
	int totalXf(Region query);
	
	List<Region> datalist(Region query);

	int total(Region query);

	void delete(Integer depSerial);

	void update(Region record);

	void save(Region record);

	Region getById(Integer depSerial);
	
	int selectAcdepSerial();
	
	void updateAcdepSerial();

	List<RegionTree> selectAll(RegionTree record);

	List<Map<String, Object>> acdepType();

	void updateModuleId(String moduleId);

	Integer getDepSerial(String moduleId);

	int getDepOrder(Integer depParent);
	
	String selectDepNo(Integer depSerial);

	int getChildrenCount(Region record);

}
