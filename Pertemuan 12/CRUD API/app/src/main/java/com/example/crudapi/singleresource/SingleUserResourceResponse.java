package com.example.crudapi.singleresource;

import com.google.gson.annotations.SerializedName;

public class SingleUserResourceResponse{

	@SerializedName("data")
	private DataSingleUserResource data;

	@SerializedName("support")
	private Support support;

	public void setData(DataSingleUserResource data){
		this.data = data;
	}

	public DataSingleUserResource getData(){
		return data;
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
			"SingleUserResourceResponse{" + 
			"data = '" + data + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}