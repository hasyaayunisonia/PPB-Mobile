package com.example.crudapi.registersuccessful;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("id")
	private Integer id;

	@SerializedName("token")
	private String token;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"RegisterResponse{" + 
			"id = '" + id + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}