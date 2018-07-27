package com.example.sefakkahriman.magicleapcoffeeappassignment.model;

import com.google.gson.annotations.SerializedName;

public class CoffeeResponse {

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("desc")
	private String desc;

	public String getImageUrl(){
		return imageUrl;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getDesc(){
		return desc;
	}

	@Override
 	public String toString(){
		return 
			"CoffeeResponse{" +
			"image_url = '" + imageUrl + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",desc = '" + desc + '\'' + 
			"}";
		}
}