package com.example.sefakkahriman.acronymstest.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("sf")
	private String sf;

	@SerializedName("lfs")
	private List<LfsItem> lfs;

	public void setSf(String sf){
		this.sf = sf;
	}

	public String getSf(){
		return sf;
	}

	public void setLfs(List<LfsItem> lfs){
		this.lfs = lfs;
	}

	public List<LfsItem> getLfs(){
		return lfs;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"sf = '" + sf + '\'' + 
			",lfs = '" + lfs + '\'' + 
			"}";
		}
}