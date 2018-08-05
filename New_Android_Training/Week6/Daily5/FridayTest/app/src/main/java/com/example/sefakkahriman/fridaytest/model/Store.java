package com.example.sefakkahriman.fridaytest.model;

import com.google.gson.annotations.SerializedName;

public class Store{

	@SerializedName("HoursDescription")
	private String hoursDescription;

	@SerializedName("StoreID")
	private String storeID;

	@SerializedName("AddressDescription")
	private String addressDescription;

	public void setHoursDescription(String hoursDescription){
		this.hoursDescription = hoursDescription;
	}

	public String getHoursDescription(){
		return hoursDescription;
	}

	public void setStoreID(String storeID){
		this.storeID = storeID;
	}

	public String getStoreID(){
		return storeID;
	}

	public void setAddressDescription(String addressDescription){
		this.addressDescription = addressDescription;
	}

	public String getAddressDescription(){
		return addressDescription;
	}

	@Override
 	public String toString(){
		return 
			"StoresItem{" + 
			"hoursDescription = '" + hoursDescription + '\'' +
			",storeID = '" + storeID + '\'' +
			",addressDescription = '" + addressDescription + '\'' +
			"}";
		}
}