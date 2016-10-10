package com.cecep.service.impl;

import java.util.HashMap;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.SysRoleMapper;
import com.cecep.model.SysRole;
import com.cecep.model.TreeNode;
import com.cecep.service.SysRoleServiceI;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleServiceI {
	
	private SysRoleMapper sysRoleMapper;

	@Autowired
	public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
		this.sysRoleMapper = sysRoleMapper;
	}

	public List<Map<String,Object>> load(SysRole record) {
		List<Map<String,Object>> list = this.sysRoleMapper.load(record);
		return list;
	}

	public Map<String, Object> dataList(SysRole record) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<SysRole> list = this.sysRoleMapper.selectByPage(record);
		Integer count = this.sysRoleMapper.selectCount(record);
		resultMap.put("rows", list);
		resultMap.put("total",count);
		return resultMap;
	}

	public Map<String, Object> delete(SysRole record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = record.getRoleId();		
		if(id == 1) {//系统管理员角色
			map.put("msg", "该角色为系统固有角色，不能删除！");
			map.put("success", false);
		}else if(id == 2) {//平台员工角色
			map.put("msg", "该角色为系统固有角色，不能删除！");
			map.put("success", false);
		}else if(id == 3) {//临时访客角色
			map.put("msg", "该角色为系统固有角色，不能删除！");
			map.put("success", false);
		}else {
			//状态
			record.setRoleDeleted(1);
			this.sysRoleMapper.updateByPrimaryKeySelective(record);			
			map.put("success", true);
		}		
		return map;
	}

	public Map<String, Object> getById(SysRole record) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		SysRole role = this.sysRoleMapper.selectByPrimaryKey(record.getRoleId());
		resultMap.put("data", role);	
		resultMap.put("success", true);
		return resultMap;
	}

	public Map<String, Object> save(SysRole record,Integer[] menuIds) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Integer roleId = record.getRoleId();
		if(roleId == null){
			this.sysRoleMapper.insert(record);	
			roleId = record.getRoleId();
		}else{
			this.sysRoleMapper.updateByPrimaryKey(record);		
		}		
		if(menuIds!=null&&menuIds.length>0){
			this.sysRoleMapper.deleteForMenuRole(roleId);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("roleId", roleId);
			map.put("menuIds", menuIds);
			this.sysRoleMapper.insertForMenuRole(map);
		}
		resultMap.put("success", true);
		return resultMap;
	}

	public List<TreeNode> getMenuTree(Integer parentId) {
		List<TreeNode> list = this.sysRoleMapper.getMenuTree(parentId);
		return list;
	}

}
