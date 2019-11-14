package datastructure.array;
import java.util.*; 
  
class MaxOfAllSubArrayOfSizeKUsingStack  
{ 
  
    // Function to print the maximum for 
    // every k size sub-array 
    static void print_max(int a[], int n, int k) 
    { 
        // max_upto array stores the index 
        // upto which the maximum element is a[i] 
        // i.e. max(a[i], a[i + 1], ... a[max_upto[i]]) = a[i] 
  
        int[] max_upto = new int[n]; 
  
        // Update max_upto array similar to 
        // finding next greater element 
        Stack<Integer> s = new Stack<>(); 
        s.push(0); 
        for (int i = 1; i < n; i++) 
        { 
            while (!s.empty() && a[s.peek()] < a[i]) 
            { 
                max_upto[s.peek()] = i - 1; 
                s.pop(); 
            } 
            s.push(i); 
        } 
        while (!s.empty()) 
        { 	
            max_upto[s.peek()] = n - 1; 
            s.pop(); 
        } 
        int j = 0; 
        for (int i = 0; i <= n - k; i++) 
        { 
  
            // j < i is to check whether the 
            // jth element is outside the window 
            while (j < i || max_upto[j] < i + k - 1) 
            { 
                j++; 
            } 
            System.out.print(a[j] + " "); 
        } 
        System.out.println(); 
    } 
  
    // Driver code 
    public static void main(String[] args)  
    { 
        int a[] = {5,3,4,6}; 
        int n = a.length; 
        int k = 3; 
        print_max(a, n, k); 
  
    } 
} 