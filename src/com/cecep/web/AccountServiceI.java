package com.cecep.web;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface AccountServiceI {
	
	@WebMethod
	public String  queryAccount(String accountname);
	@WebMethod
	public  String addAccount(String accountname);
	@WebMethod
	public String deleteAccount(String accountname);
	@WebMethod
	public String HangAccount(String accountname);
	@WebMethod
	public String ReplyAccount(String accountname);
	@WebMethod
	public String ValidateAccount(String accountname);


}
