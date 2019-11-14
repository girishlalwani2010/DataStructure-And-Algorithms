package datastructure.tree;

public class MaxContiguousProductSubArray {

	
	// In this there is three Conditions 
	
	static int printMaxContiguousProductSubArray(int arr[]){
		int max_Ending_Here = 1, min_Ending_Here = 1, temp, max_So_Far = Integer.MIN_VALUE;
		
		for(int i=0; i< arr.length; i++){
			
			//1. if the element inside the array is greater than 0, then going forward multiply it with old max_Ending_Here, to maintain the maximum product, 
			//and min_Ending_Here should be one in this case.
			//2. 
			if(arr[i]>0){
				max_Ending_Here = max_Ending_Here * arr[i];
				min_Ending_Here = Math.min(min_Ending_Here*arr[i], 1);
			}
			
			else if(arr[i] == 0){
				max_Ending_Here = 1;
				min_Ending_Here = 1;
			}
			
			else {
				//If after all positives one negative comes then we have to make max_Ending_Here = 1, and maintain a minimum in min_Ending_Here.
				// there could be case that again one more negative comes  in future to hanlde that we are using Math.max, same for above math.min
				temp = max_Ending_Here;
				max_Ending_Here = Math.max(min_Ending_Here*arr[i], 1);
				min_Ending_Here = temp*arr[i];
			}
			
			if(max_So_Far < max_Ending_Here){
				max_So_Far = max_Ending_Here;
			}
			
		}
		
		return max_So_Far;
		
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 1, -2, -5, 2, 2, -2, -2 };
		//int arr[] = {6,-3,-10,0,2};
		System.out.println(printMaxContiguousProductSubArray(arr));
	}
	
	
	
	
}
