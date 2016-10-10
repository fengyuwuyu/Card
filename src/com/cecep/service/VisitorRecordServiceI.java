package com.cecep.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cecep.model.VisitorRecord;

public interface VisitorRecordServiceI {
	
	Map<String,Object> dataList(VisitorRecord record);
	void export(VisitorRecord record, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
