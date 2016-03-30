/**
 * 
 */
package classes;

/**
 * @author Tapan
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int min = 1000;
		int max = 2000;
		SevenHeap heap = new SevenHeap(1000);
		for(int i=0; i<1000;i++){
			int priority = (int) ((Math.random()*(max-min))+min);
			String val = "Element-"+i;
			heap.insert(priority, val); //insert
		}
		
		for (int i = 0; i < 1000; i++) {
			
			HeapNode deleteNode=heap.deleteMax();
			System.out.println(deleteNode.getValue()+"====>"+deleteNode.getPriority());
			
		}

	}

}
