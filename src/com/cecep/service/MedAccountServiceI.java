package com.cecep.service;

import java.util.Map;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cecep.model.DtUser;
import com.cecep.model.MedAccount;


public interface MedAccountServiceI {
	/**
	 * 医药账户
	 */
	
	
	Map<String,Object> dataList(MedAccount record);	
	Map<String,Object> dataList1(MedAccount record);
	Object dataList2(MedAccount record);	
	Map<String,Object> getById(MedAccount record);
	Map<String,Object> save(MedAccount record);
	
	/**
	 * 充值记录
	 */
	Map<String,Object> rechargeList(MedAccount record);	
	Map<String,Object> saveMoney(MedAccount record);
	int  cardnum(Integer userno);
	Map<String,Object> dtUserList(MedAccount record);
	Map<String,Object> updateMoney( MedAccount record);
	Map<String,Object> userMessageGrid(MedAccount record);	
	Map<String,Object> ExportExcel1(MedAccount record,HttpServletRequest request,HttpServletResponse response);
	Map<String,Object> ExportExcel2(MedAccount record,HttpServletRequest request,HttpServletResponse response);
	Map<String,Object> personalRecharge(DtUser currUser,MedAccount record);	
	
	
	
	
	
	
}
