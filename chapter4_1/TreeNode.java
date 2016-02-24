/**
 * 
 */
package chapter4_1;

/**
 * @author Tapan
 *
 */
public class TreeNode {
	
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private TreeNode parent;
	
	public TreeNode(int data) {
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
	 * @return the leftChild
	 */
	public TreeNode getLeftChild() {
		return leftChild;
	}
	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
		if (leftChild != null) {
			leftChild.parent = this;
		}
	}
	/**
	 * @return the rightChild
	 */
	public TreeNode getRightChild() {
		return rightChild;
	}
	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
		if (rightChild != null) {
			rightChild.parent = this;
		}
	}
	/**
	 * @return the parent
	 */
	public TreeNode getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public static TreeNode createTree(int[] arr, int start, int end){
		
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(createTree(arr, start, mid - 1));
		n.setRightChild(createTree(arr, mid + 1, end));
		return n;
	}

}
