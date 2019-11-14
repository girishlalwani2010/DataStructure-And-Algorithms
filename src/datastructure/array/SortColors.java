package datastructure.array;

/**
 * @author girish_lalwani
 *
 * Two Pointer
 */
public class SortColors {
	
	private static void swap(int[] nums, int a, int b) {
		int temp =nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void sortColors(int[] nums) {
		int start=0, end=nums.length-1, i=0;
		
	    while(i<=end) {
	    	while(end>i && nums[end] == 2) end--;
	    	if(nums[i] == 2) {
	    			swap(nums, i, end);
	    			end--;
	    		}
	    	if(nums[i] == 0) {
	    		swap(nums, start, i);
	    		start++;
	    	}
	    	i++;
	    }
	    
	    for(int j=0; j<nums.length; j++) {
	    	System.out.println(nums[j]);
	    }
	    
	}

	public static void main(String[] args) {
		int[] a = {2,1,2};
		sortColors(a);
		
	}

}
