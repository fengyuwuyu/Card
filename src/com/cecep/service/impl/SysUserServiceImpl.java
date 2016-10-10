package com.cecep.service.impl;

import java.util.HashMap;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.SysUserMapper;
import com.cecep.model.SysMenu;
import com.cecep.model.SysUser;
import com.cecep.service.SysUserServiceI;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserServiceI {

	private SysUserMapper sysUserMapper;

	@Autowired
	public void setSysUserMapper(SysUserMapper sysUserMapper) {
		this.sysUserMapper = sysUserMapper;
	}

	public Map<String, Object> dataList(SysUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysUser> list = this.sysUserMapper.selectByPage(record);
		Integer count = this.sysUserMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	public Map<String, Object> getById(SysUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		SysUser user = this.sysUserMapper.selectByPrimaryKey(record.getUserId());
		map.put("data", user);	
		map.put("success", true);
		return map;
	}

	public Map<String, Object> editPwd(SysUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		record.setPassword("111111");
		this.sysUserMapper.updateByPrimaryKeySelective(record);		
		map.put("msg", "重置密码成功！");	
		map.put("success", true);
		return map;
	}

	public Map<String, Object> save(SysUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer userId = record.getUserId();
		if(userId == null) {
			record.setPassword("111111");
			this.sysUserMapper.insert(record);		
		}else {
			this.sysUserMapper.updateByPrimaryKey(record);		
		}			
		map.put("success", true);
		return map;
	}

	public Map<String, Object> delete(SysUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		record.setDeleteTime(new Date());
		record.setUserDeleted(1);
		this.sysUserMapper.updateByPrimaryKeySelective(record);			
		map.put("success", true);
		return map;
	}

	public SysUser login(SysUser record) {		
		SysUser user = this.sysUserMapper.selectSelective(record);	
		return user;
	}

	public List<SysMenu> getMenuTree(Integer roleId) {
		List<SysMenu> list = this.sysUserMapper.getMenuTree(roleId);
		return list;
	}

	
}
