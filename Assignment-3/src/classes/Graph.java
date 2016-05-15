/**
 * 
 */
package classes;

/**
 * @author Tapan
 *
 */
public class Graph {
	
	final static int TOTAL_VERTEX = 4039; //Given!
	
	private ListNode[] list;
	
	public Graph() {
		list = new ListNode[TOTAL_VERTEX]; //initialize array of list
	}
	
	/**
	 * @return the list
	 */
	public ListNode[] getList() {
		return list;
	}



	/**
	 * @param list the list to set
	 */
	public void setList(ListNode[] list) {
		this.list = list;
	}



	public void addEdge(int source, int destination){
			
		if(source >= 0 && destination >= 0){
			insertEdge(source, destination);
			insertEdge(destination,source);
		}
	}

	/**
	 * @param source
	 * @param destination
	 */
	private void insertEdge(int source, int destination) {
		ListNode newNode = new ListNode(destination);
		ListNode headNode = list[source];
		if(headNode != null){
			list[source] = headNode.add( newNode);
		}else{
			headNode = new ListNode(source);
			list[source] = headNode.add(newNode);
		}
	}

}
