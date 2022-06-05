package com.example.crudapi.delayed;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DelayedResponse {

	@SerializedName("per_page")
	private Integer perPage;

	@SerializedName("total")
	private Integer total;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("page")
	private Integer page;

	@SerializedName("total_pages")
	private Integer totalPages;

	@SerializedName("support")
	private Support support;

	public void setPerPage(Integer perPage){
		this.perPage = perPage;
	}

	public Integer getPerPage(){
		return perPage;
	}

	public void setTotal(Integer total){
		this.total = total;
	}

	public Integer getTotal(){
		return total;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setPage(Integer page){
		this.page = page;
	}

	public Integer getPage(){
		return page;
	}

	public void setTotalPages(Integer totalPages){
		this.totalPages = totalPages;
	}

	public Integer getTotalPages(){
		return totalPages;
	}

	public void setSupport(Support support){
		this.support = support;
	}

	public Support getSupport(){
		return support;
	}

	@Override
 	public String toString(){
		return 
			"DelayedResponse{" +
			"per_page = '" + perPage + '\'' + 
			",total = '" + total + '\'' + 
			",data = '" + data + '\'' + 
			",page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}