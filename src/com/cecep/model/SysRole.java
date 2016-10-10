package com.cecep.model;

import java.util.List;
/**
 * 角色实体类(sys_role表)
 * @date 2016-03-21
 * */
public class SysRole extends PageModel {
	
	
    private Integer roleId;
    private String roleName;
    private Integer roleStatus;//状态
    private Integer roleDeleted;//状态二
    private String roleDes;//描述
    
    /**
     * 关联属性
     * */
    private List<MenuRole> menuRoles;
    
    
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Integer getRoleDeleted() {
        return roleDeleted;
    }

    public void setRoleDeleted(Integer roleDeleted) {
        this.roleDeleted = roleDeleted;
    }

    public String getRoleDes() {
        return roleDes;
    }

    public void setRoleDes(String roleDes) {
        this.roleDes = roleDes == null ? null : roleDes.trim();
    }

	public List<MenuRole> getMenuRoles() {
		return menuRoles;
	}

	public void setMenuRoles(List<MenuRole> menuRoles) {
		this.menuRoles = menuRoles;
	}

	
    
    
    
}