package proplem_4;

public class CountSubStrings {

	public static boolean countSubs(String input, String subString, int number) {

		String main = input;
		String sub = subString;
		
		int count = -1;
		int i;
		for (i = 0; i < main.length(); i++) {
			count = main.indexOf(sub, i + count);
			if (count == -1)
				break;
		}
		
		return i == number;
	}

	public static void main(String args[]) {
		
		System.out.println(countSubs("abcabcaab", "ab", 3));

	}
}