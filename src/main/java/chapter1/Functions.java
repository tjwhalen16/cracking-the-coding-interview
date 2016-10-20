package chapter1;

public class Functions {

	//1.1
	public static boolean isUnique(String string) {
		
		if (string.length() > 128) { //Assuming ASCII
			return false;
		}
		
		boolean[] charCount = new boolean[128]; //Assuming ASCII
		
		for (int ch : string.toCharArray()) {
			if (charCount[ch]) {
				return false; //have already seen this char
			}
			
			charCount[ch] = true;
		}
		
		return true;
	}
	
	//1.2
	public static boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		
		int[] charCount = new int[128]; //Assuming ASCII
		
		for (char ch : str1.toCharArray()) {
			charCount[(int)ch]++;
		}
		
		for (char ch : str2.toCharArray()) {
			charCount[ch]--;
			if (charCount[(int)ch] < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	//1.3
	public static String Urlify(String string, int len) {
		char[] url = new char[string.length()];
		int urlIndex = 0;
		
		for (int i = 0; i < len; i++) {
			char ch = string.charAt(i);
			
			if (ch == ' ') {
				url[urlIndex++] = '%';
				url[urlIndex++] = '2';
				url[urlIndex++] = '0';
			} else {
				url[urlIndex++] = ch;
			}
		}
		
		return String.valueOf(url);
	}
	
	//1.4
	public static boolean isPanlindromePermutation(String string) {
		
		int[] count = new int[128]; //Assume ASCII
		
		for (char ch : string.toLowerCase().toCharArray()) {
			if (ch != ' ') {
				count[ch]++;
			}
		}
				
		
		int numOdds  = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] % 2 != 0) {
				numOdds++;
			}
		}
		
		if (numOdds > 1) {
			return false;
		} else {
			return true;
		}
	}
	
	//1.5
	public static boolean oneEditAway(String str1, String str2) {
		
		if (Math.abs(str1.length() - str2.length()) > 1) {
			return false;
		} else if (str1.length() != str2.length()) {
			return checkAddRemove(str1, str2);
		} else {
			return checkReplace(str1, str2);
		}
	}
	
	private static boolean checkAddRemove(String str1, String str2) {
		String bigger = str1.length() > str2.length() ? str1 : str2;
		String smaller = bigger.equals(str1) ? str2 : str1;
		int bigIdx = 0, smallIdx = 0;
		
		while (smallIdx < smaller.length()) {
			if (bigger.charAt(bigIdx) != smaller.charAt(smallIdx)) {
				if (bigIdx != smallIdx) {
					return false;
				}
				bigIdx++;
			} else {
				smallIdx++;
				bigIdx++;
			}
			
		}
		
		return true;
	}
	
	private static boolean checkReplace(String str1, String str2) {
		boolean foundDifference = false;
		
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				
				foundDifference = true;
			}
		}
		
		return true;
	}
	
	//1.6
	//Use StringBuilder because string concatination is O(n^2)
	public static String compress(String string) {
		char currentChar = string.charAt(0);
		int currentCount = 1;
		StringBuilder answer = new StringBuilder();
		
		for (int i = 1; i < string.length(); i++) {
			if (currentChar == string.charAt(i)) {
				currentCount++;
			} else {
				answer.append(currentChar);
				answer.append(currentCount);
				currentChar = string.charAt(i);
				currentCount = 1;
			}
		}
		
		//There will always be one more character and count to append
		answer.append("" + currentChar + currentCount); //can make this a function since it's repeated
		return answer.length() < string.length() ? answer.toString() : string;
	}
}
