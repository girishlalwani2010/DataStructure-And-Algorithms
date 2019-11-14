package array;

/**
 * @author girish_lalwani
 *
 *	Given nums = [1,1,1,2,2,3],

	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

	It doesn't matter what you leave beyond the returned length.
 *
 */
public class RemoveDupliocates {
	
	public static int removeDuplicates(int[] nums) {
		if(nums.length ==1) {
			return 1;
		}
		int j=1,k=0;
		for(int i=0; i<nums.length;) {
			if(j<(nums.length) && nums[i] ==  nums[j]) {
				j=j+1;
			}else {
				if(j==(i+1)) {
					nums[k++] = nums[i];
					i++;j++;
				}else {
					nums[k++] = nums[i];
					nums[k++] = nums[j-1];
					i=j;j++;
				}
			}
		}
		return k;
	}
	
	public static void main(String[] args) {
		int []nums = {1,1,1,2,2,3};
		removeDuplicates(nums);
	}

}
