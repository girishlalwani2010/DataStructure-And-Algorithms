package dp;

public class EggDropProblem {
	
	/* Function to get minimum number of  
    trials needed in worst case with n  
    eggs and k floors */
    /**
     * 
     * We have N eggs and K floors 
     * What is the least number of eggdroppings/attempts that is guaranteed to find the highest floor from which the egg won't break if dropped   
     * @param n
     * @param k
     * @return
     * 
     */
    public static int eggDrop(int n, int k)  
    {
    	if(k==0 || k==1) {
    		return k;
    	}
    	if(n==1) {
    		return k;
    	}
    	
    	int result, minResult = Integer.MAX_VALUE;
    	for(int x=1; x<=k; x++) {
    		result = Integer.max(eggDrop(n-1,x-1),eggDrop(n,k-x));
    		if(result<minResult) {
    			minResult = result;
    		}
    	}
		return minResult+1;
    }  
    
    /**
     * @param n
     * @param k
     * @return
     * Attached image on gmail.
     */
    static int eggDropWithDP(int n, int k) 
    { 
       /* A 2D table where entery eggFloor[i][j] will represent minimum 
       number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n+1][k+1]; 
        int res; 
        int i, j; 
           
        // We need one trial for one floor and0 trials for 0 floors 
        for (i = 1; i <= n; i++) 
        { 
            eggFloor[i][1] = 1; 
            eggFloor[i][0] = 0; 
        } 
           
       // We always need j trials for one egg and j floors. 
        for (j = 1; j <= k; j++) 
            eggFloor[1][j] = j; 
           
        // Fill rest of the entries in table using optimal substructure 
        // property 
        for (i = 2; i <= n; i++) 
        { 
            for (j = 2; j <= k; j++) 
            { 
            	eggFloor[i][j] = Integer.MAX_VALUE; 
            	for(int x=1; x<=j; x++) {
            		res = 1 + Math.max(eggFloor[i-1][x-1],eggFloor[i][j-x]);
            		eggFloor[i][j] = Math.min(eggFloor[i][j], res);
            	}
            } 
        } 
           
        // eggFloor[n][k] holds the result 
        return eggFloor[n][k]; 
  
    } 
    
    
    /**
     * @param x
     * @param n
     * @param k
     * @return
     * 
     * 
 K - Number of eggs - given N - Number of floors - given A - Minimum number of attempts - to find

Egg dropping puzzle follows binomial expansion.

1 egg - N floors - A attempts
N = A/1!

2 eggs - N floors - A attempts
N = A/1! + A(A-1)/2!

3 eggs - N floors - A attempts
N = A/1! + A(A-1)/2! + A(A-1)(A-2)/3!

K eggs - N floors - A attempts
N = A/1! + A(A-1)/2! + ... + A(A-1)(A-2)...(A-K-1)/K!

Now for K eggs, N floors, A attempts, we have to stop computing when it exceeds N - O(K)

// // Time Complexity O(log(floors)*eggs)
     */
    static int binomialCoeff(int x, int n, int k) 
    { 
        int sum = 0, term = 1; 
        for (int i = 1; i <= n && sum < k; ++i) { 
            term *= x - i + 1; 
            term /= i; 
            sum += term; 
        } 
        return sum; 
    } 
      
    // Do binary search to find minimum  
    // number of trials in worst case. 
    static int minTrials(int n, int k) 
    { 
        // Initialize low and high as 1st  
        //and last floors 
        int low = 1, high = k; 
      
        // Do binary search, for every mid,  
        // find sum of binomial coefficients and  
        // check if the sum is greater than k or not. 
        while (low <= high) { 
            int mid = (low + high) / 2; 
            if (binomialCoeff(mid, n, k) < k) 
                low = mid + 1; 
            else
                high = mid -1; 
        } 
      
        return low; 
    } 
      
    // Time Complexity O(floors*eggs*log(floors))
    public int superEggDropWithDPandBS(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        return helper(K, N, memo);
    }
    private int helper(int K, int N, int[][] memo) {
        if (N <= 1) {
            return N;
        }
        if (K == 1) {
            return N;
        }
        if (memo[K][N] > 0) {
            return memo[K][N];
        }
        
        int low = 1, high = N, result = N;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int left = helper(K - 1, mid - 1, memo);
            int right = helper(K, N - mid, memo);
            result = Math.min(result, Math.max(left, right) + 1);
            if (left == right) {
                break;
            } else if (left < right) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        memo[K][N] = result;
        return result;
    }
    // Driver code  
    public static void main(String args[])  
    {  
        int n = 2, k = 4;
        System.out.print("Minimum of drops required from which egg does not break if dropped "
                + n + " eggs and " + k  
        + " floors is " + minTrials(n, k));  
    }  

}
