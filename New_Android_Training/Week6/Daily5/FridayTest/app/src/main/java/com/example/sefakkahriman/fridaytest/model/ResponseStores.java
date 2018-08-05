package com.example.sefakkahriman.fridaytest.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseStores{

	@SerializedName("Stores")
	private List<Store> stores;


	public void setStores(List<Store> stores){
		this.stores = stores;
	}

	public List<Store> getStores(){
		return stores;
	}


	@Override
 	public String toString(){
		return 
			"ResponseStpres{" + 
			"stores = '" + stores + '\'' +
			"}";
		}
}