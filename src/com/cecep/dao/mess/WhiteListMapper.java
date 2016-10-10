package com.cecep.dao.mess;

import java.util.List;

import com.cecep.model.mess.WhiteList;

public interface WhiteListMapper {

	List<WhiteList> dataList(WhiteList query);

	Integer getTotal(WhiteList query);
	
	/**
	 * 根据场所序号和员工序号删除dt_ac_dep_user表中的记录
	 * @param query
	 */
	void deteleDtAcDepUser(WhiteList query);
	
	/**
	 * 根据场所序号和员工序号插入dt_ac_dep_user表中的记录
	 * @param query
	 */
	void insertDtAcDepUser(WhiteList query);
	
	/**
	 * 调用存过client_link_xfupdate_all
	 * @param query
	 */
	void execWhiteListAll(WhiteList query);
	
	/**
	 * 调用存过client_link_xfupdate_info
	 * @param query
	 */
	void execWhiteListInfo(WhiteList query);
	
	/**
	 * 根据userSerials更新dt_user表中记录的user_sj
	 * @param query 
	 */
	void updateDtUSerSj(WhiteList query);

	/**
	 * 
	 * @param query
	 */
	void insertWtXfLog(WhiteList query);

	WhiteList selectByXh(Integer xh);

	void deteleDtAcDepUserByDep(WhiteList query);

	void insertDtAcDepUserByDep(WhiteList query);

	void updateDtUSerSjByDep(WhiteList query);

	void insertWtXfLogByDep(WhiteList query);

	void deleteByQuery(WhiteList query);

	/**
	 * 根据场所序号查询场所名称及设备ip
	 * @param query
	 * @return
	 */
//	Map<String, Object> queryAcdepNameAndDevIp(WhiteList query);

	
}
