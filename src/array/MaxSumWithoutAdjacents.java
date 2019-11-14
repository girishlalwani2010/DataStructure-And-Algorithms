package array;

public class MaxSumWithoutAdjacents {

	public int getMaxSumWithoutAdjacent(int arr[]){
		
		int sumStartFromOdd = arr[0];
		
		for(int i=0; i<arr.length;){
			
			if(i+3<arr.length){
				if(arr[i+2] > arr[i+3]){
					sumStartFromOdd = sumStartFromOdd + arr[i+2];
					i=i+2;
				}
				else{
					sumStartFromOdd = sumStartFromOdd + arr[i+3];
					i=i+3;
				}
			}
			else{
				if(i+2<arr.length){
					sumStartFromOdd = sumStartFromOdd + arr[i+2];
					i=i+2;
				}
				else{
					i++;
				}
			}
			
		}
		
		
		int sumStartFromEven = arr[1];
		
		for(int i=1; i<arr.length;){
			
			if(i+3<arr.length){
				if(arr[i+2] > arr[i+3]){
					sumStartFromEven = sumStartFromEven + arr[i+2];
					i=i+2;
				}
				else{
					sumStartFromEven = sumStartFromEven + arr[i+3];
					i=i+3;
				}
			}
			else{
				if(i+2<arr.length){
					sumStartFromEven = sumStartFromEven + arr[i+2];
					i=i+2;
				}
				else{
					i++;
				}
			}
			
		}
		
		
		return Math.max(sumStartFromOdd, sumStartFromEven);
		
	}
	
	private int getMaxSumWithoutAdjacentWithDP(int arr[]){

		int second = arr[1];
		int sum=0;
		int first = arr[0];
		
		if(first>second){
			second = first;
		}
		
		
		for(int i=2; i<arr.length; i++){
			sum = arr[i] + first;
			
			if(second>sum){
				sum = second;
			}
			
			first = second;
			second = sum;
			
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		MaxSumWithoutAdjacents maxSumWithoutAdjacents = new MaxSumWithoutAdjacents();
		int arr[] = {3,2,7,10,1,15};
		System.out.println(maxSumWithoutAdjacents.getMaxSumWithoutAdjacentWithDP(arr));	
	}
	
}
