import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Encoding2 {

	static HashMap<String, Integer> hm = new HashMap<String, Integer>();      
	static char[] charArray;
	
	public static void initializeHahMap() {
		for(int i = 97; i <= 122; i++) { // in ascii a = 97, z = 122
			String key = String.valueOf((char)i);
			int value = 0;
			hm.put(key, value);
			hm.toString();
		}
	}
	
	public static void function_g (String str) {
		initializeHahMap();
		charArray = str.toLowerCase().toCharArray();
		hm.put("a", 0); hm.put("b", 0);
		
		for (char c : charArray) {
			if((int) c <= 122 && c >= 97) { // just consider the lower case letter characters
				String key = String.valueOf(c);
				hm.put(key, hm.get(key) + 1);
			}
		}
//		System.out.println(hm.toString()); //shows HashMap as a string
		
		//print key value pairs horizontally
		Iterator it = hm.entrySet().iterator();
		System.out.println("{");
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(it.hasNext() == true)
				System.out.println("    " + pair.getKey()+":"+pair.getValue()+",");
			else
				System.out.println("    " + pair.getKey()+":"+pair.getValue());
		}
		System.out.println("{");
		
	}

	public static void main(String[] args) {
		function_g("Hello there! Apple!");
	}
	
}
