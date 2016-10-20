package chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionsIT {

	@Test
	public void testIsUnique() {
		assertTrue(Functions.isUnique("true"));
		assertFalse(Functions.isUnique("unique"));
	}
	
	@Test
	public void testCheckPermutation() {
		assertTrue(Functions.checkPermutation("spot", "pots"));
		assertFalse(Functions.checkPermutation("dog", "cat"));
	}

	@Test
	public void testUrlify() {
		assertEquals("Mr%20John%20Smith", Functions.Urlify("Mr John Smith    ", 13));
	}
	
	@Test
	public void testIsPanlindromePermutation() {
		assertTrue(Functions.isPanlindromePermutation("Tact Coa"));
	}
	
	@Test
	public void testOneEditAway() {
		assertTrue(Functions.oneEditAway("pale", "ple"));
		assertTrue(Functions.oneEditAway("pales", "pale"));
		assertTrue(Functions.oneEditAway("pale", "bale"));
		assertFalse(Functions.oneEditAway("pale", "bake"));
	}
	
	@Test
	public void testCompress() {
		assertEquals("a2b1c5a3", Functions.compress("aabcccccaaa"));
		assertEquals("abcd", Functions.compress("abcd"));
	}
}
