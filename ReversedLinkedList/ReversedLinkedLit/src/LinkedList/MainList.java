package LinkedList;

public class MainList {
	public static void main(String[] args) {
        ReversedLinkedList reverseList = new ReversedLinkedList();

        reverseList.addNode("A");
        reverseList.addNode("B");
        reverseList.addNode("C");
        reverseList.addNode("D");
        reverseList.addNode("D");
        reverseList.addNode("C");
        reverseList.addNode("B");
        reverseList.addNode("A");

        reverseList.printLinkedList();

    }
}
