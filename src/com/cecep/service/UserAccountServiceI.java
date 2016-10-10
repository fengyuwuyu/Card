package com.cecep.service;


import com.cecep.model.UserAccount;


public interface UserAccountServiceI {
	String save(UserAccount  user);
	String delete(String uid);
	String queryAccount(String  uid);
	String updateAccount(String  uid);
	String ReplyAccount(String  uid);
	String validate(UserAccount  user);
}
