package com.cecep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.MedicineTypeMapper;
import com.cecep.model.Medicine;
import com.cecep.model.MedicineType;
import com.cecep.service.MedicineTypeServiceI;
@Service("MedicineTypeService")
public class MedicineTypeServiceImpl implements MedicineTypeServiceI {
	MedicineTypeMapper   medicineTypeMapper ;
	@Autowired
	public void setMedicineTypeMapper(MedicineTypeMapper medicineTypeMapper) {
		this.medicineTypeMapper = medicineTypeMapper;
	}
	public Map<String, Object> dataList(MedicineType record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MedicineType> list = this.medicineTypeMapper.selectByPage(record);
		Integer count = this.medicineTypeMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	} 
	public Map<String, Object> save(MedicineType record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer typeId = record.getTypeId();
		if(typeId == null){
			this.medicineTypeMapper.insert(record);		
		}else{
			this.medicineTypeMapper.updateByPrimaryKey(record);		
		}			
		map.put("success", true);
		return map;
	}
	
	
	public Map<String, Object> getById(MedicineType record) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MedicineType typeId = this.medicineTypeMapper.selectByPrimaryKey(record.getTypeId());
		resultMap.put("data", typeId);	
		resultMap.put("success", true);
		return resultMap;
}

	public Map<String, Object> delete(MedicineType record) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.medicineTypeMapper.deleteByPrimaryKey(record.getTypeId());	
		map.put("success", true);
		return map;
	}
	

}
