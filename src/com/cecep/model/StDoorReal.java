package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 门实体类(st_door_real表)
 * 
 * @date 2016-03-21
 * */
public class StDoorReal extends PageModel {

	/** 门的编号，根据当前操作时间生成 */
	private String bh;
	private String doorName;
	/** 门序号，自增主键 */
	private Integer xh;
	/** 设备编号 */
	private String devSerial;
	private Integer fx;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sj;
	/** 操作日志 */
	private String operateLog;
	/** 设备ip */
	private String ip;
	/** 操作员 */
	private String operator;
	private Integer lx;
	// private Integer fxFlg;
	// private Integer mjgz1;
	// private Integer mjgz2;
	// private Integer mjgz3;
	// private Integer mjgz4;
	// private Integer dButton;
	// private Integer dDelay;
	// private Integer dLock;
	// private Integer dDotime;
	// private Integer dXPoint;
	// private Integer dYPoint;
	// private Integer cFirst;
	// private Integer cMore;
	// private Integer cGly;
	// private Integer mjgzFirst;
	// private Integer mjgzMore;
	// private Integer groupFirst;
	// private Integer groupGly;
	// private Integer groupMore1;
	// private Integer groupMore2;
	// private Integer groupMore3;
	// private Integer groupMore4;
	// private Integer userMore1;
	// private Integer userMore2;
	// private Integer userMore3;
	// private Integer userMore4;
	// private Integer isMagnetism;
	// private Integer openAlarm;
	// private Integer isForcein;
	// private Integer cGlypass;
	// private Integer alwaysOpen;

	private String devHead;
	private String devHead2;
	/** 门锁接口，1:1号门锁接口，2:2号门锁接口 */
	private Integer devOrder;

	/**
	 * 关联属性
	 * */
	private Integer depSerial;// 场所主键
	private String depName;// 场所名称
	private String devName;// 设备名称(门禁控制器)

	public Integer getLx() {
		return lx;
	}

	public void setLx(Integer lx) {
		this.lx = lx;
	}

	public Integer getDevOrder() {
		return devOrder;
	}

	public void setDevOrder(Integer devOrder) {
		this.devOrder = devOrder;
	}

	public String getDevHead() {
		return devHead;
	}

	public void setDevHead(String devHead) {
		this.devHead = devHead;
	}

	public String getDevHead2() {
		return devHead2;
	}

	public void setDevHead2(String devHead2) {
		this.devHead2 = devHead2;
	}

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getDoorName() {
		return doorName;
	}

	public void setDoorName(String doorName) {
		this.doorName = doorName == null ? null : doorName.trim();
	}

	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh == null ? null : bh.trim();
	}

	// public Integer getFxFlg() {
	// return fxFlg;
	// }
	//
	// public void setFxFlg(Integer fxFlg) {
	// this.fxFlg = fxFlg;
	// }
	//
	// public Integer getMjgz1() {
	// return mjgz1;
	// }
	//
	// public void setMjgz1(Integer mjgz1) {
	// this.mjgz1 = mjgz1;
	// }
	//
	// public Integer getMjgz2() {
	// return mjgz2;
	// }
	//
	// public void setMjgz2(Integer mjgz2) {
	// this.mjgz2 = mjgz2;
	// }
	//
	// public Integer getMjgz3() {
	// return mjgz3;
	// }
	//
	// public void setMjgz3(Integer mjgz3) {
	// this.mjgz3 = mjgz3;
	// }
	//
	// public Integer getMjgz4() {
	// return mjgz4;
	// }
	//
	// public void setMjgz4(Integer mjgz4) {
	// this.mjgz4 = mjgz4;
	// }
	//
	// public Integer getdButton() {
	// return dButton;
	// }
	//
	// public void setdButton(Integer dButton) {
	// this.dButton = dButton;
	// }
	//
	// public Integer getdDelay() {
	// return dDelay;
	// }
	//
	// public void setdDelay(Integer dDelay) {
	// this.dDelay = dDelay;
	// }
	//
	// public Integer getdLock() {
	// return dLock;
	// }
	//
	// public void setdLock(Integer dLock) {
	// this.dLock = dLock;
	// }
	//
	// public Integer getdDotime() {
	// return dDotime;
	// }
	//
	// public void setdDotime(Integer dDotime) {
	// this.dDotime = dDotime;
	// }
	//
	// public Integer getdXPoint() {
	// return dXPoint;
	// }
	//
	// public void setdXPoint(Integer dXPoint) {
	// this.dXPoint = dXPoint;
	// }
	//
	// public Integer getdYPoint() {
	// return dYPoint;
	// }
	//
	// public void setdYPoint(Integer dYPoint) {
	// this.dYPoint = dYPoint;
	// }

	public Date getSj() {
		return sj;
	}

	public void setSj(Date sj) {
		this.sj = sj;
	}

	// public Integer getcFirst() {
	// return cFirst;
	// }
	//
	// public void setcFirst(Integer cFirst) {
	// this.cFirst = cFirst;
	// }
	//
	// public Integer getcMore() {
	// return cMore;
	// }
	//
	// public void setcMore(Integer cMore) {
	// this.cMore = cMore;
	// }
	//
	// public Integer getcGly() {
	// return cGly;
	// }
	//
	// public void setcGly(Integer cGly) {
	// this.cGly = cGly;
	// }
	//
	// public Integer getMjgzFirst() {
	// return mjgzFirst;
	// }
	//
	// public void setMjgzFirst(Integer mjgzFirst) {
	// this.mjgzFirst = mjgzFirst;
	// }
	//
	// public Integer getMjgzMore() {
	// return mjgzMore;
	// }
	//
	// public void setMjgzMore(Integer mjgzMore) {
	// this.mjgzMore = mjgzMore;
	// }
	//
	// public Integer getGroupFirst() {
	// return groupFirst;
	// }
	//
	// public void setGroupFirst(Integer groupFirst) {
	// this.groupFirst = groupFirst;
	// }
	//
	// public Integer getGroupGly() {
	// return groupGly;
	// }
	//
	// public void setGroupGly(Integer groupGly) {
	// this.groupGly = groupGly;
	// }
	//
	// public Integer getGroupMore1() {
	// return groupMore1;
	// }
	//
	// public void setGroupMore1(Integer groupMore1) {
	// this.groupMore1 = groupMore1;
	// }
	//
	// public Integer getGroupMore2() {
	// return groupMore2;
	// }
	//
	// public void setGroupMore2(Integer groupMore2) {
	// this.groupMore2 = groupMore2;
	// }
	//
	// public Integer getGroupMore3() {
	// return groupMore3;
	// }
	//
	// public void setGroupMore3(Integer groupMore3) {
	// this.groupMore3 = groupMore3;
	// }
	//
	// public Integer getGroupMore4() {
	// return groupMore4;
	// }
	//
	// public void setGroupMore4(Integer groupMore4) {
	// this.groupMore4 = groupMore4;
	// }
	//
	// public Integer getUserMore1() {
	// return userMore1;
	// }
	//
	// public void setUserMore1(Integer userMore1) {
	// this.userMore1 = userMore1;
	// }
	//
	// public Integer getUserMore2() {
	// return userMore2;
	// }
	//
	// public void setUserMore2(Integer userMore2) {
	// this.userMore2 = userMore2;
	// }
	//
	// public Integer getUserMore3() {
	// return userMore3;
	// }
	//
	// public void setUserMore3(Integer userMore3) {
	// this.userMore3 = userMore3;
	// }
	//
	// public Integer getUserMore4() {
	// return userMore4;
	// }
	//
	// public void setUserMore4(Integer userMore4) {
	// this.userMore4 = userMore4;
	// }
	//
	// public Integer getIsMagnetism() {
	// return isMagnetism;
	// }
	//
	// public void setIsMagnetism(Integer isMagnetism) {
	// this.isMagnetism = isMagnetism;
	// }
	//
	// public Integer getOpenAlarm() {
	// return openAlarm;
	// }
	//
	// public void setOpenAlarm(Integer openAlarm) {
	// this.openAlarm = openAlarm;
	// }
	//
	// public Integer getIsForcein() {
	// return isForcein;
	// }
	//
	// public void setIsForcein(Integer isForcein) {
	// this.isForcein = isForcein;
	// }
	//
	// public Integer getcGlypass() {
	// return cGlypass;
	// }
	//
	// public void setcGlypass(Integer cGlypass) {
	// this.cGlypass = cGlypass;
	// }
	//
	// public Integer getAlwaysOpen() {
	// return alwaysOpen;
	// }
	//
	// public void setAlwaysOpen(Integer alwaysOpen) {
	// this.alwaysOpen = alwaysOpen;
	// }

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName == null ? null : depName.trim();
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName == null ? null : devName.trim();
	}

	public Integer getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(Integer depSerial) {
		this.depSerial = depSerial;
	}

	public String getDevSerial() {
		return devSerial;
	}

	public void setDevSerial(String devSerial) {
		this.devSerial = devSerial == null ? null : devSerial.trim();
	}

	public Integer getFx() {
		return fx;
	}

	public void setFx(Integer fx) {
		this.fx = fx;
	}

	public String getOperateLog() {
		return operateLog;
	}

	public void setOperateLog(String operateLog) {
		this.operateLog = operateLog == null ? null : operateLog.trim();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	@Override
	public String toString() {
		return "StDoorReal [bh=" + bh + ", doorName=" + doorName + ", xh=" + xh
				+ ", devSerial=" + devSerial + ", fx=" + fx + ", sj=" + sj
				+ ", operateLog=" + operateLog + ", ip=" + ip + ", operator="
				+ operator + ", devHead=" + devHead + ", devHead2=" + devHead2
				+ ", devOrder=" + devOrder + ", depSerial=" + depSerial
				+ ", depName=" + depName + ", devName=" + devName + "]";
	}

}