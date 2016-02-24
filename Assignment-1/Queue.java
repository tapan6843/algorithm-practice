/**
 * 
 */



/**
 * @author Tapan,Niket and Dhiral
 *
 */
public class Queue {
	
	private Node rear=null;
	private Node front=null;
	
	/**
	 * Adds the.
	 *
	 * @param data the data
	 */
	public void add(int data){
		if(rear == null){
			rear = new Node(data);
			front = rear;
		}else{
			Node newNode = new Node(data);
			rear.setNext(newNode);
			rear = rear.getNext();
		}
	}
	
	/**
	 * Delete.
	 *
	 * @return the integer
	 */
	public Integer delete(){
		Integer data = null;
		if(front != null){
			data = front.getData();
			front = front.getNext();
		}
		return data;
	}

}
