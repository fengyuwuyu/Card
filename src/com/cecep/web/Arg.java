package com.cecep.web;

public class Arg {
	
	private String id;
	private Boolean isSuccess;
	private String message;
	
	
	public String getId() {
		return id;
	}
	public void setId(String object) {
		this.id = object;
	}
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Arg() {
		super();
	}
	
	public Arg(String id, Boolean isSuccess, String message) {
		super();
		this.id = id;
		this.isSuccess = isSuccess;
		this.message = message;
	}
	
	

}
