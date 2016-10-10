package com.cecep.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.InventoryMapper;
import com.cecep.model.Inventory;
import com.cecep.model.MedAccount;
import com.cecep.service.InventoryServiceI;
import com.cecep.util.EETemplate;
@Service("InventoryService")
public class InventoryServiceImpl implements InventoryServiceI {
	private  InventoryMapper  inventoryMapper;
	@Autowired
	public void setInventoryMapper(InventoryMapper inventoryMapper) {
		this.inventoryMapper = inventoryMapper;
	}
	public Map<String, Object> dataList(Inventory record) {
		Map<String, Object> map = new HashMap<String, Object>();
		//查出过期药品减库存  过期已去除
	/*	List<Inventory> list1=this.inventoryMapper.outTimeMedicine(record);
		if(list1!=null){
			for (Inventory inventory : list1) {
				record.setInventoryId(inventory.getInventoryId());
				record.setQuantity(inventory.getNumber());
				this.inventoryMapper.updateOutMedicine(record);
				this.inventoryMapper.updateType(inventory.getInvRecordId());
				
			}
		}*/
		List<Inventory> list = this.inventoryMapper.selectByPage(record);
		Integer count = this.inventoryMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}
	public Map<String, Object> save(Inventory record) {
		Map<String, Object> map = new HashMap<String, Object>();
		int cou = this.inventoryMapper.selectCou(record);
		int  inventoryId=0;
		if(cou == 0){
			 this.inventoryMapper.insert(record);
		}else{
			 this.inventoryMapper.updateByPrimaryKey(record);		
			 inventoryId=this.inventoryMapper.selectid(record);
		}
		
		if(inventoryId==0){
			 inventoryId= this.inventoryMapper.selectinsertid(record);
		}
		
		record.setInventory(inventoryId);
		this.inventoryMapper.insertdetailed(record);//存储入库记录
		map.put("msg", "入库成功！");
		map.put("success", true);
		return map;
	}
	
	
	public Map<String, Object> delete(Inventory record) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.inventoryMapper.deleteByPrimaryKey(record.getInventoryId());	
		map.put("success", true);
		return map;
	}
	public Map<String, Object> importMsg(Inventory record,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		EETemplate<Inventory>  eet=new  EETemplate<Inventory>();
		response.setContentType("octets/stream");
		Date current = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(current) + ".xls";
		response.addHeader("Content-Disposition","attachment;filename=" + fileName);
		OutputStream out=null;
		try {
			out = response.getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<Inventory> list =this.inventoryMapper.impotmsg(record);
		String[] headers={"药品名称","药品价格","生产厂家","药品描述","库存数量"};
		String[] fields={"medicineName","price","vendor","medicineDesc","quantity"};
		try {
			eet.callExportExcel("医药库存信息", headers, fields, list,out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("success", true);
		map.put("msg","导出成功！");
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return map;
	}
	
	public Map<String, Object> settlementForm(Inventory record) {
		Map<String, Object> map = new HashMap<String, Object>();
		String type= record.getType();
		record.setMoney1(record.getMoney());
		if(type.equals("1")){
			record.setMoney(new BigDecimal(0));
		}
		this.inventoryMapper.updateMoney(record);//代购结算
		this.inventoryMapper.saveMoneyMsg(record);//保存代购信息
		map.put("success", true);
		return map;
	}
	
	
	
	public Map<String, Object> inventoryMessage(Inventory record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inventory> list = this.inventoryMapper.selectByPage1(record);
		Integer count = this.inventoryMapper.selectCount1(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}
	public Map<String, Object> inventoryListGrid(Inventory record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inventory> list = this.inventoryMapper.selectByPage2(record);
		Integer count = this.inventoryMapper.selectCount2(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}
	
	public Map<String, Object> ExportExcel1(Inventory record,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		EETemplate<Inventory>  eet=new  EETemplate<Inventory>();
		response.setContentType("octets/stream");
		Date current = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(current) + ".xls";
		response.addHeader("Content-Disposition","attachment;filename=" + fileName);
		OutputStream out=null;
		try {
			out = response.getOutputStream();
			List<Inventory> list1 = this.inventoryMapper.selectByPage3(record);
			String[] headers={"药品名称","入库总数量","销售数量","库存数量"};
			String[] fields={"medicineName","number","cou","quantity"};
			eet.callExportExcel("药品入库明细", headers, fields, list1,out);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public Map<String, Object> ExportExcel2(Inventory record,HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		EETemplate<Inventory>  eet=new  EETemplate<Inventory>();
		response.setContentType("octets/stream");
		Date current = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(current) + ".xls";
		response.addHeader("Content-Disposition","attachment;filename=" + fileName);
		OutputStream out=null;
		try {
			out = response.getOutputStream();
			List<Inventory> list1 = this.inventoryMapper.selectByPage4(record);
			String[] headers={"药品名称","入库时间","入库数量"};
			String[] fields={"medicineName","invTime","number"};
			eet.callExportExcel("药品入库明细", headers, fields, list1,out,"yyyy-MM-dd HH:mm:ss","入库总数量:"+record.getNumber(),2);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> updateInventory(Inventory record) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.inventoryMapper.updateInventory(record);	
		map.put("success", true);
		map.put("msg", "修改成功！");
		return map;
	}
	
	

}
