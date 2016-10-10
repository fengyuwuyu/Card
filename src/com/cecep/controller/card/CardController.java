package com.cecep.controller.card;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.cecep.model.DtCard;
import com.cecep.model.DtUser;

import com.cecep.service.DtCardServiceI;
import com.cecep.service.DtUserServiceI;

/**
 * 卡管理模块后台控制器
 * @date 2016-03-22
 * */
@Controller
@RequestMapping(value = "cardController")
@SessionAttributes(value = "currUser")
public class CardController {
	
	public static Object obj = new Object();
	private DtUserServiceI dtUserServiceI;
	private DtCardServiceI dtCardServiceI;
	
	@Autowired
	public void setDtUserServiceI(DtUserServiceI dtUserServiceI) {
		this.dtUserServiceI = dtUserServiceI;
	}

	@Autowired
	public void setDtCardServiceI(DtCardServiceI dtCardServiceI) {
		this.dtCardServiceI = dtCardServiceI;
	}

	/**
	 * 员工--分页查询（无卡）
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "dtUserDataList.do")
	@ResponseBody
	public Map<String, Object> dtUserDataList(DtUser record,HttpServletRequest request,HttpServletResponse response) {		
		record.setOpenCard(1);
		Map<String,Object> map = this.dtUserServiceI.dataList(record);
		return map;
	}
	
	/**
	 * 用户--分页查询（有卡）
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "dtUserDataList2.do")
	@ResponseBody
	public Map<String, Object> dtUserDataList2(DtUser record,HttpServletRequest request,HttpServletResponse response) {
		//卡片序号
		record.setCardXh(1);
		Map<String,Object> map = this.dtUserServiceI.dataList(record);
		return map;
	}
	
	/**
	 * 员工--主键查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "dtUserGetById.do")
	@ResponseBody
	public Map<String, Object> dtUserGetById(DtUser record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.dtUserServiceI.getById(record);
		return map;
	}
	
	/**
	 * 卡片--开卡
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "openCard.do")
	@ResponseBody
	public Map<String, Object> openCard(@ModelAttribute("currUser") DtUser currUser,DtCard record,HttpServletRequest request,HttpServletResponse response) {
		//用户IP
		record.setIp(request.getRemoteAddr());
		//用户姓名
		record.setGlyNo(currUser.getUserLname());
		synchronized(obj){
			Map<String,Object> map = this.dtCardServiceI.openCard(record);
			return map;
		}
	}
	
	/**
	 * 卡片--挂失
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "lockCard.do")
	@ResponseBody
	public Map<String, Object> lockCard(@ModelAttribute("currUser") DtUser currUser,DtCard record,HttpServletRequest request,HttpServletResponse response) {
		//用户IP
		record.setIp(request.getRemoteAddr());
		//用户姓名
		record.setGlyNo(currUser.getUserLname());
		synchronized(obj){
			Map<String,Object> map = this.dtCardServiceI.lockCard(record);
			return map;
		}
	}
	
	/**
	 * 卡片--读卡
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "readCard.do")
	@ResponseBody
	public Map<String, Object> readCard(DtCard record,HttpServletRequest request,HttpServletResponse response) {
		synchronized(obj){
			Map<String,Object> map = this.dtCardServiceI.readCard(record.getCardHao());
			return map;
		}
	}
	
	/**
	 * 卡片--解挂
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "unlockCard.do")
	@ResponseBody
	public Map<String, Object> unlockCard(@ModelAttribute("currUser") DtUser currUser,DtCard record,HttpServletRequest request,HttpServletResponse response) {
		//用户IP
		record.setIp(request.getRemoteAddr());
		//用户姓名
		record.setGlyNo(currUser.getUserLname());
		synchronized(obj){
			Map<String,Object> map = this.dtCardServiceI.unlockCard(record);
			return map;
		}
	}
	
	/**
	 * 卡片--退卡
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "returnCard.do")
	@ResponseBody
	public Map<String, Object> returnCard(@ModelAttribute("currUser") DtUser currUser,DtCard record,HttpServletRequest request,HttpServletResponse response) {
		//用户IP
		record.setIp(request.getRemoteAddr());
		//用户姓名
		record.setGlyNo(currUser.getUserLname());
		synchronized(obj){
			Map<String,Object> map = this.dtCardServiceI.returnCard(record);
			return map;
		}
	}
	
	/**
	 * 卡片--补卡
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "upCard.do")
	@ResponseBody
	public Map<String, Object> returnCard2(@ModelAttribute("currUser") DtUser currUser,DtCard record,String physicsCard,HttpServletRequest request,HttpServletResponse response) {
		//用户IP
		record.setIp(request.getRemoteAddr());
		//用户姓名
		record.setGlyNo(currUser.getUserLname());
		synchronized(obj){
			Map<String,Object> map = this.dtCardServiceI.upCard(record,physicsCard);
			return map;
		}
	}

}
