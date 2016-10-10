package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.DtUser;
import com.cecep.model.MidUser;

public interface MidUserMapper {
	
    int insert(MidUser record);
    int insertSelective(MidUser record);
    Integer selectByPrimaryKey(String dm);
    int updateByPrimaryKey(MidUser record);
      
    //查询需要同步数据条数
    Integer selectIsSynchronized();
    //同步数据
    List<DtUser> synchronize();
    //修改同步状态
    int updateIsSynchronized(List<DtUser> list);
    /** 查询mid_internal_dep表与mid_user中部门名称相同且员工姓名相同的表
     * @param isSynchronized */
	List<DtUser> synchronizeByDnEn();
	void updateIsSynchronized1(List<DtUser> list);
	/** 将用户关于速通门、楼层门禁、食堂消费的权限保存到cecep_user_privilege表中*/
	void insertUserPrivilege(Map<String,Object> map);
	List<DtUser> synchronizeExternalUser();
	
	List<Map<String,Object>> selectZbDep();
	void updateIsSynchronized2(List<DtUser> list);
	
	List<String> selectAcDepSerials(String depSerial);
	List<DtUser> selectInternalUsers1();
	List<Map<String, Object>> selectZbDep1();
	void updateIsSynchronized3(List<DtUser> list);
	void updateUserPrivilege(Map<String, Object> paramMap);
	void insertMjJl(Map<String, Object> paramMap);
	List<DtUser> midUserSynchronize();
	
	int midUserSynchronizeCount();
}