package array;

import java.util.Arrays;

public class TwodimensionalArray {

	/**
	 * Given input matrix = 
		[
		  [1,2,3],
		  [4,5,6],
		  [7,8,9]
		],
		
		rotate the input matrix in-place such that it becomes:
		[
		  [7,4,1],
		  [8,5,2],
		  [9,6,3]
		]
		
		So first will do 
		[		
		  [1,2,3],
		  [4,5,6],
		  [7,8,9]
		]
			To
		[		
		  [7,8,9],
		  [4,5,6],
		  [1,2,3]
		]	
	 */
	public static void rotateBy90degree(int[][] matrix) {
		int cols = matrix.length;
		int rows = matrix[0].length;
		
		for(int row=0; row<rows/2; row++) {
			for(int col=0; col<cols; col++) {
				int temp = matrix[row][col];
				matrix[row][col] = matrix[rows-(row+1)][col];
				matrix[rows-(row+1)][col] = temp;
			}
		}
		
		for(int row=0; row<rows; row++) {
			for(int col=0; col<cols; col++) {
				if(row<=col) {
				int temp = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotateBy90degree(matrix);
	}

}
