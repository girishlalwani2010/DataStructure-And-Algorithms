package datastructure.array;

public class TransitionPoint {
	
	private int findTP(int arr[], int low, int high){
		if(high>=low){
			
			int mid = low + (high-low)/2;
			
			if(arr[mid-1] < arr[mid]){
				return mid;
			}
			else if(arr[mid]==1){
				return findTP(arr,low,mid-1);
			}
			else{
				return findTP(arr,mid+1,high);
			}	
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {0, 0, 0, 0 , 0, 0, 0, 0, 0, 0, 1, 1};
		TransitionPoint transitionPoint = new TransitionPoint();
		System.out.println(transitionPoint.findTP(arr,0,arr.length-1));
	}

}
