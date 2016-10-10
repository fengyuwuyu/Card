package com.cecep.service.mess;

import java.util.List;
import java.util.Map;

import com.cecep.model.DtUser;
import com.cecep.model.mess.MessQuery;

public interface MessConsumeServiceI {

	Map<String,Object> dataList(MessQuery query,DtUser currUser);

	Map<String, Object> statistics(MessQuery query,DtUser currUser);

	Map<String, Object> depNum(final DtUser currUser,final MessQuery query);

	List<Map<String, Object>> loadAcdep();

}
