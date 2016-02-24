/**
 * 
 */
package chapter4_1;

/**
 * @author Tapan
 *
 */
public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		TreeNode root = TreeNode.createTree(array,0,array.length-1);
		
		heightOfTree(root);
		
	}
	
	public static int heightOfTree(TreeNode root){
	int leftHeight,rightHeight;
	if(root == null){
		return 0;
	}else {
		leftHeight = heightOfTree(root.getLeftChild());
		rightHeight = heightOfTree(root.getRightChild());
		if(leftHeight > rightHeight){
			return leftHeight +1;
		}else{
			return rightHeight+1;
		}
	}
	
	}

}
