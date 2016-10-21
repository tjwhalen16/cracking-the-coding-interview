package chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionsIT {

	@Test
	public void testRemoveDups() {
		LinkedList list = new LinkedList(1,1);
		LinkedList answer = new LinkedList(1);
		Functions.removeDups(list.getHead());
		assertEquals(answer.getHead(), list.getHead());
		
		list = new LinkedList(1,1,1,1,1,1);
		answer = new LinkedList(1);
		Functions.removeDups(list.getHead());
		assertEquals(answer.getHead(), list.getHead());
		
		list = new LinkedList(1,1,2,2);
		answer = new LinkedList(1,2);
		Functions.removeDups(list.getHead());
		assertEquals(answer.getHead(), list.getHead());
		
		list = new LinkedList(1,1,2,2,3,3,3,4,4,4,4);
		answer = new LinkedList(1,2,3,4);
		Functions.removeDups(list.getHead());
		assertEquals(answer.getHead(), list.getHead());
		
		list = new LinkedList(1);
		answer = new LinkedList(1);
		Functions.removeDups(list.getHead());
		assertEquals(answer.getHead(), list.getHead());
		
	}

}
