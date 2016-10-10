package com.cecep.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.Inventory;
import com.cecep.service.InventoryServiceI;



/*
 * BY  FLD
 * 药品库存
 * @date 2016-03-09
 */
@Controller
@RequestMapping(value = "InventoryController")
@SessionAttributes(value = "currUser")
public class InventoryController {
	private InventoryServiceI inventoryService;
	@Autowired
	public void setDepService(InventoryServiceI inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(Inventory record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.inventoryService.dataList(record);
		return map;
	}
	
	@RequestMapping(value="goPage.do") 
	public String goPage(@RequestParam("status") String status, HttpServletRequest request,ModelMap model){  
		model.put("status", status);
		return "view/medicine/medicineLoad";  
	} 
	@RequestMapping(value="addInventory.do")  
	public String addInventory(){  
		return "view/medicine/addInventory";  
	} 
	
	
	@RequestMapping(value = "addInventoryForm.do")
	@ResponseBody
	public Map<String, Object> save(Inventory record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.inventoryService.save(record);	
		return map;
	}
	
	@RequestMapping(value = "delete.do")
	@ResponseBody
	public Map<String, Object> delete(Inventory record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.inventoryService.delete(record);
		return map;
	}
	
	//导出库存信息
	@RequestMapping(value = "import.do")
	@ResponseBody
	public Map<String, Object> importMsg(Inventory record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.inventoryService.importMsg(record,request,response);
		return map;
	}
	
	@SuppressWarnings("resource")
	@RequestMapping(value = "downLoadFile.do")
	@ResponseBody
	public Map<String, Object> downLoadFile(Inventory record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = null;
		 String path =request.getParameter("path");
		   //filename 是文件名稱
		   File file = new File(path);
		   // 设置response的編码方式
		   response.setContentType("application/x-msdownload");
		   // 写明要下載的文件的大小
		   response.setContentLength((int) file.length());
		   // 设置附加文件名
		   String name="医药库存表.xls";
		   try {
			name = new String(name.getBytes("UTF-8"), "ISO-8859-1");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   response.setHeader("Content-Disposition", "attachment;filename="+name);
		   FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			 BufferedInputStream buff = new BufferedInputStream(fis);
			   byte[] b = new byte[1024];// 相当于我们的缓存
			   long k = 0;// 该值用于计算当前实际下載了多少字节
			   // 从response对象中得到输出流,准备下載
			   OutputStream myout = response.getOutputStream();
			   // 开始循环下載
			   while (k < file.length()) {
			    int j = buff.read(b, 0, 1024);
			    k += j;
			    // 将b中的數据写到客户端的内存
			    myout.write(b, 0, j);
			   }
			   myout.flush();
			  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="goTiXianPage.do") 
	public String goTiXianPage(){  
		return "view/medicine/settlement";  
	} 
	/**
	 * 代购提现结算保存信息
	 * @param record
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "settlementForm.do", method= RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> settlementForm(Inventory record) {
		Map<String, Object> map = this.inventoryService.settlementForm(record);	
		return map;
	}
	
	
	
	@RequestMapping(value = "inventoryMessage.do")
	@ResponseBody
	public Map<String, Object> inventoryMessage(Inventory record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.inventoryService.inventoryMessage(record);
		return map;
	}
	
	
	@RequestMapping(value="inventoryList.do") 
	public String inventoryList(){  
		return "view/medicine/inventoryList";  
	} 
	
	
	@RequestMapping(value = "inventoryListGrid.do")
	@ResponseBody
	public Map<String, Object> inventoryListGrid(Inventory record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.inventoryService.inventoryListGrid(record);
		return map;
	}
	
	/**
	 * 入库信息导出
	 * @param record
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "ExportExcel1.do")
	@ResponseBody
	public Map<String, Object> ExportExcel1(Inventory record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.inventoryService.ExportExcel1(record, request, response);
		return map;
	}
	
	/**
	 * 入库信息导出
	 * @param record
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "ExportExcel2.do")
	@ResponseBody
	public Map<String, Object> ExportExcel2(Inventory record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.inventoryService.ExportExcel2(record, request, response);
		return map;
	}
	
	/**
	 *  修改库存数量
	 * @param record
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "updateInventory.do")
	@ResponseBody
	public Map<String, Object> updateInventory(Inventory record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.inventoryService.updateInventory(record);
		return map;
	}
}
