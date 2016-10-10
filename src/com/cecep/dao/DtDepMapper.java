package com.cecep.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cecep.model.DtDep;
import com.cecep.model.kq.TreeDep;

public interface DtDepMapper {
	
    int deleteByPrimaryKey(Long depSerial);
    int insert(DtDep record);
    int insertSelective(DtDep record);
    DtDep selectByPrimaryKey(Long depSerial);
    int updateByPrimaryKeySelective(DtDep record);
    int updateByPrimaryKey(DtDep record);
    
    //分页查询
    List<DtDep> selectByPage(DtDep record);
    Integer selectCount(DtDep record);
    //下拉查询
    List<Map<String,Object>> load(Integer depParent);
    //下拉查询二
    List<Map<String,Object>> load2(DtDep record);
    //查询人员最大顺序号
    Integer selectMaxDepSerial();
    //修改人员最大顺序号
    int updateDepSerial();
    /** 查询顶级部门 */
//   	TreeDep getTopTreeDep();
   	/** 根据部门编号查询子部门*/
   	List<TreeDep> getChildren(String parentId);
   	/** 根据depSerial查询部门名称*/
   	String getDepNameBySerial(Integer depSerial);
   	//List<String> getDepNameBySerials(Map<String,Object> depSerials);
   	List<String> getDepNameBySerials(Map<String,Object> depSerials);
	/** 根据depSerial查询部门所有员工的数量*/
	int getCountBySerial(Integer depSerial);
	/** 根据用户所在部门查找部门信息*/
	List<Map<String, Object>> loadByPrivilege(Map<String,Integer> map);
	int getRootDepCOunt();
	Set<Long> getChildrenDepSerial(Long depSerial);
	int getCountBySerials(Map<String,Object> sets);
	String getRootDepSerial(Map<String, Object> map);
	String selectDepByNameAndSerial(Map<String, Object> createMap);
	
	//测试使用，用于清空添加部门的操作
	void initDepSerial();
	void clearDtDepAcdep();
	void clearDtDep();
	void insertRootDep();
	DtDep selectHasBenbu(Integer depSerial);
	/** 根据depSerial查询所属二级公司的depSerial*/
	Integer getlevel2Serial(Integer depSerial);
	List<Long> selectThreeLevelDep();
	int selectUsersByDeps(Map<String, Object> map);
	void deleteDeps(Map<String, Object> set);
//	DtDep selectDepByName(String depName);
	void updateDepOrder(Map<String, Object> createMap);
	void updateUserOrder(Map<String, Object> createMap);
	List<TreeDep> getChildren1(TreeDep treeDep);
	void updateMidDepOrder(Map<String, Object> createMap);
	void updateMidUserOrder(Map<String, Object> createMap);
	
}