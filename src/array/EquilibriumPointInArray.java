package array;

public class EquilibriumPointInArray {

	private static int leftSum;
	private static int rightSum;
	
	private static int findEquilibriumIndex(int[] arr) {
		for(int i=0; i<arr.length;i++){
			if(leftSum == rightSum){
				System.out.println("Equi Index is : "+i);
				return i;
			}
			if(i == arr.length-1) {
				return -1;
			}
			leftSum = leftSum + arr[i];
			rightSum = rightSum - arr[i+1];
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,7,6,4};
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum = sum + arr[i];
		}
		leftSum = 0;
		rightSum = sum - arr[0];
		
		findEquilibriumIndex(arr);
	}

}
