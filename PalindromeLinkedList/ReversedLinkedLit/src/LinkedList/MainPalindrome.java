package LinkedList;

public class MainPalindrome {
	public static void main(String[] args) {
		PalindromeList palindromeList = new PalindromeList();

		palindromeList.addNode("A");
		palindromeList.addNode("C");
		palindromeList.addNode("B");
		palindromeList.addNode("D");
		palindromeList.addNode("C");
		palindromeList.addNode("B");
		palindromeList.addNode("D");
		palindromeList.addNode("A");

		palindromeList.checkPalindrome();

    }
}
