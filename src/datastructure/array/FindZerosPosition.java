package datastructure.array;

public class FindZerosPosition {

	private static void findZeros(int arr[], int m)
	{
		int wL=0, wR=0, zeroCount=0,bestWindow=0, i=0, bestL=0;;
		while(wR<arr.length){
			
			if(zeroCount>m){
				
				if(arr[wL] == 0)
				{
					zeroCount--;
				}
				wL++;
			}
			if(zeroCount<=m){
				
				if(arr[wR] == 0){
					zeroCount++;
				}
				wR++;
			}
			
			if(wR-wL>bestWindow){
				bestWindow = wR-wL;
				bestL=wL;
			}
			
			
		}
		
		for(int j=wL; j<bestWindow; j++){
			if(arr[j] == 0){
				System.out.println(j);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
		int m = 2;
		findZeros(arr, m);
	}
	
}
