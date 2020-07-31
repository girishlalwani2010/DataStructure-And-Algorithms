package array;

public class MinimumInSortedAndRotatedArray {

	public static int findMin(int[] nums) {
        int lo=0, hi=nums.length-1;
        if(nums[lo]<nums[hi]){
            return nums[0];
        }
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            else if(nums[mid]>nums[hi]){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return nums[lo];
    }
	
	public static void main(String[] args) {
		int arr[] =  {4,3,2,1};
        System.out.println("The minimum element is "+ findMin(arr));
	}
	
}
