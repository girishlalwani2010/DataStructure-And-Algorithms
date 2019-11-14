package algo.binarysearch;

/**
 * @author girish_lalwani
 *SplitArray LargestSum Variant
 */
public class CapacityToShipPackagesWithinDDays {
	int ans = Integer.MAX_VALUE;
	int n,m;
	
	public void shipWithinDDays(int[] weights, int i, int days, int currSum, int currMax) {
		System.out.println("ShipWithinDDays" );
		if(i==n && days==m) {
			ans = Math.min(ans,currMax);
			return;
		}
		if(i==n) {
			return;
		}
		if(i>0) {
			 shipWithinDDays(weights,i+1,days,currSum+weights[i],Math.max(currSum+weights[i], currMax));
		}
		if(days<m) {
			shipWithinDDays(weights,i+1,days+1,weights[i],Math.max(weights[i], currMax));
		}
	}
	
	public int shipWithinDays(int[] weights, int D) {
		n = weights.length;
		m = D;
		shipWithinDDays(weights,0,0,0,0);
		return ans;
	}
	
	public int shipWithinDaysDP(int[] weights, int D) {
		int noOfWeights = weights.length;
		int[][] dp = new int[noOfWeights+1][D+1];
		for (int i = 0; i <= noOfWeights; i++) {
			for (int j = 0; j <= D; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		int sumArray[] = new int[noOfWeights+1];
		sumArray[0]=0;
		for(int i=0;i<noOfWeights; i++) {
			sumArray[i+1] = sumArray[i] + weights[i];
		}
		dp[0][0]=0;
		for (int i = 1; i <= noOfWeights; i++) {
			for (int j = 1; j <= D; j++) {
				for(int k=0; k<i; k++) {
					dp[i][j] = Integer.min(dp[i][j], Integer.max(dp[k][j-1],sumArray[i]-sumArray[k]));
				}
			}
		}
		
		return dp[noOfWeights][D];
		
	}

	/**
	 * @param weights
	 * @param D
	 * @return
	 * 
	 * if count subArrays are found lower than D then choosen mid is higher we have to decrease it, 
	 * and if subArrays are found greater than D  then choosen mid is lower we have increase it
	 * 
	 */
	public int shipWithinDaysWithBinarySearch(int[] weights, int D) {
		long low=Integer.MIN_VALUE,high=0;
		for(int i=0; i<weights.length; i++) {
			low = Long.max(weights[i], low);
			high = high + weights[i];
		}
		long mid=0, ans=Integer.MAX_VALUE;
		while(low<=high) {
			long sum =0;
			int countSubArrays=1;
			mid = low+(high-low)/2;
			for(int i=0; i<weights.length; i++) {
				if(weights[i]+sum>mid) {
					countSubArrays++;
					sum = weights[i];
				}else {
					sum = sum + weights[i];
				}
			}
			if(countSubArrays<=D) {
				ans = Long.min(ans, mid);
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return (int)ans;
	} 
	
	
	public static void main(String[] args) {
		int[] weights = {1,2,3,4,5,6,7,8,9,10};
		int D=5;
		CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
		System.out.println(capacityToShipPackagesWithinDDays.shipWithinDaysWithBinarySearch(weights, D));
		
	}

}
