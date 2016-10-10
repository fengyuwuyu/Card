package com.cecep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.DtUser;
import com.cecep.model.SysMenu;
import com.cecep.service.DtUserServiceI;
import com.cecep.util.MapUtils;
/**
 * 登录及跳转首页控制器
 * @date 2016-03-22
 * */
@Controller
@RequestMapping(value = "main")
@SessionAttributes(value = {"captcha","currUser"})
public class MainController {
	
	private DtUserServiceI dtUserServiceI;

	@Autowired
	public void settUserServiceI(DtUserServiceI dtUserServiceI) {
		this.dtUserServiceI = dtUserServiceI;
	}	
	
	/**
	 * 登陆
	 * @return Map
	 * @author BYP
	 * @date 2016-02-18
	 * */
	@RequestMapping(value = "login.do")
	@ResponseBody
	public Map<String, Object> login(DtUser record,HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		Map<String, Object> map = new HashMap<String, Object>();
		DtUser user = this.dtUserServiceI.login(record);
			if(user!= null) {
				if(user.getUuaccountstatus()!=null&&"1".equals(user.getUuaccountstatus())){
					map.put("success", false);
					map.put("msg", "账号被挂起，请联系管理员！");
				}else{
					if(!user.getUserNo().equals("00000000")) {	
						map.put("success", true);
						model.addAttribute("currUser", user);	
						int count = this.dtUserServiceI.needServerNotify(user.getUserSerial());
						request.getSession().setAttribute("needServerNotify", count);
					}else {
						map.put("success", false);
						map.put("msg", "00000000工号员工禁止登录！");
					}		
				}
			}else {
				map.put("success", false);
				map.put("msg", "用户名或密码错误！");
			}
					
		return map;
	}
	
	/**
	 * 登陆后跳转首页
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "main.html")
	public String main(@ModelAttribute("currUser") DtUser currUser,HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		List<SysMenu> list = this.dtUserServiceI.getMenuTree(currUser.getRoleId());
		model.addAttribute("menuList", list);
		return "view/main/main";
	}
	
	/**
	 * 查询密码
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "getPwd.do")
	@ResponseBody
	public Map<String, Object> getPwd(@ModelAttribute("currUser") DtUser currUser,HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		Map<String, Object> map = this.dtUserServiceI.getPwd(currUser);
		return map;
	}
	
	/**
	 * 更改密码
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "editPwd.do")
	@ResponseBody
	public Map<String, Object> editPwd(@ModelAttribute("currUser") DtUser currUser,String password,String oldUserPassword, HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		currUser.setPassword(password);
		Map<String, Object> map = this.dtUserServiceI.editPwd(currUser);
		return map;
	}
	
	/**
	 * 更改密码
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "checkPswd.do")
	@ResponseBody
	public Map<String, Object> checkPswd(@ModelAttribute("currUser") DtUser currUser,String oldUserPassword, HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		currUser.setPassword(oldUserPassword);
		System.out.println(currUser.getPassword());
		DtUser user = this.dtUserServiceI.login(currUser);
		if(user==null){
			return MapUtils.createFailedMap("msg","原密码输入错误！");
		}
		return MapUtils.createSuccessMap();
	}
	
}
