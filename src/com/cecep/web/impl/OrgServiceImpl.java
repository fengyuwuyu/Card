package com.cecep.web.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import com.cecep.model.MidDep;
import com.cecep.service.MidDepServiceI;
import com.cecep.web.Arg;
import com.cecep.web.OrgServiceI;

@WebService
public class OrgServiceImpl extends ApplicationObjectSupport implements
		OrgServiceI {
	
	private Logger log = Logger.getLogger(getClass());

	public String addOrUpdateOrg(String str) {
		// 构造WebService返回信息
		Arg arg = new Arg();
		String resultStr = null;
		try {
			log.debug("服务端接收组织字符串为：" + str);
			// 过滤回车符
			String orgStr = str.replace("\n", " ");
			// 将字符串转换为json对象
			JSONObject orgJson = JSONObject.fromObject(orgStr);
			arg.setId((String) orgJson.get("iu_code"));
			// 操作json对象属性
			orgJson.put("is_synchronized", 0);
			// 将json对象转换为java对象
			MidDep org = (MidDep) JSONObject.toBean(orgJson, MidDep.class);
			log.debug("转换为java对象为：" + org.toString());
			log.debug("部门编码：" + org.getIu_code());
			ApplicationContext applicationContext = this.getApplicationContext();
			MidDepServiceI midDepService = (MidDepServiceI) applicationContext
					.getBean("midDepService");
			String sortList = org.getSortList();
			log.debug("sortList------------------------------"+sortList);
			log.debug("disType-----------------------------"+org.getDisType());
			if (sortList != null && sortList.trim().length() > 0) {
				String[] arr1 = sortList.split(";");
				if (arr1 != null && arr1.length > 0) {
					for (int i = 0; i < arr1.length; i++) {
						String[] arr2 = arr1[i].split(":");
						Integer disType = Integer.valueOf(org.getDisType());
						if (disType == 1) {
							midDepService.updateDepOrder(arr2);
							midDepService.updateMidDepOrder(arr2);
						}else if (disType == 2) {
							String arr[] = new String[3];
							arr[0] = arr2[0];
							arr[1] = arr2[1];
							arr[2] = org.getIu_fullname();
							midDepService.updateUserOrder(arr);
							midDepService.updateMidUserOrder(arr);
						}
					}
				}
			} 
			// 调用后台服务，通知前端页面
			// SynchronizeDepServiceImpl depServiceImpl =
			// (SynchronizeDepServiceImpl)
			// applicationContext.getBean("synchronizeDepServiceImpl");
			// depServiceImpl.synchronize(SynchronizeDepServiceImpl.SYNCHRONIZEDEP);
			midDepService.save(org);
			arg.setMessage("同步成功！");
			arg.setIsSuccess(true);
			resultStr = jsonMess(arg);

		} catch (Exception e) {
			e.printStackTrace();
			arg.setMessage(e.toString());
			arg.setIsSuccess(false);
			resultStr = jsonMess(arg);
		}
		return resultStr;
	}

	public static String jsonMess(Arg arg) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date currentTime = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("id", arg.getId());
		map.put("isSuccess", arg.getIsSuccess());
		map.put("message", arg.getMessage());
		map.put("crtTime", sdf.format(currentTime));
		JSONArray array = JSONArray.fromObject(map);
		JSONObject object = new JSONObject();
		object.put("result", array);
		return object.toString();
	}

}
