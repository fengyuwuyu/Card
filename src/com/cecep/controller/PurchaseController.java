package com.cecep.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.DtUser;
import com.cecep.model.Medicine;
import com.cecep.model.PurOrder;
import com.cecep.service.PurchaseServiseI;

@Controller
@RequestMapping(value = "PurchaseController")
@SessionAttributes(value = "currUser")
public class PurchaseController {
	private  PurchaseServiseI  purchaseServise;

	@Autowired
	public void setPurchaseServise(PurchaseServiseI purchaseServise) {
		this.purchaseServise = purchaseServise;
	}
	
	/**
	 * 药品信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-31
	 */
	
	@RequestMapping(value = "medicineMsg.do")
	@ResponseBody
	public Map<String, Object> medicineMsg(Medicine record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.purchaseServise.medicineMsg(record);
		return map;
	}
	
	

	/**
	 * 员工买药信息
	 * @return Map
	 * @author FLD
	 * @date 2016-4-5
	 */
	
	@RequestMapping(value = "addPurchaseForm.do")
	@ResponseBody
	public Map<String, Object> addPurchaseForm(PurOrder record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.purchaseServise.addPurchaseForm(record);
		return map;
	}
	
	
	/**
	 * 员工信息
	 * @return Map
	 * @author FLD
	 * @date 2016-04-06
	 */
	
	@RequestMapping(value = "getUserData.do")
	@ResponseBody
	public Map<String, Object> getUserData(PurOrder record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.purchaseServise.getUserData(record);
		return map;
	}
	

	/**
	 * 查询员工购买记录
	 * @return Map
	 * @author FLD
	 * @date 2016-03-21
	 * */
	@RequestMapping(value = "dataList1.do")
	@ResponseBody
	public Map<String, Object> dataList1(PurOrder record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.purchaseServise.dataList1(record);
		return map;
	}
	
	@RequestMapping(value="userMessage.do") 
	public String inventoryList(){  
		return "view/medicine/userPurchaseMessage";  
	} 
	
	
	/**
	 * 查询出员工的医药账户购买记录
	 * @return Map
	 * @author FLD
	 * @date 2016-03-24
	 * */
	@RequestMapping(value = "userMessageGrid.do")
	@ResponseBody
	public Map<String, Object> userMessageGrid(PurOrder record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.purchaseServise.userMessageGrid(record);
		return map;
	}
	
	/**
	 * 消费信息导出
	 * @param record
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "ExportExcel1.do")
	@ResponseBody
	public Map<String, Object> ExportExcel1(Integer id,PurOrder record,HttpServletRequest request,HttpServletResponse response) {
		record.setDepParent(id);
		Map<String,Object> map = this.purchaseServise.ExportExcel1(record, request, response);
		return map;
	}
	
	/**
	 * 消费信息导出
	 * @param record
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "ExportExcel2.do")
	@ResponseBody
	public Map<String, Object> ExportExcel2(PurOrder record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.purchaseServise.ExportExcel2(record, request, response);
		return map;
	}
	
	
	@RequestMapping(value = "personalRecharge.do")
	@ResponseBody
	public Map<String, Object> personalRecharge(@ModelAttribute("currUser") DtUser currUser,PurOrder record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.purchaseServise.personalRecharge(currUser,record);
		return map;
	}
	
	
	/**
	 * 部门--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-02-23
	 * */
	@RequestMapping(value = "dataList2.do")
	@ResponseBody
	public Object dtDepDataList(Integer id,PurOrder record,HttpServletRequest request,HttpServletResponse response) {
		record.setDepParent(id);
		Object o = this.purchaseServise.dataList2(record);
		return o;
	}
	
	
	
	
}
