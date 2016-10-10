package com.cecep.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 设备(包括门禁控制器、消费机、考勤机，其中门禁控制器的场所固定在默认场所下，其它两个可以修改场所)实体类(st_device表)
 * 
 * @date 2016-03-21
 * */
public class StDevice extends PageModel {

	private String bh;
	private String mc;
	private String bz;
	private String ip;
	private Integer com;
	private Integer port;
	private Integer btl;
	private String mm;
	private String zt;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date sj;
	private String xs;
	private String mj;
	private String pztj;
	private String pzlj;
	private Byte lx;
	private Integer yzfs;
	private String glyNo;
	private String glyPass;
	private String mac;
	private String devXs;
	private String devLx;
	private String kmry;
	private String dyip;
	private Integer jksz;
	private Byte tjkq;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date onLine;
	private Byte runState;
	private Byte devLb;
	private String devVersion;
	private Byte devUp;
	private Integer maxFlowNo;
	private Integer devLock;
	private Short state;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date kssj;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date jssj;
	private String devId;
	private Integer payType;
	private Integer devType;
	private Integer subType;
	private Integer subDel;
	private Integer userVersion;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date onlineSj;
	private Integer devSearch;
	private String gateway;
	private String mask;
	private String regserial;
	private Integer rateEnable;
	private Integer mainCard;
	private Integer btVer;
	private Integer fbtVer;
	private Integer addVer;
	private Integer acVer;
	private String acCrc32;
	private String sysCrc32;
	private Integer sysVer;
	private Integer moreCard;
	private String devXh;
	private Long devSbId;
	private Integer devState;
	private Long devAppId;
	private Integer devLogicBh;
	private Integer dlx;
	private String moduleId;
	private Integer isreal;
	private Integer kqSysVer;
	private Integer kqSysCrc32;
	private Short signal;
	private String notice;
	private BigDecimal onceAddMax;
	private Integer dayAddCount;
	private BigDecimal dayAddMax;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date addSj;
	private Integer devDorm;

	private List<Integer> devOrder;

	public List<Integer> getDevOrder() {
		return devOrder;
	}

	public void setDevOrder(List<Integer> devOrder) {
		this.devOrder = devOrder;
	}

	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh == null ? null : bh.trim();
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc == null ? null : mc.trim();
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public Integer getCom() {
		return com;
	}

	public void setCom(Integer com) {
		this.com = com;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getBtl() {
		return btl;
	}

	public void setBtl(Integer btl) {
		this.btl = btl;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm == null ? null : mm.trim();
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt == null ? null : zt.trim();
	}

	public Date getSj() {
		return sj;
	}

	public void setSj(Date sj) {
		this.sj = sj;
	}

	public String getXs() {
		return xs;
	}

	public void setXs(String xs) {
		this.xs = xs == null ? null : xs.trim();
	}

	public String getMj() {
		return mj;
	}

	public void setMj(String mj) {
		this.mj = mj == null ? null : mj.trim();
	}

	public String getPztj() {
		return pztj;
	}

	public void setPztj(String pztj) {
		this.pztj = pztj == null ? null : pztj.trim();
	}

	public String getPzlj() {
		return pzlj;
	}

	public void setPzlj(String pzlj) {
		this.pzlj = pzlj == null ? null : pzlj.trim();
	}

	public Byte getLx() {
		return lx;
	}

	public void setLx(Byte lx) {
		this.lx = lx;
	}

	public Integer getYzfs() {
		return yzfs;
	}

	public void setYzfs(Integer yzfs) {
		this.yzfs = yzfs;
	}

	public String getGlyNo() {
		return glyNo;
	}

	public void setGlyNo(String glyNo) {
		this.glyNo = glyNo == null ? null : glyNo.trim();
	}

	public String getGlyPass() {
		return glyPass;
	}

	public void setGlyPass(String glyPass) {
		this.glyPass = glyPass == null ? null : glyPass.trim();
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac == null ? null : mac.trim();
	}

	public String getDevXs() {
		return devXs;
	}

	public void setDevXs(String devXs) {
		this.devXs = devXs == null ? null : devXs.trim();
	}

	public String getDevLx() {
		return devLx;
	}

	public void setDevLx(String devLx) {
		this.devLx = devLx == null ? null : devLx.trim();
	}

	public String getKmry() {
		return kmry;
	}

	public void setKmry(String kmry) {
		this.kmry = kmry == null ? null : kmry.trim();
	}

	public String getDyip() {
		return dyip;
	}

	public void setDyip(String dyip) {
		this.dyip = dyip == null ? null : dyip.trim();
	}

	public Integer getJksz() {
		return jksz;
	}

	public void setJksz(Integer jksz) {
		this.jksz = jksz;
	}

	public Byte getTjkq() {
		return tjkq;
	}

	public void setTjkq(Byte tjkq) {
		this.tjkq = tjkq;
	}

	public Date getOnLine() {
		return onLine;
	}

	public void setOnLine(Date onLine) {
		this.onLine = onLine;
	}

	public Byte getRunState() {
		return runState;
	}

	public void setRunState(Byte runState) {
		this.runState = runState;
	}

	public Byte getDevLb() {
		return devLb;
	}

	public void setDevLb(Byte devLb) {
		this.devLb = devLb;
	}

	public String getDevVersion() {
		return devVersion;
	}

	public void setDevVersion(String devVersion) {
		this.devVersion = devVersion == null ? null : devVersion.trim();
	}

	public Byte getDevUp() {
		return devUp;
	}

	public void setDevUp(Byte devUp) {
		this.devUp = devUp;
	}

	public Integer getMaxFlowNo() {
		return maxFlowNo;
	}

	public void setMaxFlowNo(Integer maxFlowNo) {
		this.maxFlowNo = maxFlowNo;
	}

	public Integer getDevLock() {
		return devLock;
	}

	public void setDevLock(Integer devLock) {
		this.devLock = devLock;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}

	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId == null ? null : devId.trim();
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getDevType() {
		return devType;
	}

	public void setDevType(Integer devType) {
		this.devType = devType;
	}

	public Integer getSubType() {
		return subType;
	}

	public void setSubType(Integer subType) {
		this.subType = subType;
	}

	public Integer getSubDel() {
		return subDel;
	}

	public void setSubDel(Integer subDel) {
		this.subDel = subDel;
	}

	public Integer getUserVersion() {
		return userVersion;
	}

	public void setUserVersion(Integer userVersion) {
		this.userVersion = userVersion;
	}

	public Date getOnlineSj() {
		return onlineSj;
	}

	public void setOnlineSj(Date onlineSj) {
		this.onlineSj = onlineSj;
	}

	public Integer getDevSearch() {
		return devSearch;
	}

	public void setDevSearch(Integer devSearch) {
		this.devSearch = devSearch;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway == null ? null : gateway.trim();
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask == null ? null : mask.trim();
	}

	public String getRegserial() {
		return regserial;
	}

	public void setRegserial(String regserial) {
		this.regserial = regserial == null ? null : regserial.trim();
	}

	public Integer getRateEnable() {
		return rateEnable;
	}

	public void setRateEnable(Integer rateEnable) {
		this.rateEnable = rateEnable;
	}

	public Integer getMainCard() {
		return mainCard;
	}

	public void setMainCard(Integer mainCard) {
		this.mainCard = mainCard;
	}

	public Integer getBtVer() {
		return btVer;
	}

	public void setBtVer(Integer btVer) {
		this.btVer = btVer;
	}

	public Integer getFbtVer() {
		return fbtVer;
	}

	public void setFbtVer(Integer fbtVer) {
		this.fbtVer = fbtVer;
	}

	public Integer getAddVer() {
		return addVer;
	}

	public void setAddVer(Integer addVer) {
		this.addVer = addVer;
	}

	public Integer getAcVer() {
		return acVer;
	}

	public void setAcVer(Integer acVer) {
		this.acVer = acVer;
	}

	public String getAcCrc32() {
		return acCrc32;
	}

	public void setAcCrc32(String acCrc32) {
		this.acCrc32 = acCrc32 == null ? null : acCrc32.trim();
	}

	public String getSysCrc32() {
		return sysCrc32;
	}

	public void setSysCrc32(String sysCrc32) {
		this.sysCrc32 = sysCrc32 == null ? null : sysCrc32.trim();
	}

	public Integer getSysVer() {
		return sysVer;
	}

	public void setSysVer(Integer sysVer) {
		this.sysVer = sysVer;
	}

	public Integer getMoreCard() {
		return moreCard;
	}

	public void setMoreCard(Integer moreCard) {
		this.moreCard = moreCard;
	}

	public String getDevXh() {
		return devXh;
	}

	public void setDevXh(String devXh) {
		this.devXh = devXh == null ? null : devXh.trim();
	}

	public Long getDevSbId() {
		return devSbId;
	}

	public void setDevSbId(Long devSbId) {
		this.devSbId = devSbId;
	}

	public Integer getDevState() {
		return devState;
	}

	public void setDevState(Integer devState) {
		this.devState = devState;
	}

	public Long getDevAppId() {
		return devAppId;
	}

	public void setDevAppId(Long devAppId) {
		this.devAppId = devAppId;
	}

	public Integer getDevLogicBh() {
		return devLogicBh;
	}

	public void setDevLogicBh(Integer devLogicBh) {
		this.devLogicBh = devLogicBh;
	}

	public Integer getDlx() {
		return dlx;
	}

	public void setDlx(Integer dlx) {
		this.dlx = dlx;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId == null ? null : moduleId.trim();
	}

	public Integer getIsreal() {
		return isreal;
	}

	public void setIsreal(Integer isreal) {
		this.isreal = isreal;
	}

	public Integer getKqSysVer() {
		return kqSysVer;
	}

	public void setKqSysVer(Integer kqSysVer) {
		this.kqSysVer = kqSysVer;
	}

	public Integer getKqSysCrc32() {
		return kqSysCrc32;
	}

	public void setKqSysCrc32(Integer kqSysCrc32) {
		this.kqSysCrc32 = kqSysCrc32;
	}

	public Short getSignal() {
		return signal;
	}

	public void setSignal(Short signal) {
		this.signal = signal;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice == null ? null : notice.trim();
	}

	public BigDecimal getOnceAddMax() {
		return onceAddMax;
	}

	public void setOnceAddMax(BigDecimal onceAddMax) {
		this.onceAddMax = onceAddMax;
	}

	public Integer getDayAddCount() {
		return dayAddCount;
	}

	public void setDayAddCount(Integer dayAddCount) {
		this.dayAddCount = dayAddCount;
	}

	public BigDecimal getDayAddMax() {
		return dayAddMax;
	}

	public void setDayAddMax(BigDecimal dayAddMax) {
		this.dayAddMax = dayAddMax;
	}

	public Date getAddSj() {
		return addSj;
	}

	public void setAddSj(Date addSj) {
		this.addSj = addSj;
	}

	public Integer getDevDorm() {
		return devDorm;
	}

	public void setDevDorm(Integer devDorm) {
		this.devDorm = devDorm;
	}

	@Override
	public String toString() {
		return "StDevice [bh=" + bh + ", mc=" + mc + ", bz=" + bz + ", ip="
				+ ip + ", com=" + com + ", port=" + port + ", btl=" + btl
				+ ", mm=" + mm + ", zt=" + zt + ", sj=" + sj + ", xs=" + xs
				+ ", mj=" + mj + ", pztj=" + pztj + ", pzlj=" + pzlj + ", lx="
				+ lx + ", yzfs=" + yzfs + ", glyNo=" + glyNo + ", glyPass="
				+ glyPass + ", mac=" + mac + ", devXs=" + devXs + ", devLx="
				+ devLx + ", kmry=" + kmry + ", dyip=" + dyip + ", jksz="
				+ jksz + ", tjkq=" + tjkq + ", onLine=" + onLine
				+ ", runState=" + runState + ", devLb=" + devLb
				+ ", devVersion=" + devVersion + ", devUp=" + devUp
				+ ", maxFlowNo=" + maxFlowNo + ", devLock=" + devLock
				+ ", state=" + state + ", kssj=" + kssj + ", jssj=" + jssj
				+ ", devId=" + devId + ", payType=" + payType + ", devType="
				+ devType + ", subType=" + subType + ", subDel=" + subDel
				+ ", userVersion=" + userVersion + ", onlineSj=" + onlineSj
				+ ", devSearch=" + devSearch + ", gateway=" + gateway
				+ ", mask=" + mask + ", regserial=" + regserial
				+ ", rateEnable=" + rateEnable + ", mainCard=" + mainCard
				+ ", btVer=" + btVer + ", fbtVer=" + fbtVer + ", addVer="
				+ addVer + ", acVer=" + acVer + ", acCrc32=" + acCrc32
				+ ", sysCrc32=" + sysCrc32 + ", sysVer=" + sysVer
				+ ", moreCard=" + moreCard + ", devXh=" + devXh + ", devSbId="
				+ devSbId + ", devState=" + devState + ", devAppId=" + devAppId
				+ ", devLogicBh=" + devLogicBh + ", dlx=" + dlx + ", moduleId="
				+ moduleId + ", isreal=" + isreal + ", kqSysVer=" + kqSysVer
				+ ", kqSysCrc32=" + kqSysCrc32 + ", signal=" + signal
				+ ", notice=" + notice + ", onceAddMax=" + onceAddMax
				+ ", dayAddCount=" + dayAddCount + ", dayAddMax=" + dayAddMax
				+ ", addSj=" + addSj + ", devDorm=" + devDorm + ", devOrder="
				+ devOrder + "]";
	}

}