/**
 * 
 */
package classes;

/**
 * @author Tapan
 *
 */
public class ListNode {
	
	
	public ListNode(int data) {
		this.data = data;
	}
	
	private int data;
	private ListNode next;
	private boolean visited;
	private int level;
	
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
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
	 * @return the next
	 */
	public ListNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(ListNode next) {
		this.next = next;
	}
	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}
	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	/**
	 * Adds the.
	 *
	 * @param headNode the head node
	 * @param newNode the new node
	 * @return the list node
	 */
	public ListNode add(ListNode newNode) {
		ListNode headNode = this;
		ListNode currentNode = headNode;
		ListNode previousNode = headNode;
		while (currentNode != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}

		previousNode.setNext(newNode);
		return headNode;
	}
	
	/**
	 * Size.
	 *
	 * @param headNode the head node
	 * @return the int
	 */
	public int size(ListNode headNode){
		int size = 0;
		if(headNode == null){
			return size;
		}else{
			ListNode current = headNode;
			
			while(current != null){
				size ++;
				current = current.getNext();
			}
			return size;
		}
	}

}
