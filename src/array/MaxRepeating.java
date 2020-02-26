package array;

class MaxRepeating {

	// Returns maximum repeating element in arr[0..n-1].
	// The array elements are in range from 0 to k-1
	static int maxRepeating(int arr[], int n, int k) 
    { 
        // Iterate though input array, for every element 
        // arr[i], increment arr[arr[i]%k] by k 
        for (int i = 0; i< n; i++) 
            arr[(arr[i]%k)] += k; 
  
        // Find index of the maximum repeating element 
        int max = arr[0], result = 0; 
        for (int i = 1; i < n; i++) 
        { 
            if (arr[i] > max) 
            { 
                max = arr[i]; 
                result = i; 
            } 
        } 
  
        /* Uncomment this code to get the original array back 
        for (int i = 0; i< n; i++) 
          arr[i] = arr[i]%k; */
  
        // Return index of the maximum element 
        return result; 
    } 

	/* Driver function to check for above function */
	public static void main(String[] args) {
		int arr[] = { 2, 3, 3, 2, 5, 1, 0 };
		// {1,2,2,2,0,2,0,2,3,8,0,9,2,3}
		int n = arr.length;
		int k = 6;
		System.out.println("Maximum repeating element is: " + maxRepeating(arr, n, k));
	}
}