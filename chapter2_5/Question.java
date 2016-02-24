/**
 * Floyd Algorithm to find beginning node of cyclic Linked list
 */
package chapter2_5;

import chapter2_1.Node;

/**
 * @author Tapan
 *
 */
public class Question {
	
	public static Node isLinkedListCyclic(Node head){
		
		if(head == null){
			return null;
		}
		
		Node fast = head;
		Node slow = head;
		
		while(fast.getNext() != null || fast.getNext().getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast){
				break;
			}
		}
		
		return fast;
	}
	
	public static Node obtainBeginning(Node head){
		Node fast = isLinkedListCyclic(head);
		if(fast != null){
			
			Node slow = head;
			while(slow != fast){
				slow = slow.getNext();
				fast = fast.getNext();
			}
			return slow;
			
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(2);
		Node previous = root;
		Node temp = null;
		for(int i=0;i<10;i++){
			Node next = new Node((int)(Math.random()*9));
			previous.setNext(next);
			previous = next;
			if(i==2){
				temp = previous;
				System.out.println("Begin Node -->"+temp.getData());
			}
			/*if(i==9){
				previous.setNext(temp);
			}*/
			
		}
		
		System.out.println("Found begin Node -->"+ obtainBeginning(root).getData());

	}

}
