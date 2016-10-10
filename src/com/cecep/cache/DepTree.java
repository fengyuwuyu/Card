package com.cecep.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cecep.dao.DtDepMapper;

public class DepTree {

	private Long depSerial;
	private List<DepTree> children = new ArrayList<DepTree>();
	private Integer id;
	private String text;
	private String state;

	public DepTree() {
	}

	public DepTree(Long depSerial, DtDepMapper depMapper) {
		this.depSerial = depSerial;
		this.init(depMapper);
	}

	/**
	 * 初始化children
	 * 
	 * @param depMapper
	 */
	private void init(DtDepMapper depMapper) {
		Set<Long> depserials = depMapper.getChildrenDepSerial(this.depSerial);
		if (depserials != null && depserials.size() > 0) {
			for (Long serial : depserials) {
				DepTree temp = new DepTree(serial, depMapper);
				this.children.add(temp);
			}
		}
	}

	public Long getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(Long depSerial) {
		this.depSerial = depSerial;
	}

	public List<DepTree> getChildren() {
		return children;
	}

	public void setChildren(List<DepTree> children) {
		this.children = children;
	}

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

	public void getAllChildren(Set<Long> set) {
		set.add(this.depSerial);
		if (this.children != null) {
			for (DepTree depTree : this.children) {
				depTree.getAllChildren(set);
			}
		}
	}

	@Override
	public String toString() {
		return "DepTree [depSerial=" + depSerial + ", children=" + children
				+ ", id=" + id + ", text=" + text + ", state=" + state + "]";
	}

}
