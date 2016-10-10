package com.cecep.controller;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.cecep.util.MyEditor;

/**
 * 基本控制器（用于业务模块控制器继承）
 * @date 2016-03-22
 * */
public class BaseController {

	@InitBinder  
	protected void initBinder(WebDataBinder binder) {  
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Integer[].class,new MyEditor()); 
	}  

}
