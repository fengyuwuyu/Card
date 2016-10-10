package com.cecep.service;

import java.util.List;
import java.util.Map;

import com.cecep.model.PreOrderDetail;


public interface PreOrderDetaiServiceI {
	Map<String,Object> save(PreOrderDetail record);
	Map<String,Object> dataList(PreOrderDetail record);	
	Map<String,Object> getById(PreOrderDetail record);
	Map<String,Object> delete(PreOrderDetail record);
	Map<String,Object> addMedicineMsg(PreOrderDetail record);
	Map<String, Object> getUserMedcineList(Integer preOrderId1,PreOrderDetail record);
	Map<String,Object> settlement(PreOrderDetail record);
	List<Map<String, Object>> printPage(PreOrderDetail record);
}
