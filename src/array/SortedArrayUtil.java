package array;

public class SortedArrayUtil{
	
	private static int findFirstOccurence(int []arr, int item, int low, int high){
		if(low<=high){
			int mid = low + (high-low)/2;
			if(mid==0 || arr[mid] == item && arr[mid]>arr[mid-1]){
				return mid;
			}
			if(arr[mid]>=item){
				return findFirstOccurence(arr, item, low, mid);
			}
			else{
				return findFirstOccurence(arr, item, mid+1, high);
			}
		}
		return -1;
	}
	
	private static int findLastOccurence(int []arr, int item, int low, int high){
		if(low<=high){
			int mid = low + (high-low)/2;
			if(mid == arr.length-1 || arr[mid] == item && arr[mid]<arr[mid+1]){
				return mid;
			}
			if(arr[mid]>item){
				return findLastOccurence(arr, item, low, mid);
			}
			else{
				return findLastOccurence(arr, item, mid+1, high);
			}
		}
		return -1;
	}
	
	private static int findOccurencesOfAnElement(int []arr, int item, int low, int high){
		
		return findLastOccurence(arr,item,low,high)-findFirstOccurence(arr,item,low,high)+1;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 2, 2, 2, 4, 7 ,8 ,8 };
		
		System.out.println(findOccurencesOfAnElement(arr, 2, 0, arr.length-1));
	}
}