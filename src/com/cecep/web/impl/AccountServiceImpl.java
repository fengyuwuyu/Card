package com.cecep.web.impl;

import javax.jws.WebService;

import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import com.cecep.model.UserAccount;
import com.cecep.service.UserAccountServiceI;
import com.cecep.web.AccountServiceI;

/**
 * 账号同步
 * 
 * @author FLD 2016-7-18
 * 
 */

@WebService
public class AccountServiceImpl extends ApplicationObjectSupport implements
		AccountServiceI {
	String resultStr = null;

	/**
	 * 1.1账号查询接口 查询接口用于在管理员新建帐号时，将输入的帐号与系统中已有帐号进行比较，避免产生重复帐号。
	 */

	public String queryAccount(String uid) {
		ApplicationContext applicationContext = this.getApplicationContext();
		UserAccountServiceI dtUser = (UserAccountServiceI) applicationContext
				.getBean("userAccountService");
		// 将字符串转换为json对象
		String userStr = uid.replace("\n", " ");
		JSONObject userJson = JSONObject.fromObject(userStr);
		UserAccount user = (UserAccount) JSONObject.toBean(userJson,
				UserAccount.class);
		resultStr = dtUser.queryAccount(user.getUid());
		return resultStr;
	}

	/**
	 * 1.2账号新建接口 新建接口用于管理员为用户创建一个新的XX系统帐号时使用。
	 */

	public String addAccount(String str) {
		ApplicationContext applicationContext = this.getApplicationContext();
		UserAccountServiceI dtUser = (UserAccountServiceI) applicationContext
				.getBean("userAccountService");
		String userStr = str.replace("\n", " ");
		// 将字符串转换为json对象
		JSONObject userJson = JSONObject.fromObject(userStr);
		UserAccount user = (UserAccount) JSONObject.toBean(userJson,
				UserAccount.class);
		System.out.println("转换为java对象为：" + user.toString());
		System.out.println("人员工号：" + user.getSn());
		resultStr = dtUser.save(user);
		return resultStr;
	}

	/**
	 * 账号的删除
	 */

	public String deleteAccount(String uid) {
		ApplicationContext applicationContext = this.getApplicationContext();
		UserAccountServiceI dtUser = (UserAccountServiceI) applicationContext
				.getBean("userAccountService");
		// 将字符串转换为json对象
		String userStr = uid.replace("\n", " ");
		JSONObject userJson = JSONObject.fromObject(userStr);
		UserAccount user = (UserAccount) JSONObject.toBean(userJson,
				UserAccount.class);
		resultStr = dtUser.delete(user.getUid());
		return resultStr;
	}

	/**
	 * 账号的挂起
	 */

	public String HangAccount(String uid) {
		ApplicationContext applicationContext = this.getApplicationContext();
		UserAccountServiceI dtUser = (UserAccountServiceI) applicationContext
				.getBean("userAccountService");
		// 将字符串转换为json对象
		String userStr = uid.replace("\n", " ");
		JSONObject userJson = JSONObject.fromObject(userStr);
		UserAccount user = (UserAccount) JSONObject.toBean(userJson,
				UserAccount.class);
		resultStr = dtUser.updateAccount(user.getUid());
		return resultStr;
	}

	/**
	 * 账号的回复
	 */

	public String ReplyAccount(String uid) {
		ApplicationContext applicationContext = this.getApplicationContext();
		UserAccountServiceI dtUser = (UserAccountServiceI) applicationContext
				.getBean("userAccountService");
		String userStr = uid.replace("\n", " ");
		// 将字符串转换为json对象
		JSONObject userJson = JSONObject.fromObject(userStr);
		UserAccount user = (UserAccount) JSONObject.toBean(userJson,
				UserAccount.class);
		resultStr = dtUser.ReplyAccount(user.getUid());
		return resultStr;
	}

	public String ValidateAccount(String uid) {
		ApplicationContext applicationContext = this.getApplicationContext();
		UserAccountServiceI dtUser = (UserAccountServiceI) applicationContext
				.getBean("userAccountService");
		// 将字符串转换为json对象
		String userStr = uid.replace("\n", " ");
		// 将字符串转换为json对象
		JSONObject userJson = JSONObject.fromObject(userStr);
		UserAccount user = (UserAccount) JSONObject.toBean(userJson,
				UserAccount.class);
		resultStr = dtUser.validate(user);
		return resultStr;
	}

}
