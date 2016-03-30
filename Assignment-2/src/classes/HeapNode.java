/**
 * 
 */
package classes;

/**
 * @author Tapan
 *
 */
public class HeapNode {
	
	private int priority;
	private String value;
	
	public HeapNode(int priority,String value) {
		
		this.priority = priority;
		this.value = value;
	}
	
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
