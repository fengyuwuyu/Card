package com.cecep.model;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 树形节点实体类
 * @date 2016-03-21
 * */
public class TreeNode {

	private String id;//节点id
	private String text;//节点文本
	private String state;//状态
	private Boolean checked;//状态二
	@JsonIgnore  
	private Map<String,Object> attributes = new HashMap<String, Object>();//自定义属性
	@JsonIgnore  
	private List<TreeNode>  children;//子节点    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
    
	
	
	
}
