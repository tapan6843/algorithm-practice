/**
 * 
 */
package chapter2_1;

/**
 * @author Tapan
 *
 */
public class Question {
	
	public static void removeDuplicate(Node head){
		
		Node current = head.getNext();
		Node previous = head;
		while(current != null){
			Node temp = head;
			while(temp != current){
				if(temp.getData() == current.getData()){
					previous.setNext(current.getNext());
					current = current.getNext();
					break;
				}else{
					temp=temp.getNext();
				}
			}
			if(temp == current){
				previous = current;
				current = current.getNext();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(1);
		Node previous = root;
		for(int i=1;i<6;i++){
			Node next = new Node((int)(Math.random()*11));
			previous.setNext(next);
			previous = next;
		}
		System.out.println(root.printForward());
		removeDuplicate(root);
		System.out.println(root.printForward());
	}

}
