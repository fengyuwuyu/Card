package com.cecep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.MedicineMapper;
import com.cecep.model.Medicine;
import com.cecep.model.SysUser;
import com.cecep.service.MedicineServiceI;
@Service("medicineService")
public class MedicineServiceImpl  implements  MedicineServiceI {
	 MedicineMapper  medicineMapper;
	@Autowired
	public void setMedicineMapper(MedicineMapper medicineMapper) {
		this.medicineMapper = medicineMapper;
	}
	
	public Map<String, Object> dataList(Medicine record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Medicine> list = this.medicineMapper.selectByPage(record);
		Integer count = this.medicineMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	public Map<String, Object> save(Medicine record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer getMedicineId = record.getMedicineId();
		int  i=this.medicineMapper.selectCouBarCode(record);
		if(getMedicineId == null){
			if(i>0){
				map.put("success", false);
				map.put("msg", "药品条形码已存在！");
				return map;
			}
			this.medicineMapper.insert(record);		
		}else{
			this.medicineMapper.updateByPrimaryKey(record);		
		}			
		map.put("success", true);
		
		return map;
	}

	public Map<String, Object> getById(Medicine record) {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			Medicine medicineid = this.medicineMapper.selectByPrimaryKey(record.getMedicineId());
			resultMap.put("data", medicineid);	
			resultMap.put("success", true);
			return resultMap;
	}
	
	public Map<String, Object> delete(Medicine record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer  medicineId=record.getMedicineId();
		int cou=this.medicineMapper.selectCou(medicineId);//查询是否有库存
		if(cou>0){
			map.put("success", false);
			map.put("msg", "该药品存在库存数量不能删除！");
			return map;
		}else{
			this.medicineMapper.deleteByPrimaryKey(medicineId);	
			map.put("success", true);
		}
		return map;
	}

	public List<Map<String, Object>> load(SysUser record) {
		List<Map<String,Object>> list = medicineMapper.load(record);
		return list;
	}

	
	public List<Map<String, Object>> selectType(Medicine record) {
		List<Map<String,Object>> list = medicineMapper.selectType(record);
		return list;
	}
	
}
