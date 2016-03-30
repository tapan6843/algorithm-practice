/**
 * 
 */
package classes;

import com.sun.glass.ui.Size;

/**
 * @author Tapan
 *
 */
public class SevenHeap {
		
	private HeapNode[] heapArray;
	private  int count;
	private int capacity;
	
	public SevenHeap() {
		
	}
	public SevenHeap(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		this.heapArray = new HeapNode[capacity];
	}
	/**
	 * @return the heapArray
	 */
	public HeapNode[] getHeapArray() {
		return heapArray;
	}
	/**
	 * @param heapArray the heapArray to set
	 */
	public void setHeapArray(HeapNode[] heapArray) {
		this.heapArray = heapArray;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * Insert.
	 *
	 * @param priority the priority
	 * @param value the value
	 */
	public void insert(int priority,String value){
		
		HeapNode node = new HeapNode(priority,value); //create heap node
		
		int tempCount = count;
		
		while(tempCount > 0 && priority > heapArray[(tempCount-1)/7].getPriority()){
			heapArray[tempCount] = heapArray[(tempCount-1)/7];
			tempCount =  (tempCount-1)/7;
		}
		heapArray[tempCount] = node; //insert node
		count++;
	}
	
	/**
	 * Delete max.
	 *
	 * @return the heap node
	 */
	public HeapNode deleteMax(){
		
		if(count == 0){
			return null; //If heap is empty
		}
		
		HeapNode maxHeap = heapArray[0]; //Max Heap is always top
		int currentNode = 0;
		
		int firstChildIndex = getChildIndex(currentNode, 1);
		while(firstChildIndex < count){
			int lastChildIndex = getChildIndex(currentNode, 7);
			
			if(lastChildIndex > count){
				lastChildIndex =  count;
			}
			
			int maxChildIndex = firstChildIndex;
			while(firstChildIndex < lastChildIndex){
				if(heapArray[firstChildIndex].getPriority() > heapArray[maxChildIndex].getPriority()){
					maxChildIndex = firstChildIndex;
				}
				firstChildIndex++;
			}
			heapArray[currentNode] = heapArray[maxChildIndex];
			currentNode = maxChildIndex;
		}
		heapArray[currentNode] = heapArray[count-1];
		count--;
		
		if(currentNode < count){
			while(currentNode != 0){
				int parentIndex = (currentNode-1)/7;
				if(heapArray[currentNode].getPriority() > heapArray[parentIndex].getPriority()){
					HeapNode tempNode = heapArray[currentNode];
					heapArray[currentNode] = heapArray[parentIndex];
					heapArray[parentIndex]=tempNode;
					currentNode = parentIndex;
				}else{
					break;
				}
			}
		}
		
		return maxHeap;
		
		
	}
	
	/**
	 * Gets the child index.
	 *
	 * @param parentIndex the parent index
	 * @param childIndex the child index
	 * @return the child index
	 */
	public int getChildIndex(int parentIndex,int childIndex){
		
		return 7*parentIndex + childIndex; //retrieve child index
	}
	
	
}
