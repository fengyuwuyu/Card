package com.cecep.model;
/**
 * 菜单角色实体类(menu_role表)
 * @date 2016-03-21
 * */
public class MenuRole {
	
	
    private Integer menuRoleId;
    private Integer menuId;
    private Integer roleId;
    
    public Integer getMenuRoleId() {
        return menuRoleId;
    }

    public void setMenuRoleId(Integer menuRoleId) {
        this.menuRoleId = menuRoleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}