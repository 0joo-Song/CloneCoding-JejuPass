package com.jejupass.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jejupass.common.JejuPassConstants;

import lombok.Data;

@Data
public class PagingModel {

	private Integer pageCount;
	private Integer currentPage;
	private Integer totalCount;
	private Integer totalPageCount;
	
	@JsonIgnore
	public int getStartRowNum() {
		return (currentPage != null) ? (currentPage - 1) * pageCount : 0;
	}

	@JsonIgnore
	public int getEndRowNum() {
		return (currentPage != null) ? currentPage * pageCount : 0;
	}

	@JsonIgnore
	public int getStartNum() {
		return (totalCount != null) ? totalCount - ((currentPage - 1) * pageCount) : 0;
	}
	
	public void setPagingInfo(int totalCount) {
		this.totalCount = totalCount;
		this.totalPageCount = totalCount / pageCount + ((totalCount % pageCount == 0) ? 0 : 1);
	}

	public PagingModel(){
		this.pageCount = JejuPassConstants.PAGING_COUNT;
		this.currentPage = 1;
	}
}
