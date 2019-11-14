package datastructure.array;
class MountainSubArray 
{ 
    // Utility method to construct left and right array 
    static void preprocess(int arr[], int N, int left[], int right[]) 
    { 
        // initialize first left index as that index only 
        left[0] = 0; 
        int lastIncr = 0; 
      
        for (int i = 1; i < N; i++) 
        { 
            // if current value is greater than previous, 
            // update last increasing 
            if (arr[i] > arr[i - 1]) 
                    lastIncr = i; 
            left[i] = lastIncr; 
        } 
      
        // initialize last right index as that index only 
        right[N - 1] = N - 1; 
        int firstDecr = N - 1; 
      
        for (int i = N - 2; i >= 0; i--) 
        { 
            // if current value is greater than next, 
            // update first decreasing 
            if (arr[i] > arr[i + 1]) 
                    firstDecr = i; 
            right[i] = firstDecr; 
        } 
    } 
      
    // method returns true if arr[L..R] is in mountain form 
    static boolean isSubarrayMountainForm(int arr[], int left[], 
                                    int right[], int L, int R) 
    { 
        // return true only if right at starting range is 
        // greater than left at ending range 
        return (right[L] >= left[R]); 
    } 
      
    public static void main(String[] args) 
    { 
        int arr[] = {2, 3, 2, 4, 4, 6, 3, 2}; 
        int N = arr.length; 
        int left[] = new int[N]; 
        int right[] = new int[N]; 
        preprocess(arr, N, left, right); 
        int L = 0; 
        int R = 2; 
          
        if (isSubarrayMountainForm(arr, left, right, L, R)) 
            System.out.println("Subarray is in mountain form"); 
        else
            System.out.println("Subarray is not in mountain form"); 
      
        L = 1; 
        R = 3; 
      
        if (isSubarrayMountainForm(arr, left, right, L, R)) 
            System.out.println("Subarray is in mountain form"); 
        else
            System.out.println("Subarray is not in mountain form"); 
    } 
} 