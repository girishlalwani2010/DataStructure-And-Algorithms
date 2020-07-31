package dp;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
	
    public boolean canPartition(int[] nums){
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2 == 1){
            return false;
        }
        return canPartition(nums, 0, sum/2);
    }
    
    Map<String,Boolean> memo = new HashMap<>();
    
    private boolean canPartition(int[] nums, int start, int sum){
        String key = start+"|"+sum;
        if(sum<0){
            memo.put(key,false);
            return false;
        }
        
        if(sum==0){
            return true;
        }
        
        if(memo.containsKey(key)){
        	System.out.println("Key: "+key);
            return memo.get(key);
        }
        
        for(int i=start; i<nums.length; i++){
            if(canPartition(nums, i+1, sum-nums[i])){
                return true;
            }
        }
        memo.put(key,false);
        return false;
    }
	
	public static void main(String[] args) {
		PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
		int[] nums = {1, 0, 1, 2}; 
		partitionEqualSubsetSum.canPartition(nums);
	}
}
