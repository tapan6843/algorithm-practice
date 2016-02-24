/**
 * Implement an algorithm to delete a node in the middle of a linked list, given
 * only access to that node 
 * EXAMPLE
 * Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */
package chapter2_3;

import chapter2_1.Node;

/**
 * @author Tapan
 *
 */
public class Question {
	
	public static Node removeNode(Node deleteNode){
		
		if(deleteNode == null){
			return null;
		}
		
		if(deleteNode.getPrevious() == null){
			deleteNode.getNext().setPrevious(null);
			return deleteNode;
		}
		
		if(deleteNode.getNext() == null){
			deleteNode.getPrevious().setNext(null);;
			return deleteNode;
		}
		
		Node beforeNode = deleteNode.getPrevious();
		while(beforeNode.getPrevious() != null){
			beforeNode = beforeNode.getPrevious();
		}
		Node newNode = beforeNode;
		while(newNode != null){
			newNode = newNode.getNext();
			if(newNode == deleteNode){
				newNode.getPrevious().setNext(newNode.getNext());
				newNode.getNext().setPrevious(newNode.getPrevious());
			}
		}
		
		return beforeNode;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(7);
		Node previous = root;
		for(int i=1;i<10;i++){
			Node next = new Node((int)(Math.random()*11));
			previous.setNext(next);
			next.setPrevious(previous);
			previous = next;
		}
		System.out.println(root.printForward());
		Node deleteNode = root;
		for(int j=0;j<6;j++){
			deleteNode = deleteNode.getNext();
			if(j==5){
				Node newNode=removeNode(deleteNode);
				System.out.println(newNode.printForward());
			}
		}

	}

}
