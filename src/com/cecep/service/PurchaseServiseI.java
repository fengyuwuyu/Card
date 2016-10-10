package com.cecep.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cecep.model.DtUser;
import com.cecep.model.Medicine;
import com.cecep.model.PurOrder;

public interface PurchaseServiseI {
	Map<String,Object> medicineMsg(Medicine record);
	Map<String,Object> addPurchaseForm(PurOrder record);
	Map<String,Object> getUserData(PurOrder record);
	Map<String,Object> dataList1(PurOrder record);
	Map<String,Object> userMessageGrid(PurOrder record);
	Map<String,Object> ExportExcel1(PurOrder record,HttpServletRequest request,HttpServletResponse response);
	Map<String,Object> ExportExcel2(PurOrder record,HttpServletRequest request,HttpServletResponse response);
	Map<String,Object> personalRecharge(DtUser currUser,PurOrder record);	
	Object dataList2(PurOrder record);	
	
	
}
