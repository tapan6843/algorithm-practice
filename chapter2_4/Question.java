/**
 * You have two numbers represented by a linked list, where each node contains a single digit  The digits are stored in reverse order, such that the 1’s digit is at the head of
	the list  Write a function that adds the two numbers and returns the sum as a linked list 
	EXAMPLE
	Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
    Output: 8 -> 0 -> 8
 */
package chapter2_4;

import chapter2_1.Node;

/**
 * @author Tapan
 *
 */
public class Question {
	
	public static Node sumLinkedList(Node firstHead,Node secondHead){
		
		if(firstHead == null && secondHead == null){
			return new Node(0);
		}
		
		int carry=0;
		int count = 1;
		Node finalNode = null;
		Node newNode = null;
		while(firstHead != null && secondHead != null){
			
			int sum = firstHead.getData() + secondHead.getData()+carry;
			int finalSum = 0;
			if(sum > 10){
				carry = finalSum/10;
				finalSum = sum - 10;
			}else{
				carry = 0;
				finalSum = sum;
			}
			
			
			if(count > 1){
				Node next = new Node(finalSum);
				 finalNode.setNext(next);
				 finalNode = next;
			}else{
				newNode = new Node(finalSum);
				finalNode = newNode;
			}
			firstHead = firstHead.getNext();
			secondHead = secondHead.getNext();
			count++;
		}
		
		return newNode;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(4);
		Node previous = root;
		for(int i=1;i<3;i++){
			Node next = new Node((int)(Math.random()*9));
			previous.setNext(next);
			previous = next;
		}
		System.out.print(root.printForward()+"+");
		Node root1 = new Node(2);
		Node previous1 = root1;
		for(int i=1;i<3;i++){
			Node next = new Node((int)(Math.random()*9));
			previous1.setNext(next);
			previous1 = next;
		}
		System.out.println(root1.printForward());
		Node finalNode = sumLinkedList(root, root1);
		System.out.println(finalNode.printForward());
		

	}

}
