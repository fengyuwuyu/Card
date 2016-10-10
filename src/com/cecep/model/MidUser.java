package com.cecep.model;

/**
 * 主数据人员实体类(mid_user表)
 * 
 * @date 2016-03-21
 * */
public class MidUser {

	private String hrid;// 人员唯一标识、主键(注：此主键为主数据数据库的主键)
	private String status;// 人员状态(正常、冻结)
	private String dm;// 人员编码(人员8位码)
	private String name;// 姓名
	private String useedname;// 曾用名
	private String sex;// 性别
	private String minzu;// 民族
	private String extends3;// 身份证号
	private String csrq;// 出生日期(格式：yyyy-MM-dd)
	private String jiq;// 籍贯
	private String countrycity;// 所属国家及地区
	private String department;// 部门名称
	private String unit_id;// 部门代码
	private String job;// 职位
	private String zhij;// 职级
	private String grsf;// 个人身份
	private String rylb;// 人员类别(普通员工、中层干部、公司领导...)
	private String hire;// 人员状态二(辞职、辞退、返聘、解聘、开除、离岗、离开本单位未解除关系人员、离休、内部退养、其它非在岗、实习生、死亡、停职留薪、退休、在岗、长期病、休假...)
	private String yglx;// 人员类型
	private String jkzk;// 健康状况
	private String hyzk;// 婚姻状况
	private String zzmm;// 政治面貌
	private String zgxl;// 最高学历
	private String csd;// 出生地
	private String hkszd;// 户口所在地
	private String daszd;// 档案所在地
	private String hklx;// 户口类型
	private String homeaddr;// 住址所在地
	private String homepost;// 住址邮编
	private String officetel;// 办公电话(xxx-xxxxxxxx-xxx)
	private String hometel;// 住宅电话(xxx-xxxxxxxx)
	private String telephone;// 移动号码
	private String email;// 电子邮箱
	private String remark;// 备注说明
	private String sszzjgid;// 部门唯一标识
	private String sszzjgbm;// 部门旧编码
	private String u_state;// 变更状态
	private String u_time;// 记录变更时间(yyyy-MM-dd hh:mm:ss)
	private String zzjglongcode;// 部门长编码
	private String zzjglongname;// 部门长名称
	private String is_synchronized;

	public String getHrid() {
		return hrid;
	}

	public void setHrid(String hrid) {
		this.hrid = hrid == null ? null : hrid.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm == null ? null : dm.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getUseedname() {
		return useedname;
	}

	public void setUseedname(String useedname) {
		this.useedname = useedname == null ? null : useedname.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getMinzu() {
		return minzu;
	}

	public void setMinzu(String minzu) {
		this.minzu = minzu == null ? null : minzu.trim();
	}

	public String getExtends3() {
		return extends3;
	}

	public void setExtends3(String extends3) {
		this.extends3 = extends3 == null ? null : extends3.trim();
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq == null ? null : csrq.trim();
	}

	public String getJiq() {
		return jiq;
	}

	public void setJiq(String jiq) {
		this.jiq = jiq == null ? null : jiq.trim();
	}

	public String getCountrycity() {
		return countrycity;
	}

	public void setCountrycity(String countrycity) {
		this.countrycity = countrycity == null ? null : countrycity.trim();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job == null ? null : job.trim();
	}

	public String getZhij() {
		return zhij;
	}

	public void setZhij(String zhij) {
		this.zhij = zhij == null ? null : zhij.trim();
	}

	public String getGrsf() {
		return grsf;
	}

	public void setGrsf(String grsf) {
		this.grsf = grsf == null ? null : grsf.trim();
	}

	public String getRylb() {
		return rylb;
	}

	public void setRylb(String rylb) {
		this.rylb = rylb == null ? null : rylb.trim();
	}

	public String getHire() {
		return hire;
	}

	public void setHire(String hire) {
		this.hire = hire == null ? null : hire.trim();
	}

	public String getYglx() {
		return yglx;
	}

	public void setYglx(String yglx) {
		this.yglx = yglx == null ? null : yglx.trim();
	}

	public String getJkzk() {
		return jkzk;
	}

	public void setJkzk(String jkzk) {
		this.jkzk = jkzk == null ? null : jkzk.trim();
	}

	public String getHyzk() {
		return hyzk;
	}

	public void setHyzk(String hyzk) {
		this.hyzk = hyzk == null ? null : hyzk.trim();
	}

	public String getZzmm() {
		return zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm == null ? null : zzmm.trim();
	}

	public String getZgxl() {
		return zgxl;
	}

	public void setZgxl(String zgxl) {
		this.zgxl = zgxl == null ? null : zgxl.trim();
	}

	public String getCsd() {
		return csd;
	}

	public void setCsd(String csd) {
		this.csd = csd == null ? null : csd.trim();
	}

	public String getHkszd() {
		return hkszd;
	}

	public void setHkszd(String hkszd) {
		this.hkszd = hkszd == null ? null : hkszd.trim();
	}

	public String getDaszd() {
		return daszd;
	}

	public void setDaszd(String daszd) {
		this.daszd = daszd == null ? null : daszd.trim();
	}

	public String getHklx() {
		return hklx;
	}

	public void setHklx(String hklx) {
		this.hklx = hklx == null ? null : hklx.trim();
	}

	public String getHomeaddr() {
		return homeaddr;
	}

	public void setHomeaddr(String homeaddr) {
		this.homeaddr = homeaddr == null ? null : homeaddr.trim();
	}

	public String getHomepost() {
		return homepost;
	}

	public void setHomepost(String homepost) {
		this.homepost = homepost == null ? null : homepost.trim();
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel == null ? null : officetel.trim();
	}

	public String getHometel() {
		return hometel;
	}

	public void setHometel(String hometel) {
		this.hometel = hometel == null ? null : hometel.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getSszzjgid() {
		return sszzjgid;
	}

	public void setSszzjgid(String sszzjgid) {
		this.sszzjgid = sszzjgid == null ? null : sszzjgid.trim();
	}

	public String getSszzjgbm() {
		return sszzjgbm;
	}

	public void setSszzjgbm(String sszzjgbm) {
		this.sszzjgbm = sszzjgbm == null ? null : sszzjgbm.trim();
	}

	public String getZzjglongcode() {
		return zzjglongcode;
	}

	public void setZzjglongcode(String zzjglongcode) {
		this.zzjglongcode = zzjglongcode == null ? null : zzjglongcode.trim();
	}

	public String getZzjglongname() {
		return zzjglongname;
	}

	public void setZzjglongname(String zzjglongname) {
		this.zzjglongname = zzjglongname == null ? null : zzjglongname.trim();
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id == null ? null : unit_id.trim();
	}

	public String getU_state() {
		return u_state;
	}

	public void setU_state(String u_state) {
		this.u_state = u_state == null ? null : u_state.trim();
	}

	public String getU_time() {
		return u_time;
	}

	public void setU_time(String u_time) {
		this.u_time = u_time == null ? null : u_time.trim();
	}

	public String getIs_synchronized() {
		return is_synchronized;
	}

	public void setIs_synchronized(String is_synchronized) {
		this.is_synchronized = is_synchronized == null ? null : is_synchronized
				.trim();
	}

}