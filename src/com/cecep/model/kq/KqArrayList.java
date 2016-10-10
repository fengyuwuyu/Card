package com.cecep.model.kq;

import java.util.ArrayList;

public class KqArrayList extends ArrayList<String> {
	
	private static final long serialVersionUID = 1L;

	private int num = 0;
	private StringBuilder stringValue = new StringBuilder();

	@Override
	public boolean add(String e) {
		if (e == null || "".equals(e.trim())) {
			return false;
		}
		num++;
		if(e.endsWith("打")){
			e = e+"卡";
		}
		if (num == 2) {
			e = e + ",<br>";
			num = 0;
		}else{
			e = e+",";
		}
		stringValue.append(e);
		return super.add(e);
	}

	public String getStringValue() {
		if(stringValue==null){
			return null;
		}
		String res = stringValue.toString();
		if("".equals(res)){
			return "";
		}
		
		return (size()%2==0)?res.substring(0, res.length()-5):res.substring(0, res.length()-1);
	}

}