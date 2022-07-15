package LinkedList;

public class PalindromeList {
	
	Link head;
	
	public void checkPalindrome() {
		palindromeChecker(head);

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

    private Link palindromeChecker(Link step) {

        if (step.value.equals(step.next.value)) {

            return step.next.next;
        }

        if (!step.value.equals(step.next.value)) {
            Link nextHead = palindromeChecker(step.next);
            if (nextHead.value.equals(step.value)) {
                if (nextHead.value.equals(head.value)) {
                    System.out.println("This is a Palindrome");
                }else{
					System.out.println("This is not a Palindrome");
				}	
                return nextHead.next;
            }
        }

        return step.next;

    }
}
