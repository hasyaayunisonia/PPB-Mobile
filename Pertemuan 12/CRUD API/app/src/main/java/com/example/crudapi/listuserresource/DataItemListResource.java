package com.example.crudapi.listuserresource;

import com.google.gson.annotations.SerializedName;

public class DataItemListResource {

	@SerializedName("color")
	private String color;

	@SerializedName("year")
	private Integer year;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private Integer id;

	@SerializedName("pantone_value")
	private String pantoneValue;

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setYear(Integer year){
		this.year = year;
	}

	public Integer getYear(){
		return year;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setPantoneValue(String pantoneValue){
		this.pantoneValue = pantoneValue;
	}

	public String getPantoneValue(){
		return pantoneValue;
	}

	@Override
 	public String toString(){
		return 
			"DataItemListResource{" +
			"color = '" + color + '\'' + 
			",year = '" + year + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",pantone_value = '" + pantoneValue + '\'' + 
			"}";
		}
}