/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 *	column is set to 0
 * **/
package chapter1_4;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Question.
 */
public class Question {
	
	/**
	 * Sets the zeros.
	 *
	 * @param matrix the matrix
	 * @return the int[][]
	 */
	public static int[][] setZeros(int[][] matrix){
		
		if(matrix != null){
			List<Integer> rowList = new ArrayList<Integer>();
			List<Integer> columnList = new ArrayList<Integer>();
			for(int row=0;row < matrix.length;row++){
				for(int column=0;column < matrix[row].length;column++){
					if(matrix[row][column] == 0){
						if(!rowList.contains(row) && !columnList.contains(column)){
							rowList.add(row);
							columnList.add(column);
						}
					}
				}
			}
			
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[i].length;j++){
					if(rowList.contains(i) || columnList.contains(j)){
						matrix[i][j]=0;
					}
				}
			}
		}
		return matrix;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int [][] matrix = {{1,2,3,4},{5,0,7,8},{8,9,0,11}};
		
		int[][] newMatrix = setZeros(matrix);
		
		for(int i=0;i<newMatrix.length;i++){
			for(int j=0;j<newMatrix[i].length;j++){
				System.out.print(newMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
