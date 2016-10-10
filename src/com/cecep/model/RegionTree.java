package com.cecep.model;

import java.util.List;

public class RegionTree {

	private Integer id;
	private String text;
	private String state;
	private List<RegionTree> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<RegionTree> getChildren() {
		return children;
	}

	public void setChildren(List<RegionTree> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "RegionTree [id=" + id + ", text=" + text + ", state=" + state
				+ ", children=" + children + "]";
	}

}
