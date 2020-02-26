package array;

public class Test2 {
	
	public static int maxNutrition1(int n, long k) {
		long maxSum = 0;
		long sum = 0;
		long kthSum = 0;
		int matchingIndex = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
			if (sum == k) {
				kthSum = sum;
				matchingIndex = i;
			}
		}
		sum = (int) ((sum-kthSum)%1000000007);
		maxSum = 0;
		if(kthSum == 0) {
			return (int)sum%1000000007;
		}
		while(matchingIndex > 0) {
			maxSum = Math.max(maxSum, sum+kthSum-matchingIndex);
			matchingIndex--;
		}
		return (int)maxSum%1000000007;
	}
	
	public static void main(String[] args) {
		//2,1
		//3,3
		//2,2
		System.out.println(maxNutrition1(2,2));
	}
	
}
