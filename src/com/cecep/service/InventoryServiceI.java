package com.cecep.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cecep.model.Inventory;


public interface InventoryServiceI {
	Map<String,Object> dataList(Inventory record);	
	Map<String,Object> inventoryMessage(Inventory record);	
	Map<String,Object> inventoryListGrid(Inventory record);	
	Map<String,Object> save(Inventory record);
	Map<String,Object> delete(Inventory record);
	Map<String,Object> importMsg(Inventory record,HttpServletRequest request,HttpServletResponse response);
	Map<String,Object> settlementForm(Inventory record);
	Map<String,Object> ExportExcel1(Inventory record,HttpServletRequest request,HttpServletResponse response);
	Map<String,Object> ExportExcel2(Inventory record,HttpServletRequest request,HttpServletResponse response);
	Map<String,Object> updateInventory(Inventory record);
}
