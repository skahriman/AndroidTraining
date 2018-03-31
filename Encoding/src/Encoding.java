import java.util.Arrays;

public class Encoding {

	public static String encodeString(String str) {
		System.out.println("initial string: " + str);
		char[] charArray = str.toCharArray();
		int[] intArray = new int[charArray.length];
		char[] encodedArary = new char[charArray.length];
		
		for (int i = 0; i < charArray.length; i++) {
			int asciiNumber = (int)charArray[i];
			int revertNumber;
			int corrosPondingNumber = 0;
			
			if(asciiNumber == 32) {
				corrosPondingNumber = 32;
			}
			else if(asciiNumber >= 65 && asciiNumber <=90) {
				revertNumber = asciiNumber - 65;
				corrosPondingNumber = 90 - revertNumber;
			}
			else if(asciiNumber >= 97 && asciiNumber <= 122) {
				revertNumber = asciiNumber - 97;
				corrosPondingNumber = 122 - revertNumber;
			}
			intArray[i] = corrosPondingNumber;
			encodedArary[i] = (char)corrosPondingNumber;
		}
		System.out.println("encoded string: " + String.valueOf(encodedArary));
		return "encoded array: " + Arrays.toString(intArray);
	}
	
	public static void main(String[] args) {
		encodeString("Errors in strategy cannot be correct through tactical maneuvers");
		System.out.println();
	}
}
