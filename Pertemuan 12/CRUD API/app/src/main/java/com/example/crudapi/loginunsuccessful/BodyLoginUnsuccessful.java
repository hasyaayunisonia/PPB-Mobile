package com.example.crudapi.loginunsuccessful;

import com.google.gson.annotations.SerializedName;

public class BodyLoginUnsuccessful{

	@SerializedName("email")
	private String email;

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"BodyLoginUnsuccessful{" + 
			"email = '" + email + '\'' + 
			"}";
		}
}