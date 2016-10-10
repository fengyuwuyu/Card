package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.DtAcType;
import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.SysMenu;
import com.cecep.model.TreeNode;
import com.cecep.model.XfAcTime;

public interface DtUserMapper {
	
    void deleteByPrimaryKey(Map<String,Object> map);
    int insert(DtUser record);
    int insertSelective(DtUser record);
    int insertSelective1(DtUser record);
    DtUser selectByPrimaryKey(Long userSerial);
    DtUser selectBySelective(DtUser record);
    int updateByPrimaryKeySelective(DtUser record);
    int updateByPrimaryKey(DtUser record);
    
    //分页查询
    List<DtUser> selectByPage(DtUser record);
    Integer selectCount(DtUser record);
    //菜单树查询
    List<SysMenu> getMenuTree(Integer roleId);
    //门禁树查询
    List<TreeNode> getDoorTree(Integer depSerial);
    //查询人员最大顺序号
    Integer selectMaxUserSerial();
    //修改人员最大顺序号
    int updateUserSerial();
    //添加人员角色
    int insertRoleUser(DtUser record);
    //修改人员角色
    int updateRoleUser(DtUser record);
    //查询部门
    DtDep selectDtDepByPrimaryKey(Long depSerial);
    //查询账户类型
    DtAcType selectDtAcTypeByPrimaryKey(String acBh);
    //添加人员账户
    int insertDtAcUser(DtUser record);
    //修改人员账户
    int updateDtAcUser(DtUser record);
    //添加消费场所白名单
    //int updateDtAcDepUser(DtUser record);
    //删除消费场所白名单
    //int deleteDtAcDepUser(DtUser record);
    //更新人员信息开户状态
    int updateUserAcByPrimaryKey(Long userSerial);
    //添加人员账户二
    int insertDtAcLink(DtUser record);
    //添加人员增量通讯日志
    int insertWtPublic(DtUser record);
    //查询密码
    Map<String,Object> selectUserPassword(DtUser record);
    //修改人员密码
    int updateUserPassword(DtUser record);
    //查询账户时段
    List<XfAcTime> selectXfAcTime(DtUser record); 
    //门禁查询
    List<Map<String,Object>> selectStDoorReal(DtUser record);
    //添加门禁授权记录
    int insertMjUserRuleReal(Map<String,Object> map);
    //删除门禁授权记录
    int deleteMjUserRuleReal(DtUser record);
    //添加门禁通讯日志
    int insertJrealUpdate(Map<String,Object> map);
    //删除门禁通讯日志
    int deleteJrealUpdate(DtUser record);
	List<String> getNamesByDepSerials(Map<String, Object> userMap);
	/** 根据条件查找本地用户表*/
	List<DtUser> selectSynchronizeUser(Map<String, String> map);
	int needServerNotify(Long userSerial);

	void clearRoleUser();
	void clearDtAcUser();
	void clearDtAcLink();
	List<Long> selectAllSerial();
	void clearDtUser();
	void updateWtModuleUser();
	void deleteWtPublicUser(Long userSerial);
	List<Map<String, Object>> selectAcType();
	List<DtUser> getAllUser();

	//单点登录查询
	DtUser selectSsologinUser(String loginid);
	List<DtUser> selectByNameAndCompany(DtUser record);
	Integer selectChildrenCount(Map<String,Object> depSerials);
	DtUser selectByUserNo(DtUser user);
	int checkUserManager(Map<String, Object> createMap);
	void updateUserOrder(Long userSerial);
	void updateWhenDepChange(DtDep query);

}