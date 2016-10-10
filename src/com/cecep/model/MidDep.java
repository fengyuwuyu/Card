package com.cecep.model;

/**
 * 主数据部门实体类(mid_dep表)
 * 
 * @date 2016-03-21
 * */
public class MidDep {

	private String status;// 部门状态(活动、冻结)
	private String iu_code;// 部门编码(部门8位码)
	private String iu_fullname;// 中文全称
	private String iu_shortname;// 中文简称
	private String iu_ssgs;// 是否上市公司(1 是 0 否)
	private String iu_lssjdw_id;// 上级部门编码
	private String iu_unit_level;// 部门层级
	private String iu_type;// 部门类别、性质
	private String iu_xndw;// 是否虚拟部门(1 是 0 否)
	private String iu_gsdjh;// 工商登记号
	private String iu_swdjh;// 税务登记号
	private String iu_zzjgz;// 组织机构号
	private String iu_country;// 国家
	private String dwccfl;// 部门分类
	private String djzclx;// 登记注册类型
	private String sfbbw;// 是否并表部门(1 是 0 否)
	private String sffrdw;// 是否法人部门(1 是 0 否)
	private String kgbl;// 控股比例
	private String iu_iscustomer;// 客户供应商类别、性质
	private String zzjgid;// 部门唯一标识、主键(注：此主键为主数据数据库的主键)
	private String zzjgcode;// 部门旧编码
	private String zzjgpid;// 上级部门唯一标识、主键(注：同上)
	private String zzjglongcode;// 部门长编码
	private String zzjglongname;// 部门长名称
	private String ssfc;// 是否封存(1 是 0 否)
	private String u_state;// 变更状态
	private String u_time;// 变更时间(格式：yyyy-MM-dd hh:mm:ss)
	private String iu_area;// 城市
	private String iu_city;// 省、地区
	private String iu_address;// 地址
	private String iu_postcode;// 邮编
	private String iu_lanaguecode;// 语言代码(01 英语 02 汉语 03 日语 04 德语 05 法语 06 韩语 07
									// 意大利语 08 俄语 09 西班牙语 10 朝鲜语 11 葡萄牙语 12 阿拉伯语
									// 13 其他语言)
	private String iu_tel;// 电话 (格式：xxx-xxxxxxxx)
	private String iu_fax;// 传真 (格式：xxx-xxxxxxxx)
	private String iu_email;// 电子邮箱
	private String iu_registercapital;// 注册资金
	private String iu_sshy;// 所属行业
	private String iu_lscwsjdw_id;// 上级部门编码(注：财务隶属)
	private String iu_lscwsjdw_name;// 上级部门名称(注：同上)
	private String is_synchronized;
	private String sortList;
	private String disType;

	public String getSortList() {
		return sortList;
	}

	public void setSortList(String sortList) {
		this.sortList = sortList == null ? null : sortList.trim();
	}

	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getDwccfl() {
		return dwccfl;
	}

	public void setDwccfl(String dwccfl) {
		this.dwccfl = dwccfl == null ? null : dwccfl.trim();
	}

	public String getDjzclx() {
		return djzclx;
	}

	public void setDjzclx(String djzclx) {
		this.djzclx = djzclx == null ? null : djzclx.trim();
	}

	public String getSfbbw() {
		return sfbbw;
	}

	public void setSfbbw(String sfbbw) {
		this.sfbbw = sfbbw == null ? null : sfbbw.trim();
	}

	public String getSffrdw() {
		return sffrdw;
	}

	public void setSffrdw(String sffrdw) {
		this.sffrdw = sffrdw == null ? null : sffrdw.trim();
	}

	public String getKgbl() {
		return kgbl;
	}

	public void setKgbl(String kgbl) {
		this.kgbl = kgbl == null ? null : kgbl.trim();
	}

	public String getZzjgid() {
		return zzjgid;
	}

	public void setZzjgid(String zzjgid) {
		this.zzjgid = zzjgid == null ? null : zzjgid.trim();
	}

	public String getZzjgcode() {
		return zzjgcode;
	}

	public void setZzjgcode(String zzjgcode) {
		this.zzjgcode = zzjgcode == null ? null : zzjgcode.trim();
	}

	public String getZzjgpid() {
		return zzjgpid;
	}

	public void setZzjgpid(String zzjgpid) {
		this.zzjgpid = zzjgpid == null ? null : zzjgpid.trim();
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

	public String getSsfc() {
		return ssfc;
	}

	public void setSsfc(String ssfc) {
		this.ssfc = ssfc == null ? null : ssfc.trim();
	}

	public String getIu_code() {
		return iu_code;
	}

	public void setIu_code(String iu_code) {
		this.iu_code = iu_code == null ? null : iu_code.trim();
	}

	public String getIu_fullname() {
		return iu_fullname;
	}

	public void setIu_fullname(String iu_fullname) {
		this.iu_fullname = iu_fullname == null ? null : iu_fullname.trim();
	}

	public String getIu_shortname() {
		return iu_shortname;
	}

	public void setIu_shortname(String iu_shortname) {
		this.iu_shortname = iu_shortname == null ? null : iu_shortname.trim();
	}

	public String getIu_ssgs() {
		return iu_ssgs;
	}

	public void setIu_ssgs(String iu_ssgs) {
		this.iu_ssgs = iu_ssgs == null ? null : iu_ssgs.trim();
	}

	public String getIu_lssjdw_id() {
		return iu_lssjdw_id;
	}

	public void setIu_lssjdw_id(String iu_lssjdw_id) {
		this.iu_lssjdw_id = iu_lssjdw_id == null ? null : iu_lssjdw_id.trim();
	}

	public String getIu_unit_level() {
		return iu_unit_level;
	}

	public void setIu_unit_level(String iu_unit_level) {
		this.iu_unit_level = iu_unit_level == null ? null : iu_unit_level
				.trim();
	}

	public String getIu_type() {
		return iu_type;
	}

	public void setIu_type(String iu_type) {
		this.iu_type = iu_type == null ? null : iu_type.trim();
	}

	public String getIu_xndw() {
		return iu_xndw;
	}

	public void setIu_xndw(String iu_xndw) {
		this.iu_xndw = iu_xndw == null ? null : iu_xndw.trim();
	}

	public String getIu_gsdjh() {
		return iu_gsdjh;
	}

	public void setIu_gsdjh(String iu_gsdjh) {
		this.iu_gsdjh = iu_gsdjh == null ? null : iu_gsdjh.trim();
	}

	public String getIu_swdjh() {
		return iu_swdjh;
	}

	public void setIu_swdjh(String iu_swdjh) {
		this.iu_swdjh = iu_swdjh == null ? null : iu_swdjh.trim();
	}

	public String getIu_zzjgz() {
		return iu_zzjgz;
	}

	public void setIu_zzjgz(String iu_zzjgz) {
		this.iu_zzjgz = iu_zzjgz == null ? null : iu_zzjgz.trim();
	}

	public String getIu_country() {
		return iu_country;
	}

	public void setIu_country(String iu_country) {
		this.iu_country = iu_country == null ? null : iu_country.trim();
	}

	public String getIu_iscustomer() {
		return iu_iscustomer;
	}

	public void setIu_iscustomer(String iu_iscustomer) {
		this.iu_iscustomer = iu_iscustomer == null ? null : iu_iscustomer
				.trim();
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

	public String getIu_area() {
		return iu_area;
	}

	public void setIu_area(String iu_area) {
		this.iu_area = iu_area == null ? null : iu_area.trim();
	}

	public String getIu_city() {
		return iu_city;
	}

	public void setIu_city(String iu_city) {
		this.iu_city = iu_city == null ? null : iu_city.trim();
	}

	public String getIu_address() {
		return iu_address;
	}

	public void setIu_address(String iu_address) {
		this.iu_address = iu_address == null ? null : iu_address.trim();
	}

	public String getIu_postcode() {
		return iu_postcode;
	}

	public void setIu_postcode(String iu_postcode) {
		this.iu_postcode = iu_postcode == null ? null : iu_postcode.trim();
	}

	public String getIu_lanaguecode() {
		return iu_lanaguecode;
	}

	public void setIu_lanaguecode(String iu_lanaguecode) {
		this.iu_lanaguecode = iu_lanaguecode == null ? null : iu_lanaguecode
				.trim();
	}

	public String getIu_tel() {
		return iu_tel;
	}

	public void setIu_tel(String iu_tel) {
		this.iu_tel = iu_tel == null ? null : iu_tel.trim();
	}

	public String getIu_fax() {
		return iu_fax;
	}

	public void setIu_fax(String iu_fax) {
		this.iu_fax = iu_fax == null ? null : iu_fax.trim();
	}

	public String getIu_email() {
		return iu_email;
	}

	public void setIu_email(String iu_email) {
		this.iu_email = iu_email == null ? null : iu_email.trim();
	}

	public String getIu_registercapital() {
		return iu_registercapital;
	}

	public void setIu_registercapital(String iu_registercapital) {
		this.iu_registercapital = iu_registercapital == null ? null
				: iu_registercapital.trim();
	}

	public String getIu_sshy() {
		return iu_sshy;
	}

	public void setIu_sshy(String iu_sshy) {
		this.iu_sshy = iu_sshy == null ? null : iu_sshy.trim();
	}

	public String getIu_lscwsjdw_id() {
		return iu_lscwsjdw_id;
	}

	public void setIu_lscwsjdw_id(String iu_lscwsjdw_id) {
		this.iu_lscwsjdw_id = iu_lscwsjdw_id == null ? null : iu_lscwsjdw_id
				.trim();
	}

	public String getIu_lscwsjdw_name() {
		return iu_lscwsjdw_name;
	}

	public void setIu_lscwsjdw_name(String iu_lscwsjdw_name) {
		this.iu_lscwsjdw_name = iu_lscwsjdw_name == null ? null
				: iu_lscwsjdw_name.trim();
	}

	public String getIs_synchronized() {
		return is_synchronized;
	}

	public void setIs_synchronized(String is_synchronized) {
		this.is_synchronized = is_synchronized == null ? null : is_synchronized
				.trim();
	}

	@Override
	public String toString() {
		return "MidDep [status=" + status + ", iu_code=" + iu_code
				+ ", iu_fullname=" + iu_fullname + ", iu_shortname="
				+ iu_shortname + ", iu_ssgs=" + iu_ssgs + ", iu_lssjdw_id="
				+ iu_lssjdw_id + ", iu_unit_level=" + iu_unit_level
				+ ", iu_type=" + iu_type + ", iu_xndw=" + iu_xndw
				+ ", iu_gsdjh=" + iu_gsdjh + ", iu_swdjh=" + iu_swdjh
				+ ", iu_zzjgz=" + iu_zzjgz + ", iu_country=" + iu_country
				+ ", dwccfl=" + dwccfl + ", djzclx=" + djzclx + ", sfbbw="
				+ sfbbw + ", sffrdw=" + sffrdw + ", kgbl=" + kgbl
				+ ", iu_iscustomer=" + iu_iscustomer + ", zzjgid=" + zzjgid
				+ ", zzjgcode=" + zzjgcode + ", zzjgpid=" + zzjgpid
				+ ", zzjglongcode=" + zzjglongcode + ", zzjglongname="
				+ zzjglongname + ", ssfc=" + ssfc + ", u_state=" + u_state
				+ ", u_time=" + u_time + ", iu_area=" + iu_area + ", iu_city="
				+ iu_city + ", iu_address=" + iu_address + ", iu_postcode="
				+ iu_postcode + ", iu_lanaguecode=" + iu_lanaguecode
				+ ", iu_tel=" + iu_tel + ", iu_fax=" + iu_fax + ", iu_email="
				+ iu_email + ", iu_registercapital=" + iu_registercapital
				+ ", iu_sshy=" + iu_sshy + ", iu_lscwsjdw_id=" + iu_lscwsjdw_id
				+ ", iu_lscwsjdw_name=" + iu_lscwsjdw_name
				+ ", is_synchronized=" + is_synchronized + ", sortList="
				+ sortList + ", disType=" + disType + "]";
	}

}