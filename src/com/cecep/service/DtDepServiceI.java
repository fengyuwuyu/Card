package com.cecep.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.kq.TreeDep;


public interface DtDepServiceI {
	
	Object dataList(DtDep record);	
    List<Map<String,Object>> load(Integer depParent);   
    List<Map<String,Object>> load(DtDep record);  
    List<Map<String, Object>> loadByPrvilege(HttpServletRequest request,Integer depParent, DtUser currUser);
	void getChildrenDepSerial(Long depSerial,Set<Long> list);
	String getRootDepSerial(String depNo);
    
	/** 清空dt_dep表，请勿调用*/
	Map<String,Object> clearDtDDep();
	/** 若该部门及其全部子部门下均不存在员工，则删除*/
	Map<String,Object> deleteNoUserDep();
	Map<String, Object> dtDepDelete(Long depSerial);
	/** 返回部门树形结构中的全部数据*/
	List<TreeDep> getAll();
	Map<String, Object> getById(DtDep query);
	Map<String, Object> save(DtDep query);
}
