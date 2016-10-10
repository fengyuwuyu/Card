package com.cecep.model.identityAuthor;

public class SsologinResponse {
	/** 校验状态位：0校验成功 1票据无效 2 IP非法 */
	private String flag;
	private String message;
	/** 登录用户 */
	private User user;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
