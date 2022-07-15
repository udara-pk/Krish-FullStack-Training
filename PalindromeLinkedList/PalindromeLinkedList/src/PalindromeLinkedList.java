import java.util.Stack;


public class PalindromeLinkedList {
	
	static class Node{
		int data;
		Node next;
		Node(int temp){
			data=temp;
		}
	}
	
	static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	static boolean isPalindrome(Node head) {
		Node tempNode = head;
		Stack<Integer> stack=new Stack<Integer>();
		while(tempNode != null) {
			stack.push(tempNode.data);
			tempNode=tempNode.next;
		}
		while(head != null) {
			if(head.data != stack.pop()) {
				return false;
			}
			head=head.next;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1=new Node(8);
		Node n2=new Node(25);
		Node n3=new Node(35);
		Node n4=new Node(25);
		Node n5=new Node(8);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		System.out.println("Original Linked List");
		printList(n1);
		System.out.println("");
		if(isPalindrome(n1)==true) {
			System.out.println("This is Palindrome");
		}else {
			System.out.println("This is not Palindrome");
		}
		
	}

}
