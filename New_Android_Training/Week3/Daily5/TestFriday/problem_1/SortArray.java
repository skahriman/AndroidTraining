package problem_1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 1. Sort the array with multiple same values in the array in an ascending order. 
 * Input: {2,8,9,3,4,3,2,6,6,2,4,9,8}
 * Output: {2,2,2,3,3,4,4,6,6,8,8,9,9}
 * 
 * 
 * */

public class SortArray {
	
	public static ArrayList<Integer> sortList(String input){
		
		StringBuilder sb = new StringBuilder(input);
		sb.deleteCharAt(0); sb.deleteCharAt(sb.length()-1);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < sb.length(); i ++) {
			String myChar = String.valueOf(sb.charAt(i));
			Integer myInt = Integer.parseInt(myChar);
			list.add(myInt);
			i++;
		}
		
		Collections.sort(list);
	
		return list;
	} 
	

	public static void main(String[] args) {
		String input = "{2,8,9,3,4,3,2,6,6,2,4,9,8}";
		System.out.println(SortArray.sortList(input));
		
	}
			
	
}
