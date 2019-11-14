package array;

public class MinDistanceBetweenTwoNumbers {
	
	static int minDistance(int arr[], int x, int y) {
		int xthIndex=-1,ythIndex=-1;
		int minDistance = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == x) {
				xthIndex = i;
			}
			if(arr[i] == y) {
				ythIndex = i;
			}
			
			if((xthIndex!=-1) && (ythIndex!=-1) && minDistance>(Math.abs(xthIndex-ythIndex))) {
				minDistance = Math.abs(xthIndex-ythIndex);
			}
		}
		
		return minDistance;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		System.out.println(minDistance(arr,3,6));
	}

}
