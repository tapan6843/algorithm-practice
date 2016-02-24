/**
 * 
 */



/**
 * @author Tapan,Niket and Dhiral
 *
 */
public class Stack {
	
	
	private Node top=null;
	
	/**
	 * Push.
	 *
	 * @param data the data
	 */
	public void push(int data){
		
		Node newNode = new Node(data);
		
		Node previous=null;
		
		if(top == null){
			top = newNode;
		}else{
			previous = top;
			top = newNode;
			top.setNext(previous);
		}
	}
	
	/**
	 * Pop.
	 *
	 * @return the integer
	 */
	public Integer pop(){
		Integer data =  null;
		if(top != null){
			data = top.getData();
			top = top.getNext();
		}
		return data;
	}

}
