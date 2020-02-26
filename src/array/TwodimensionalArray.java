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
	static void rotate90Clockwise(int a[][]) 
	{ 
	  
	    // Traverse each cycle 
	    for (int i = 0; i < a.length / 2; i++) 
	    { 
	        for (int j = i; j < a.length - i - 1; j++) 
	        { 
	  
	            // Swap elements of each cycle 
	            // in clockwise direction 
	            int temp = a[i][j]; 
	            a[i][j] = a[a.length - 1 - j][i]; 
	            a[a.length - 1 - j][i] = a[a.length - 1 - i][a.length - 1 - j]; 
	            a[a.length - 1 - i][a.length - 1 - j] = a[j][a.length - 1 - i]; 
	            a[j][a.length - 1 - i] = temp; 
	            System.out.println("Swapped Elements :");
	            System.out.println("[i,j]:"+i+","+j);
	            System.out.println("[i,j]:"+(a.length - 1 - j)+","+i);
	            System.out.println("[i,j]:"+(a.length - 1 - i)+","+(a.length - 1 - j));
	            System.out.println("[i,j]:"+j+","+(a.length - 1 - i));
	        } 
	    } 
	} 
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotate90Clockwise(matrix);
	}

}
