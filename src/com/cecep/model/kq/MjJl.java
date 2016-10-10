package com.cecep.model.kq;

import java.util.Date;

public class MjJl {
	// "jl_sj",date1,"gate_bh",mbhs[random.nextInt(4)],"fx",0,"dev_serial","0010006","user_serial",
	// user.getUserSerial(),"user_card","99999999","jl_type",45,"sj",date1,"state",0
	private Date jl_sj;
	private String gate_bh;
	private int fx;
	private String dev_serial = "9999999";
	private Long user_serial;
	private String user_card;
	private Date sj;
	private int jl_type = 45;

	public MjJl(Date jl_sj, String gate_bh, int fx, 
			Long user_serial, String user_card, Date sj) {
		super();
		this.jl_sj = jl_sj;
		this.gate_bh = gate_bh;
		this.fx = fx;
		this.user_serial = user_serial;
		this.user_card = user_card;
		this.sj = sj;
	}

	public Date getJl_sj() {
		return jl_sj;
	}

	public void setJl_sj(Date jl_sj) {
		this.jl_sj = jl_sj;
	}

	public String getGate_bh() {
		return gate_bh;
	}

	public void setGate_bh(String gate_bh) {
		this.gate_bh = gate_bh;
	}

	public int getFx() {
		return fx;
	}

	public void setFx(int fx) {
		this.fx = fx;
	}

	public String getDev_serial() {
		return dev_serial;
	}

	public void setDev_serial(String dev_serial) {
		this.dev_serial = dev_serial;
	}

	public Long getUser_serial() {
		return user_serial;
	}

	public void setUser_serial(Long user_serial) {
		this.user_serial = user_serial;
	}

	public String getUser_card() {
		return user_card;
	}

	public void setUser_card(String user_card) {
		this.user_card = user_card;
	}

	public Date getSj() {
		return sj;
	}

	public void setSj(Date sj) {
		this.sj = sj;
	}

	public int getJl_type() {
		return jl_type;
	}

	public void setJl_type(int jl_type) {
		this.jl_type = jl_type;
	}

	@Override
	public String toString() {
		return "MjJl [jl_sj=" + jl_sj + ", gate_bh=" + gate_bh + ", fx=" + fx
				+ ", dev_serial=" + dev_serial + ", user_serial=" + user_serial
				+ ", user_card=" + user_card + ", sj=" + sj + ", jl_type="
				+ jl_type + "]";
	}

}
