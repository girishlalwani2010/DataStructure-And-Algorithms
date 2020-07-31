package array;

/**
 * @author girish_lalwani
 *
 *
 * Notes : 
 * 
 * First can be solve using hashmap by putting all positives in it and search will start from 1.
 * Solution with no space in O(n) time:
 * Approach-1. We can segregate negative and positive elements and then will negate all the elements 
 * 	   starting from index=j+1, as we incremented j's count when we find the negative element and
 * 	   and will swap this position-j with negative element, 
 * 	   and after that will negate the elements at index of elements at index j
 * 	   then will search for number starting from j to find the non negative number.   
 *
 *Approach-2. 
 * We can use n+1 as marker if number is less than 0, as missing positive number will be between 1 to n+1.
 * Then will negate the A[A[i]], if it is positive to avoid duplicates.
 * and then will find first positive.
 * https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation	
 *
 *Approach-3, generic can also be used in couple hands and missing number problem.
 * Try to make the position of number starting from i=0, Right - https://leetcode.com/problems/first-missing-positive/discuss/17071/My-short-c%2B%2B-solution-O(1)-space-and-O(n)-time
 * So at one time one number will be at its right place at min, with internal which keep on running 
 * till A[A[i]-1]!=A[i].
 *
 *For ex: {5,4,1,2,3} --swap(5,3)--> {3,4,1,2,5} --swap(3,1)--> {1,4,3,2,5} --swap(4,2)--> {1,2,3,4,5}
 *
 */
public class FirstMissingPositive {
	
    
	 private int segregate(int arr[], int size) 
	    { 
	        int j = size-1, i; 
	        for (i = 0; i <=j;) { 
	            if(arr[j]<=0){
	                j--;
	                continue;
	            }
	            if (arr[i] <= 0) { 
	                int temp; 
	                temp = arr[i]; 
	                arr[i] = arr[j]; 
	                arr[j] = temp; 
	                j--;
	            }
	            i++;
	        }
	        
	  
	        return j; 
	    } 
	    
	    private int findMissingPositive(int arr[], int size) 
	    { 
	        int i; 

	        for (i = 0; i < size; i++) { 
	            int x = Math.abs(arr[i]); 
	            if (x - 1 < size && arr[x - 1] > 0) 
	                arr[x - 1] = -arr[x - 1]; 
	        } 
	        for (i = 0; i < size; i++) 
	            if (arr[i] > 0) 
	                return i + 1;  
	  
	        return size + 1; 
	    }
	    
	    
	    public int firstMissingPositive(int[] arr) {
	        int shift = segregate(arr, arr.length);
	        return findMissingPositive(arr, shift+1); 
	    }
    
    //second way first missing positive in O(n) using generic pattern place the number at its correct position, used in K-Similar Strings, First Missing Positive, Missing Number
 
    int firstMissingPositive(int A[], int n)
    {
        for(int i = 0; i < n; ++ i)
            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
            {
            	int temp = A[A[i] -1];
            	A[A[i] -1] = A[i];
            	A[i] = temp;
            }
        
        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;
        
        return n + 1;
    }
    
    // main function 
    public static void main(String[] args) 
    { 
        int arr[] = {-10,-3,-100,-1000,-239,1}; 
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int missing = firstMissingPositive.firstMissingPositive(arr); 
        System.out.println("The smallest positive missing number is " + missing); 
    } 
}
 