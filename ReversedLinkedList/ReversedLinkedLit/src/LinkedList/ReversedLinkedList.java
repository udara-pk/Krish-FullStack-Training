package LinkedList;

public class ReversedLinkedList {
	
	Link head;


    public String deleteNode() {

        if (head != null) {
            if (head.next != null) {
                Link temp = head;
                head = head.next;
                return temp.value;
            } else {
                Link temp = head;
                head = null;
                return temp.value;
            }
        }
        return null;
    }

    public void addNode(String value) {

        if (head != null) {
            Link current = head;
            while (current.next != null) {
                current = current.next;
            }

            Link item = new Link(value);
            current.next = item;
        } else {
            head = new Link(value);
        }

    }

    public void reverseList() {
    	reverseChecker(head);
    }

    private void reverseChecker(Link step) {
        if (step.next == null)
            return;
        String temp = deleteNode();
        reverseChecker(step.next);
        addNode(temp);

    }
    
    public void printLinkedList() {
        Link current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    

}
