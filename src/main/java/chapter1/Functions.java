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
	
	//1.7
	public static int[][] rotateMatrix(int[][] matrix) {
		int len = matrix.length;
		int[][] answer = new int[len][len];
		
		for (int i = 0; i < len; i++) {
			columnsToRows(matrix, answer, i);
		}
		return answer;
	}
	
	private static void columnsToRows(int[][] from, int[][] to, int col) {
		int len = from.length;
		int row = len - col - 1;
		
		for (int i = 0; i < len; i++) {
			to[row][i] = from[i][col];
		}
	}
	
	//1.8
	public static void zeroMatrix(int[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		boolean[] rowsWithZero = new boolean[rowLen];
		boolean[] colsWithZero = new boolean[colLen];
		
		//find zeros
		for (int m = 0; m < rowLen; m++) {
			for (int n = 0; n < colLen; n++) {
				if (matrix[m][n] == 0) {
					rowsWithZero[m] = true;
					colsWithZero[n] = true;
				}
			}
		}
		
		//zero out rows
		for (int i = 0; i < rowLen; i++) {
			if (rowsWithZero[i]) {
				zeroRow(matrix, i);
			}
		}
		
		//zero out columns
		for (int i = 0; i < colLen; i++) {
			if (colsWithZero[i]) {
				zeroCol(matrix, i);
			}
		}
	}
	
	private static void zeroRow(int[][] matrix, int row) {
		for (int i = 0; i < matrix[row].length; i++) {
			matrix[row][i] = 0;
		}
	}
	private static void zeroCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix[col].length; i++) {
			matrix[i][col] = 0;
		}
	}
	
	
	//1.9
	public static boolean isRotation(String s1, String s2) {
		
		if (s1.length() == s2.length()) {
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		
		return false;
	}
	
	private static boolean isSubstring(String s1, String s2) {
		return s1.contains(s2);
	}
}
