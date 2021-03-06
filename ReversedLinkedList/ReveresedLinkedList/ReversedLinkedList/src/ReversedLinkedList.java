
public class ReversedLinkedList {
	
	static class Node{
		int data;
		Node next;
		Node(int temp){
			data=temp;
		}
	}
	
	static Node reverse(Node node) {
		Node previous=null;
		Node current=node;
		Node next=null;
		
		while(current != null) {
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		return previous;
	}
	
	static void printLinkedList(Node head) {
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1=new Node(8);
		Node n2=new Node(25);
		Node n3=new Node(65);
		Node n4=new Node(78);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		
		System.out.println("Original Linked List");
		printLinkedList(n1);
		Node newHead=reverse(n1);
		System.out.println("");
		System.out.println("Reverse Linked List");
		printLinkedList(newHead);
	}

}
