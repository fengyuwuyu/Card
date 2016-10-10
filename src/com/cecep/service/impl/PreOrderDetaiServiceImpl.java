package com.cecep.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.PreOrderDetailMapper;
import com.cecep.model.Medicine;
import com.cecep.model.PreOrderDetail;
import com.cecep.service.PreOrderDetaiServiceI;
@Service("preOrderDetaiService")
public class PreOrderDetaiServiceImpl implements PreOrderDetaiServiceI {
	PreOrderDetailMapper  preOrderDetailMapper;
	@Autowired
	public void setPreOrderDetailMapper(PreOrderDetailMapper preOrderDetailMapper) {
		this.preOrderDetailMapper = preOrderDetailMapper;
	}
	
	public Map<String, Object> save(PreOrderDetail record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer getPreOrderId = record.getPreOrderId1();
		if(getPreOrderId == null){
			this.preOrderDetailMapper.insertUser(record);		
		}else{
			this.preOrderDetailMapper.updateUser(record);		
		}			
		map.put("success", true);
		return map;
	}

	public Map<String, Object> dataList(PreOrderDetail record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PreOrderDetail> list = this.preOrderDetailMapper.selectByPage(record);
		Integer count = this.preOrderDetailMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}
	public Map<String, Object> getUserMedcineList(Integer preOrderId1,PreOrderDetail record) {
		Map<String, Object> map = new HashMap<String, Object>();
		record.setPreOrderId1(preOrderId1);
		List<PreOrderDetail> list = this.preOrderDetailMapper.selectByPage1(record);
		Integer count = this.preOrderDetailMapper.selectCount1(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	public Map<String, Object> getById(PreOrderDetail record) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PreOrderDetail preOrderId1 = this.preOrderDetailMapper.selectUser(record.getPreOrderId1());
		resultMap.put("data", preOrderId1);	
		resultMap.put("success", true);
		return resultMap;
	}
	
	public Map<String, Object> addMedicineMsg(PreOrderDetail record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer getPreOrderId = record.getPreOrderId();
		if(getPreOrderId == null){
			this.preOrderDetailMapper.insert(record);		
		}else{
			this.preOrderDetailMapper.updateByPrimaryKey(record);		
		}			
		map.put("success", true);
		return map;
	}

	public Map<String, Object> delete(PreOrderDetail record) {
		Map<String, Object> map = new HashMap<String, Object>();
		String  pre_type=this.preOrderDetailMapper.getType(record.getPreOrderId1());
		if(pre_type.equals("0")){
			this.preOrderDetailMapper.delete(record.getPreOrderId1());	
			this.preOrderDetailMapper.deleteByPrimaryKey(record.getPreOrderId1());
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("msg", "请选择正确数据删除！");	
		}
		return map;
	}
	
	public Map<String, Object> settlement(PreOrderDetail record) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		String  acctype=this.preOrderDetailMapper.getCardNumberType(record);
		record.setCardNumber(this.preOrderDetailMapper.getCardNumber(record));
		if(acctype.equals("1")){
			record.setTotalAmount(new  BigDecimal(0));	
		}
		BigDecimal  amount=this.preOrderDetailMapper.selectAmount(record);
		if(amount.compareTo(record.getTotalAmount())==-1){
			map1.put("success", false);
			map1.put("msg", "账户余额不足请充值！");
			return map1;
		}
		this.preOrderDetailMapper.updatePreOrder(record);
		this.preOrderDetailMapper.updateMedAccount(record);
		map1.put("success", true);
		map1.put("msg", "结算成功！");
		map1.put("totalAmount", record.getTotalAmount());
		map1.put("amount", this.preOrderDetailMapper.selectAmount(record));
		return map1;
	}

	public List<Map<String,Object>>  printPage(PreOrderDetail record) {
		String printIds=record.getIds();
		List<Integer>  printList=new ArrayList<Integer> ();
		String printId[]= printIds.split(",");
		for (String string : printId) {
			printList.add(Integer.parseInt(string));
		}
		record.setPrintList(printList);
		List<Map<String,Object>> list =this.preOrderDetailMapper.checkPrintMsg(record);
		return list;
	}
	
	

}
