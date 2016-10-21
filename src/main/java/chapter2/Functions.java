package chapter2;

import chapter2.LinkedList.Node;

public final class Functions {
	
	private Functions() {
		
	}
	
	//2.1
	//No buffer: O(n^2) time, O(1) space
	public static void removeDups(Node head) {
		//check head for null
		if (head == null) {
			return;
		}
		
		Node current = head;
		Node prev = current;
		Node runner = current.next;
		
		while (current != null) {
			while (runner != null) {
				if (current.data == runner.data) { //found a duplicate
					prev.next = runner.next; //remove it from the linked list
				} else {
					prev = prev.next;
				}
				runner = runner.next;
			}
			
			current = current.next;
			prev = current;
			
			if (current != null) {
				runner = current.next;
			}
		}
	}
	
	//TODO instead of going BACK and storing prev and updating its next
	//TODO go FORWARD by checking next's data

}
