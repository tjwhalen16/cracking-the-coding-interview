package chapter2;

public class LinkedList {

	class Node {		
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		@Override
		public boolean equals(Object other) {
			Node otherNode = (Node)other;
			Node thisNode = this;
			
			while (thisNode != null && otherNode != null) {
				if (thisNode.data != otherNode.data) {
					return false;
				}
				thisNode = thisNode.next;
				otherNode = otherNode.next;
			}
			
			if (thisNode != null || otherNode != null) {
				return false;
			}
			
			return true;
		}
	}
	
	private Node head;
	
	public LinkedList(int... datam) {
		
		head = new Node(datam[0]);
		
		Node current = head;
		for (int i = 1; i < datam.length; i++) {
			current.next = new Node(datam[i]);
			current = current.next;
		}
	}
	
	public Node getHead() {
		return head;
	}
	
	
}
