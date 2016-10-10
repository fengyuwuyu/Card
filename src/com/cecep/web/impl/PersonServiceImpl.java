package com.cecep.web.impl;


import java.text.SimpleDateFormat;



import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.cecep.model.MidUser;
import com.cecep.service.MidUserServiceI;
import com.cecep.service.dwr.SynchronizeDepServiceImpl;
import com.cecep.web.Arg;
import com.cecep.web.PersonServiceI;
@WebService
public class PersonServiceImpl extends ApplicationObjectSupport implements PersonServiceI {

	public String addOrUpdatePerson(String str) {
		//构造WebService返回信息
		Arg arg = new Arg();
		String resultStr = null;
		try{
			System.out.println("服务端接收人员字符串为：" + str);	
			//过滤回车符
			String personStr = str.replace("\n", " "); 
			//将字符串转换为json对象
			JSONObject personJson = JSONObject.fromObject(personStr);
			arg.setId((String)personJson.get("dm"));
			//操作json对象属性			
			personJson.remove("staffNbdw");
			personJson.put("is_synchronized", 0);
			//将json对象转换为java对象
			MidUser person = (MidUser)JSONObject.toBean(personJson,MidUser.class);		
			System.out.println("转换为java对象为：" + person.toString());	
			ApplicationContext applicationContext = this.getApplicationContext();
			MidUserServiceI midUserService = (MidUserServiceI)applicationContext.getBean("midUserService");
			SynchronizeDepServiceImpl depServiceImpl = (SynchronizeDepServiceImpl) applicationContext.getBean("synchronizeDepServiceImpl");
			depServiceImpl.synchronize(SynchronizeDepServiceImpl.SYNCHRONIZEUSER);
			midUserService.save(person);
			arg.setMessage("同步成功！");
			arg.setIsSuccess(true);
			resultStr = jsonMess(arg);
		} catch(Exception e) {
			e.printStackTrace();
			arg.setMessage(e.toString());
			arg.setIsSuccess(false);			
			resultStr = jsonMess(arg);
		}
		return resultStr;
	}
	
	public static String jsonMess(Arg arg){		
		Map<String,Object> map = new HashMap<String,Object>();
		Date currentTime = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");		
		map.put("id",arg.getId());
		map.put("isSuccess",arg.getIsSuccess());
		map.put("message",arg.getMessage());	
		map.put("crtTime",sdf.format(currentTime));
	    JSONArray array = JSONArray.fromObject(map);
	    JSONObject object = new JSONObject();
	    object.put("result", array);	
	    return object.toString();
	}


}
