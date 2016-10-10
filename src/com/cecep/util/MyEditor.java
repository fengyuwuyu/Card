package com.cecep.util;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;


public class MyEditor extends PropertyEditorSupport  {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {			
		if (!StringUtils.hasText(text)) {		
			setValue(null);
		}else {
			setValue(Integer.parseInt(text));//这句话是最重要的，目的是通过传入参数的类型来匹配相应的dataBind
		}
	}


	@Override
	public String getAsText() {		
		return getValue().toString();
	}
		
}