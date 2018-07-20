package com.example.sefakkahriman.acronymstest.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LfsItem{

	@SerializedName("freq")
	private int freq;

	@SerializedName("lf")
	private String lf;

	@SerializedName("vars")
	private List<VarsItem> vars;

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

	public void setVars(List<VarsItem> vars){
		this.vars = vars;
	}

	public List<VarsItem> getVars(){
		return vars;
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
			"LfsItem{" + 
			"freq = '" + freq + '\'' + 
			",lf = '" + lf + '\'' + 
			",vars = '" + vars + '\'' + 
			",since = '" + since + '\'' + 
			"}";
		}
}