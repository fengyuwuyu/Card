package com.cecep.model.kq;

import java.util.List;

public class TreeDep {

	/** 部门编号 */
	private Integer id;
	/** 部门名称 */
	private String text;
	/** 下级部门 */
	private List<TreeDep> children;
	private String state;

	public TreeDep() {
	}

	public TreeDep(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id ;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}

	public List<TreeDep> getChildren() {
		return children;
	}

	public void setChildren(List<TreeDep> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	@Override
	public String toString() {
		return "TreeDep [id=" + id + ", text=" + text + ", children="
				+ children + ", state=" + state + "]";
	}

}
