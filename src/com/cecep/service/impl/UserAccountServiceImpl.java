package com.cecep.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.UserAccountMapper;
import com.cecep.model.UserAccount;
import com.cecep.service.UserAccountServiceI;
import com.cecep.web.Arg;

@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountServiceI {
	private UserAccountMapper userAccountMapper;

	@Autowired
	public void setUserAccountMapper(UserAccountMapper userAccountMapper) {
		this.userAccountMapper = userAccountMapper;
	}

	Arg arg = new Arg();

	public String save(UserAccount record) {
		String message = "";
		int count = this.userAccountMapper.selectUserCount(record.getUid());
		int cou = 0;
		int i = this.userAccountMapper.selectSn(record);
		if (i == 0) {
			if (count > 0) {
				cou = this.userAccountMapper.updateByPrimaryKey(record);
			} else if (count == 0) {
				cou = this.userAccountMapper.insert(record);
			}
			if (cou > 0) {
				arg.setIsSuccess(true);
				message = "创建成功";
			} else {
				arg.setIsSuccess(false);
				message = "创建失败";
			}
		} else {
			arg.setIsSuccess(false);
			message = "创建失败,员工号已存在";
		}

		arg.setId(record.getUid());
		arg.setMessage(message);
		String resultStr = jsonMess(arg);
		return resultStr;
	}

	public String delete(String uid) {
		int count = this.userAccountMapper.selectUserCount(uid);
		String message = "";
		if (count > 0) {
			int cou = this.userAccountMapper.deleteByPrimaryKey(uid);
			if (cou > 0) {
				arg.setIsSuccess(true);
				message = "删除成功";
			} else {
				arg.setIsSuccess(false);
				message = "账号存在,删除失败";
			}
		} else {
			arg.setIsSuccess(false);
			message = "账号不存在,删除失败";
		}
		arg.setId(uid);
		arg.setMessage(message);
		String resultStr = jsonMess(arg);
		return resultStr;
	}

	public String queryAccount(String uid) {
		int count = this.userAccountMapper.query(uid);
		String message = "";
		if (count > 0) {
			arg.setIsSuccess(true);
			message = "查询成功,账号存在";
		} else {
			arg.setIsSuccess(false);
			message = "查询失败,账号不存在";
		}
		arg.setId(uid);
		arg.setMessage(message);
		String resultStr = jsonMess(arg);
		return resultStr;
	}

	public String updateAccount(String uid) {
		int count = this.userAccountMapper.selectUserCount(uid);
		String message = "";
		if (count > 0) {
			int cou = this.userAccountMapper.updateHang(uid);
			if (cou > 0) {
				arg.setIsSuccess(true);
				message = "挂起成功";
			} else {
				arg.setIsSuccess(false);
				message = "账号存在,挂起失败";
			}
		} else {
			arg.setIsSuccess(false);
			message = "账号不存在,挂起失败";
		}
		arg.setId(uid);
		arg.setMessage(message);
		String resultStr = jsonMess(arg);
		return resultStr;
	}

	/**
	 * 账号的回复
	 */
	public String ReplyAccount(String uid) {
		int count = this.userAccountMapper.selectUserCount(uid);
		String message = "";
		if (count > 0) {
			int cou = this.userAccountMapper.ReplyAccount(uid);
			if (cou > 0) {
				arg.setIsSuccess(true);
				message = "回复成功";
			} else {
				arg.setIsSuccess(false);
				message = "账号存在,回复失败";
			}
		} else {
			arg.setIsSuccess(false);
			message = "账号不存在,回复失败";
		}
		arg.setId(uid);
		arg.setMessage(message);
		String resultStr = jsonMess(arg);
		return resultStr;
	}

	public String validate(UserAccount user) {
		int count = this.userAccountMapper.selectValidateCount(user);
		String message = "";
		if (count > 0) {
			arg.setIsSuccess(true);
			message = "校验成功";
		} else {
			arg.setIsSuccess(false);
			message = "校验失败";
		}
		arg.setId(user.getUid());
		arg.setMessage(message);
		String resultStr = jsonMess(arg);
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
