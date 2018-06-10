package com.example.sefakkahriman.dagger2demo.model;


import com.google.gson.annotations.SerializedName;


public class Location{

	@SerializedName("city")
	private String city;

	@SerializedName("street")
	private String street;

	@SerializedName("postcode")
	private String postcode;

	@SerializedName("state")
	private String state;

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setPostcode(String postcode){
		this.postcode = postcode;
	}

	public String getPostcode(){
		return postcode;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"city = '" + city + '\'' + 
			",street = '" + street + '\'' + 
			",postcode = '" + postcode + '\'' + 
			",state = '" + state + '\'' + 
			"}";
		}
}