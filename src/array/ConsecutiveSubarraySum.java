package array;

public class ConsecutiveSubarraySum {
	
	private static void printSubArrayIndexes(int[] arr, int target){
		int start=0,sum = 0;
		for(int end=0; end<arr.length; end++){
			sum = sum +arr[end];
			while(sum>target && start<end-1){
				sum = sum - arr[start];
				start++;
			}
			if(sum == target){
				System.out.println("Starting Index : "+start+" Ending Index : "+end);
				break;
			}
			
		}
	}
	
	
	public static void main(String[] args) {	
		int arr[] = {1, 4};
        //int n = arr.length;
       // int sum = 23;
        printSubArrayIndexes(arr, 0);
	}

}
