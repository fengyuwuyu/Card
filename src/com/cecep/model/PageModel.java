package com.cecep.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 分页参数实体类
 * @date 2016-03-21
 * */
/**
 * @author ll
 * 
 */
public class PageModel {

	@JsonIgnore
	private Integer page;
	@JsonIgnore
	private Integer rows;
	@JsonIgnore
	private Integer start;

	public Integer getPage() {
		return page == null || page == 0 ? 1 : page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStart() {
		return  (this.getPage() - 1) * this.rows + 1;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "PageModel [page=" + page + ", rows=" + rows + ", start="
				+ start + "]";
	}

}
