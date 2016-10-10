package com.cecep.service.mess;

import java.util.Map;

import com.cecep.model.DtUser;
import com.cecep.model.mess.WhiteList;

public interface WhiteListServiceI {

	Map<String, Object> save(WhiteList query, DtUser currUser);

	Map<String, Object> delete(Integer [] ids);

	Map<String, Object> dataList(WhiteList query);

	Map<String, Object> saveList(WhiteList query,DtUser currUser);

	Map<String, Object> deleteByQuery(WhiteList query);


}
