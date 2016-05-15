/**
 * 
 */
package classes;


/**
 * @author Tapan
 *
 */
public class Queue {
	
	private ListNode rear=null;
	private ListNode front=null;
	
	
	/**
	 * Enqueue.
	 *
	 * @param newNode the new node
	 */
	public void enqueue(ListNode newNode){
		if(rear == null){
			rear = newNode;
			front = rear;
		}else{
			rear.setNext(newNode);
			rear = rear.getNext();
		}
	}
	
	
	/**
	 * Dequeue.
	 *
	 * @return the list node
	 */
	public ListNode dequeue(){
		ListNode oldNode = null;
		if(front != null){
			oldNode = front;
			front = front.getNext();
		}
		return oldNode;
	}
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty(){
		
		if(front == null){
			return true;
		}
		return false;
	}

}
