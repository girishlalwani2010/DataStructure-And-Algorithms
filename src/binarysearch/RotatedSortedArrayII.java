package binarysearch;

public class RotatedSortedArrayII {

    
    /* Searches an element key in a  
       pivoted sorted array arrp[] 
       of size n */
	static int search(int nums[], int target) 
    { 
	   int n=nums.length;	
       int pivot = findPivot(nums, 0, n-1); 
        
       // If we didn't find a pivot, then  
       // array is not rotated at all 
       if (pivot == -1) 
           return binarySearch(nums, 0, n-1, target); 
        
       // If we found a pivot, then first  
       // compare with pivot and then 
       // search in two subarrays around pivot 
       if (nums[pivot] == target) 
           return pivot; 
       if (nums[0] <= target) 
           return binarySearch(nums, 0, pivot-1, target); 
       return binarySearch(nums, pivot+1, n-1, target); 
    } 
       
    /* Function to get pivot. For array  
       3, 4, 5, 6, 1, 2 it returns 
       3 (index of 6) */
    static int findPivot(int arr[], int low, int high) 
    { 
       // base cases 
       if (high < low)   
            return -1; 
       if (high == low)  
            return low; 
         
       /* low + (high - low)/2; */
       int mid = (low + high)/2;    
       if (mid < high && arr[mid] > arr[mid + 1]) 
           return mid; 
       if (mid > low && arr[mid] < arr[mid - 1]) 
           return (mid-1); 
       if (arr[low] >= arr[mid]) 
           return findPivot(arr, low, mid-1); 
       return findPivot(arr, mid + 1, high); 
    } 
       
    /* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high, int key) 
    { 
       if (high < low) 
           return -1; 
       /* low + (high - low)/2; */       
       int mid = (low + high)/2;   
       if (key == arr[mid]) 
           return mid; 
       if (key > arr[mid]) 
           return binarySearch(arr, (mid + 1), high, key); 
       return binarySearch(arr, low, (mid -1), key); 
    } 
    
    // main function 
    public static void main(String args[]) 
    { 
       // Let us search 3 in below array 
       //int arr1[] = {1,5,3};
       //int arr1[] = {3, 4, 5, 6, 1, 2} ;
       //int arr1[] = {3,5,1};
       //int arr1[] = {1,2,3,4,5};
       int arr1[] = {4,3,2,1,7,6,5};
       int n = arr1.length; 
       int key = 3; 
       System.out.println("Index of the element is : "
                      + search(arr1, key)); 
    } 
}
