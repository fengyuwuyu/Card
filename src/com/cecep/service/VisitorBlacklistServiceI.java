package com.cecep.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.cecep.model.DtCard;
import com.cecep.model.DtUser;
import com.cecep.model.VisitorBlacklist;
import com.cecep.model.VisitorRecord;

public interface VisitorBlacklistServiceI {

	Map<String,Object> dataList(VisitorBlacklist record);
	Map<String,Object> getById(VisitorBlacklist record);
	Map<String,Object> save(VisitorBlacklist vistor,DtUser user);
	Map<String,Object> delete(VisitorBlacklist record);
	Map<String, Object> openCard(VisitorRecord visitor,DtCard card, Integer userDep);
	Map<String, Object> returnCard(DtCard record);
	void returnCard2();
	/** 退掉达到截止日期的卡*/
	void returnCard3();
	void export(VisitorBlacklist record, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
