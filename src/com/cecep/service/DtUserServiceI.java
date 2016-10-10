package com.cecep.service;

import java.util.List;


import java.util.Map;






import com.cecep.model.DtUser;
import com.cecep.model.SysMenu;
import com.cecep.model.TreeNode;
import com.cecep.model.XfAcTime;

public interface DtUserServiceI {
	
	Map<String,Object> dataList(DtUser record);	
	Map<String,Object> getById(DtUser record);
	Map<String,Object> save(DtUser record,String[] doorBhs);
	Map<String,Object> getPwd(DtUser record);
	Map<String,Object> editPwd(DtUser record);
	DtUser login(DtUser record);
    List<SysMenu> getMenuTree(Integer roleId);
    List<TreeNode> getDoorTree(Integer depSerial);
    List<XfAcTime> selectXfAcTime(DtUser record);
    List<Map<String,Object>> selectStDoorReal(DtUser record);
	int needServerNotify(Long userSerial);
	
	/** 清空员工表及删除添加用户时所涉及表的数据,测试时使用*/
	void deleteAllUser();
	List<Map<String, Object>> selectAcType();
	Map<String, Object> delete(DtUser record);
	/** 检查登录用户是否有某页面的权限*/
	boolean checkUserManager(DtUser currUser , String url);

}
