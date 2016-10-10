package com.cecep.model.mess;

public class MessQuerySummary {

	private String remainMoney = "";
	private String tradeDate;

	public String getRemainMoney() {
		return remainMoney;
	}

	public void setRemainMoney(String remainMoney) {
		this.remainMoney = remainMoney==null?null:remainMoney.trim();
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

}
