package chapter2_5;

public class Node {
	
	private int data;
	private Node previous;
	private Node next;
	
	public Node(int data){
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the previous
	 */
	public Node getPrevious() {
		return previous;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}

}
