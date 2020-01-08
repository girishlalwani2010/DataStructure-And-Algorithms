package dp;

/**
 * @author girish_lalwani
 *https://www.youtube.com/watch?v=vtJvbRlHqTA&t=458s - Nice Explanation
 *https://leetcode.com/problems/maximum-product-subarray/submissions/
 */
public class MaxProductSubArray {
	
	    public int maxProduct(int[] arr) {
	       //currMax, currMin, arr[i] , will decide the value of max product till current step. 
	        int prevMaxProduct = arr[0];
	        int prevMinProduct = arr[0];
	        int currMaxProduct = arr[0];
	        int currMinProduct = arr[0];
	        int ans = arr[0];
	       for(int i=1; i<arr.length; i++){
	           currMaxProduct = Math.max(Math.max(prevMaxProduct*arr[i], prevMinProduct*arr[i]), arr[i]);
	           currMinProduct = Math.min(Math.min(prevMaxProduct*arr[i], prevMinProduct*arr[i]), arr[i]);
	           ans = Math.max(ans,currMaxProduct);
	           prevMaxProduct = currMaxProduct;
	           prevMinProduct = currMinProduct;
	       }
	       return ans; 
	    }

}
