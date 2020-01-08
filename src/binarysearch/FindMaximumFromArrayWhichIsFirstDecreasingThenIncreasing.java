package binarysearch;

/**
 * @author girish_lalwani
 *
 *	Find the maximum element in an array which is first increasing and then decreasing
 *	Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
	Output: 500

	Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
	Output: 50
	
	Corner case (No decreasing part)
	Input: arr[] = {10, 20, 30, 40, 50}
	Output: 50
 */
public class FindMaximumFromArrayWhichIsFirstDecreasingThenIncreasing {
	
	static int findMaximum(int arr[], int low, int high){
		
		if (low == high) 
	         return arr[low];
		 
		if(high == low+1 && arr[low]>=arr[high]) {
			 return arr[low];
		}
		
		if(high == low+1 && arr[high]>arr[low]) {
			 return arr[high];
		}
		
		int mid = low + (high-low)/2;
		if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) {
			return arr[mid];
		}
		if(arr[mid]>arr[mid-1]) {
			return findMaximum(arr, mid+1, high);
		}else {
			return findMaximum(arr, low, mid-1);
		}
	}
	
	
	  public static void main (String[] args)  
	    { 
	        int arr[] = {9,8,7,6,5,4,3,2,1}; 
	        int n = arr.length; 
	        System.out.println("The maximum element is "+  
	                            findMaximum(arr, 0, n-1)); 
	    } 

}
