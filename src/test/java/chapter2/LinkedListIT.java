package chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

import chapter2.LinkedList.Node;

public class LinkedListIT {

	@Test
	public void testLinkedListConstructor() {
		
		LinkedList list = new LinkedList(1,2,3,4,5,6,7,8,9);
		
		Node head = list.getHead();
		
		int answer = 1;
		while (head != null) {
			System.out.print(answer + ",");
			assertEquals(answer, head.data);
			answer++;
			head = head.next;
		}
		
		head = list.getHead();
		assertEquals(1, head.data);
	}
	
	@Test
	public void testLinkedListEquals() {
		LinkedList list1 = new LinkedList(1,2,3,4,5,6,7,8,9);
		LinkedList list2 = new LinkedList(1,2,3,4,5,6,7,8,9);
		LinkedList list3 = new LinkedList(1,2,3,4,5,6,7,8,9, 10);
		LinkedList list4 = new LinkedList(1,2,3,4,5,6,7,8);
		
		assertEquals(list1.getHead(), list2.getHead());
		assertEquals(list1.getHead(), list2.getHead());
		assertEquals(list2.getHead(), list1.getHead());
		assertNotEquals(list1.getHead(), list3.getHead());
		assertNotEquals(list1.getHead(), list4.getHead());
	}

}
