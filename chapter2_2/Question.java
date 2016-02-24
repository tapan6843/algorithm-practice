/**
 * Implement an algorithm to fid the nth to last element of a singly linked list.
 */
package chapter2_2;

import chapter2_1.Node;

/**
 * @author Tapan
 *
 */
public class Question {
	
	public static Node findElementFromLast(Node head,int number){
		
		if(head == null){
			return null;
		}
		
		int count=1;
		Node current = head;
		Node newCurrent = head;
		while(current != null){
			count++;
			current = current.getNext();
		}
		
		
		int elementFromLast = count - number;
		count = 1;
		while(elementFromLast != count){
			count++;
			newCurrent = newCurrent.getNext();
		}
		return newCurrent;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(12);
		Node previous = root;
		for(int i=1;i<10;i++){
			Node next = new Node((int)(Math.random()*11));
			previous.setNext(next);
			previous = next;
		}
		System.out.println(root.printForward());
		Node requiredNode=findElementFromLast(root,6 );
		System.out.println(requiredNode.getData());

	}

}
