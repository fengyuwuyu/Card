package com.cecep.model;

import java.util.List;
/**
 * 菜单实体类(sys_menu表)
 * @date 2016-03-21
 * */
public class SysMenu extends PageModel {
		
	
    private Integer menuId;
    private String menuName;
    private String url;
    private Integer sequence;
    private Integer parentId;
    private Integer menuDeleted;
    private String menuDes;
    
    /**
     * 关联属性
     * */
    private List<SysMenu> children;
      
    
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuDeleted() {
        return menuDeleted;
    }

    public void setMenuDeleted(Integer menuDeleted) {
        this.menuDeleted = menuDeleted;
    }

    public String getMenuDes() {
        return menuDes;
    }

    public void setMenuDes(String menuDes) {
        this.menuDes = menuDes == null ? null : menuDes.trim();
    }

	public List<SysMenu> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenu> children) {
		this.children = children;
	}
    
    
    
}