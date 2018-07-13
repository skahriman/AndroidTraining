package problem_2;

import java.util.ArrayList;

public class SubString {
	
	static ArrayList<String> list = new ArrayList<>();
	
	static void printSubs(String input) {
		
		StringBuilder sb = new StringBuilder(input);
		String temp;
		for(int i = 0; i < input.length(); i++) {
			
			System.out.println();
			for(int j = i+1; j < sb.length()+1; j++) {
				temp = input.substring(i, j);
				System.out.println(temp);
			}
		}
	}
	
	public static void main(String[] args) {
		printSubs("abcd");
	}

}
