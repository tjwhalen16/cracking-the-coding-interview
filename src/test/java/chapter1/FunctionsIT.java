package chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionsIT {

	//1.1
	@Test
	public void testIsUnique() {
		assertTrue(Functions.isUnique("true"));
		assertFalse(Functions.isUnique("unique"));
	}
	
	//1.2
	@Test
	public void testCheckPermutation() {
		assertTrue(Functions.checkPermutation("spot", "pots"));
		assertFalse(Functions.checkPermutation("dog", "cat"));
	}

	//1.3
	@Test
	public void testUrlify() {
		assertEquals("Mr%20John%20Smith", Functions.Urlify("Mr John Smith    ", 13));
	}
	
	//1.4
	@Test
	public void testIsPanlindromePermutation() {
		assertTrue(Functions.isPanlindromePermutation("Tact Coa"));
	}
	
	//1.5
	@Test
	public void testOneEditAway() {
		assertTrue(Functions.oneEditAway("pale", "ple"));
		assertTrue(Functions.oneEditAway("pales", "pale"));
		assertTrue(Functions.oneEditAway("pale", "bale"));
		assertFalse(Functions.oneEditAway("pale", "bake"));
	}
	
	//1.6
	@Test
	public void testCompress() {
		assertEquals("a2b1c5a3", Functions.compress("aabcccccaaa"));
		assertEquals("abcd", Functions.compress("abcd"));
		assertEquals("a4", Functions.compress("aaaa"));
	}
	
	//1.7
	@Test
	public void testRotateMatrix() {
		int[][] input = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[][] answer = {{3,6,9}, {2,5,8}, {1,4,7}};
		int[][] output = Functions.rotateMatrix(input);
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				assertTrue(answer[i][j] == output[i][j]);
			}
		}
	}
	
	//1.8
	@Test
	public void testZeroMatrix() {
		int[][] input = {{1,2,0,8}, {5,6,7,1}, {7,0,6,2}, {0,5,0,3}};
		int[][] answer = {{0,0,0,0}, {0,0,0,1}, {0,0,0,0}, {0,0,0,0}};
		
		Functions.zeroMatrix(input);
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				assertTrue(answer[i][j] == input[i][j]);
			}
		}
	}
	
	//1.9
	@Test
	public void testIsRotation() {
		assertTrue(Functions.isRotation("waterbottle", "bottlewater"));
		assertFalse(Functions.isRotation("waterbottle", "bottlewafer"));
		assertTrue(Functions.isRotation("ttttattt", "ttattttt"));
	}
}
