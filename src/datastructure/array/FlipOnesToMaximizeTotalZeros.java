package datastructure.array;

public class FlipOnesToMaximizeTotalZeros {


	
	public static void main(String[] args) {
		
		int arr[] = {0, 1, 0, 0, 1, 1, 0};
		int count = 0;
		int maxCount = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 1){
				count++;
				if(maxCount<count){
					maxCount = count;
				}
			}
			
			else{
				count = 0;
			}
		}
		
		for(int i = 0; i<arr.length; i++){
			if(arr[i] == 0)
				maxCount++;
		}
		
		
		System.out.println(maxCount);
	}
	
}
