package com.cecep.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.PurOrderMapper;
import com.cecep.model.DtUser;
import com.cecep.model.MedAccount;
import com.cecep.model.Medicine;
import com.cecep.model.PurOrder;
import com.cecep.service.PurchaseServiseI;
import com.cecep.util.EETemplate;
@Service("purchaseServise")
public class PurchaseServiseImpl implements PurchaseServiseI {
	PurOrderMapper  purOrderMapper;
	@Autowired
	public void setPurOrderMapper(PurOrderMapper purOrderMapper) {
		this.purOrderMapper = purOrderMapper;
	}
	
	
	public Map<String, Object> medicineMsg(Medicine record) {
		Map<String, Object> map =new  HashMap<String, Object>();
		Map<String, Object>  map1=this.purOrderMapper.medicineMsg(record);
		if(map1!=null){
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("msg", "请输入正确的条形码！");
		}
		map.put("map", map1);
		return map;
	}

	public Map<String, Object> addPurchaseForm(PurOrder record) {
		Map<String, Object> map = new HashMap<String, Object>();
		String accType1= record.getAccType1();//判断是否特殊用户   0 不是  1是
		record.setTotalAmount1(record.getTotalAmount());
		if(accType1.equals("1")){
			record.setTotalAmount(new BigDecimal(0) );
		}
		//卖出药品减库存
		
		this.purOrderMapper.insert(record);//添加药品购买记录
		record.setOrderId(this.purOrderMapper.selectinsertid(record));
		String ids[]= record.getMedIds().split(",");
		String qus[]= record.getQuantitys().split(",");
		for (int i = 0; i < ids.length; i++) {
			record.setMedId(Integer.parseInt(ids[i]));
			record.setQuantity(Integer.parseInt(qus[i]));
			int cou=this.purOrderMapper.selectInventory(record);//查询库存数量够不够
			if(cou==0){
				map.put("success", false);
				map.put("msg","【 "+this.purOrderMapper.selectMedName(record)+"】库存数量不足！");
				return map;
			}
			this.purOrderMapper.updateInventory(record);
			this.purOrderMapper.updateAmount(record);
			this.purOrderMapper.addPurchaseForm(record);//添加药品详细记录
		}
		record.setAccountId(this.purOrderMapper.selectAccountId(record));
		this.purOrderMapper.addRecord(record);//添加药品消费记录
		Double amount=this.purOrderMapper.selectAmount(record);
		map.put("amount", amount);
		map.put("success", true);
		return map;
	}

	public Map<String, Object> getUserData(PurOrder record) {
		Map<String, Object> map =new  HashMap<String, Object>();
		Map<String, Object> map1=this.purOrderMapper.getUserData(record);
		if(map1!=null){
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("msg", "请输入有效的员工卡号！");
		}
		map.put("map", map1);
		return map;
	}
	
	
	
	public Map<String, Object> dataList1(PurOrder record) {
		Map<String, Object> map = new HashMap<String, Object>();
		String  type=record.getSelectType();
		if("1".equals(type)){//公司
			List<PurOrder> list1 = this.purOrderMapper.selectByPage2(record);
			Integer count = this.purOrderMapper.selectCount2(record);
			map.put("rows", list1);
			map.put("total",count);
		}else{
			List<PurOrder> list1 = this.purOrderMapper.selectByPage1(record);
			Integer count = this.purOrderMapper.selectCount1(record);
			map.put("rows", list1);
			map.put("total",count);
		}
		return map;
	}
	
	public Map<String, Object> userMessageGrid(PurOrder record) {
		Map<String, Object> map = new HashMap<String, Object>();
		String type  =record.getSelectType();
		if(!"1".equals(type)){//个人
			List<PurOrder> list = this.purOrderMapper.selectByPage3(record);
			Integer count = this.purOrderMapper.selectCount3(record);
			map.put("rows", list);
			map.put("total",count);
		}else{
			List<PurOrder> list = this.purOrderMapper.selectByPage4(record);
			Integer count = this.purOrderMapper.selectCount4(record);
			map.put("rows", list);
			map.put("total",count);	
		}
		return map;
	}
	
	
	
	public Map<String, Object> ExportExcel1(PurOrder record,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String  type=record.getSelectType();
		EETemplate<PurOrder>  eet=new  EETemplate<PurOrder>();
		response.setContentType("octets/stream");
		Date current = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(current) + ".xls";
		response.addHeader("Content-Disposition","attachment;filename=" + fileName);
		OutputStream out=null;
		try {
			out = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if("1".equals(type)){//公司
			String [] str = record.getDepSerials().split(",");  
			List<Integer> list=new ArrayList<Integer>();
			for (String string : str) {
				list.add(Integer.parseInt(string));
			}
			record.setResult(list);
			List<PurOrder> list1 = this.purOrderMapper.selectByPage6(record);
			String[] headers={"单位","消费金额"};
			String[] fields={"depName","price"};
			try {
				eet.callExportExcel("单位消费信息", headers, fields, list1,out);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			List<PurOrder> list1 = this.purOrderMapper.selectByPage5(record);
			String[] headers={"员工姓名","工号","部门","消费金额"};
			String[] fields={"userLname","userNo","userDepname","price"};
			try {
				eet.callExportExcel("员工消费信息", headers, fields, list1,out);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public Map<String, Object> ExportExcel2(PurOrder record,HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String type  =record.getSelectType();
		EETemplate<PurOrder>  eet=new  EETemplate<PurOrder>();
		response.setContentType("octets/stream");
		Date current = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(current) + ".xls";
		response.addHeader("Content-Disposition","attachment;filename=" + fileName);
		OutputStream out=null;
		Map<String, Object> map1 = this.purOrderMapper.selectByUser(record);
		String userDepname=(String) map1.get("user_depname");
		String userLname=(String) map1.get("user_lname");
		try {
			out = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if(!"1".equals(type)){//个人
			List<PurOrder> list = this.purOrderMapper.selectByPage7(record);
			String[] headers={"药品名称","药品价格","购买数量","购买时间","消费总计"};
			String[] fields={"medicineName","price","quantity","createTime","total"};
			try {
				eet.callExportExcel(userLname+"消费信息", headers, fields, list,out,"yyyy-MM-dd HH:mm:ss","消费总计:"+record.getPrice()+"",4);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			List<PurOrder> list = this.purOrderMapper.selectByPage8(record);
			BigDecimal  len=new BigDecimal(0);
			for (PurOrder purOrder : list) {
				len=len.add(purOrder.getTotalPrice());
			}
			String[] headers={"员工姓名","工号","消费总计"};
			String[] fields={"userLname","userNo","totalPrice"};
			
			try {
				eet.callExportExcel(userDepname+"消费信息", headers, fields, list,out,"yyyy-MM-dd HH:mm:ss","消费总计:"+len,2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}


	public Map<String, Object> personalRecharge(DtUser currUser, PurOrder record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Long user=currUser.getUserSerial();
		record.setUserSerial1(user);
		List<MedAccount> list = this.purOrderMapper.personalRecharge(record);
		Integer count = this.purOrderMapper.personalRechargeCou(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}


	public Object dataList2(PurOrder record) {
		if(record.getDepParent() ==null) {
			record.setDepParent(0);
			Map<String, Object> map = new HashMap<String, Object>();
			List<PurOrder> list = this.purOrderMapper.selectByPage2(record);
			Integer count = this.purOrderMapper.selectCount2(record);
			map.put("rows", list);
			map.put("total",count);
			return map;
		}else {
			List<PurOrder> list = this.purOrderMapper.selectByPage2(record);
			return list;
		}
	}
	
	
	
}
