package com.example.sefakkahriman.acronymstest.adapter;

import com.google.gson.annotations.SerializedName;

public class VarsItem{

	@SerializedName("freq")
	private int freq;

	@SerializedName("lf")
	private String lf;

	@SerializedName("since")
	private int since;

	public void setFreq(int freq){
		this.freq = freq;
	}

	public int getFreq(){
		return freq;
	}

	public void setLf(String lf){
		this.lf = lf;
	}

	public String getLf(){
		return lf;
	}

	public void setSince(int since){
		this.since = since;
	}

	public int getSince(){
		return since;
	}

	@Override
 	public String toString(){
		return 
			"VarsItem{" + 
			"freq = '" + freq + '\'' + 
			",lf = '" + lf + '\'' + 
			",since = '" + since + '\'' + 
			"}";
		}
}